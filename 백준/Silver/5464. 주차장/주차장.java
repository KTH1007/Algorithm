import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int[] parking;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);

        final int[] parkingList = new int[n + 1];
        final int[] carList = new int[m + 1];
        parking = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parkingList[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= m; i++) {
            carList[i] = Integer.parseInt(br.readLine());
        }

        Queue<Integer> waiting = new ArrayDeque<>();

        int totalCharge = 0;

        // 들어오면 배열에 저장, 배열이 가득차면 큐에서 대기
        // 나가면 금액 더하기, 큐에 차량이 있으면 배열에 넣기
        for (int i = 0; i < 2 * m; i++) {
            int carNum = Integer.parseInt(br.readLine());

            if (carNum > 0) {
                int parkingPosition = parkingPosition();
                if (parkingPosition == -1) {
                    waiting.add(carNum);
                    continue;
                }
                parking[parkingPosition] = carNum;
            } else {
                carNum *= -1;
                int myPosition = findCar(carNum);
                totalCharge += (parkingList[myPosition] * carList[carNum]);
                parking[myPosition] = 0;

                if (!waiting.isEmpty()) {
                    int waitingCarNum = waiting.poll();
                    parking[myPosition] = waitingCarNum;
                }
            }
        }

        System.out.println(totalCharge);
    }

    private static boolean isParking(int i) {
        return parking[i] != 0;
    }

    private static int parkingPosition() {
        for (int i = 1; i <= n; i++) {
            if (!isParking(i)) {
                return i;
            }
        }

        return -1;
    }

    private static int findCar(int carNum) {
        for (int i = 1; i <= n; i++) {
            if (parking[i] == carNum)
                return i;
        }
        return -1;
    }
}
