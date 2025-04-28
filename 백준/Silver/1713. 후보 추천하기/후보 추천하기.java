import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 추천순, 시간순, 추천 시 시간은 변경되지 않음
        // 후보 번호 증가순 출력

        // map에 key -> studentNum, value -> likeCount, time
        // 정렬 list<int[]>  람다식 정렬

        int size = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Student> frames = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int studentNum = Integer.parseInt(st.nextToken());

            // 이미 사진틀에 있는 학생인 경우
            if (frames.containsKey(studentNum)) {
                frames.get(studentNum).likeCount++;
            } else {
                if (frames.size() >= size) {
                    int minLikes = Integer.MAX_VALUE;
                    int oldestTime = Integer.MAX_VALUE;
                    int removeStudent = -1;

                    // 가장 추천수가 적고, 가장 오래된 학생 찾기
                    for (Integer key : frames.keySet()) {
                        Student student = frames.get(key);

                        if (student.likeCount < minLikes || (student.likeCount == minLikes && student.time < oldestTime)) {
                            minLikes = student.likeCount;
                            oldestTime = student.time;
                            removeStudent = key;
                        }
                    }

                    frames.remove(removeStudent);
                }
                frames.put(studentNum, new Student(1, i));
            }

        }

        List<Integer> list = new ArrayList<>(frames.keySet());
        list.sort(null);

        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static class Student {
        private int likeCount;
        private int time;

        public Student(int likeCount, int time) {
            this.likeCount = likeCount;
            this.time = time;
        }
    }
}
