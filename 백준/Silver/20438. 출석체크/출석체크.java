import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]) + 3;
        int k = Integer.parseInt(tokens[1]);
        int q = Integer.parseInt(tokens[2]);
        int m = Integer.parseInt(tokens[3]);

        boolean[] studentList = new boolean[n];

        // 졸고 있는 학생 추가
        List<Integer> sleepStudentList = new ArrayList<>();
        updateSleepStudent(br, k, sleepStudentList);

        tokens = br.readLine().split(" ");

        // 출석 번호를 받은 학생들
        List<Integer> code = new ArrayList<>();
        attendance(q, tokens, sleepStudentList, code, studentList);

        // 배수 처리
        calculate(n, sleepStudentList, studentList);

        int[] num = new int[n];
        cumulativeSum(n, studentList, num);

        getSum(m, br, num);
    }

    private static void updateSleepStudent(BufferedReader br, int k, List<Integer> sleepStudentList)
            throws IOException {
        String[] tokens;
        tokens = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            sleepStudentList.add(Integer.parseInt(tokens[i]));
        }
    }

    private static void getSum(int m, BufferedReader br, int[] num) throws IOException {
        String[] tokens;
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            tokens = br.readLine().split(" ");
            int start = Integer.parseInt(tokens[0]);
            int end = Integer.parseInt(tokens[1]);

            sb.append(num[end] - num[start - 1]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void attendance(int q, String[] tokens, List<Integer> sleepStudentList, List<Integer> code,
                                   boolean[] studentList) {
        for (int i = 0; i < q; i++) {
            int student = Integer.parseInt(tokens[i]);
            if (!sleepStudentList.contains(student)) {
                code.add(student);
                queue.add(student);
                studentList[student] = true;
            }
        }
    }

    private static void cumulativeSum(int n, boolean[] studentList, int[] num) {
        for (int i = 3; i < n; i++) {
            if (!studentList[i]) {
                num[i] = num[i - 1] + 1;
            } else {
                num[i] = num[i - 1];
            }
        }
    }

    private static void calculate(int n, List<Integer> sleepStudentList, boolean[] studentList) {
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int j = current * 2; j < n; j += current) {
                if (!sleepStudentList.contains(j) && !studentList[j]) {
                    queue.add(j);
                    studentList[j] = true;
                }
            }
        }
    }
}
