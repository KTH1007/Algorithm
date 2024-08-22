import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int money = Integer.parseInt(br.readLine());
        int[] machineDuck = new int[14];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            machineDuck[i] = Integer.parseInt(st.nextToken());
        }

        int j = BNP(money, machineDuck);
        int s = TIMING(money, machineDuck);

        if (j > s) {
            System.out.println("BNP");
        } else if (s > j) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
        
        br.close();
    }

    private static int BNP(int money, int[] machineDuck) {
        int stock = 0;
        for (int i = 0; i < 14; i++) {
            if (money >= machineDuck[i]) {
                stock += (money / machineDuck[i]);
                money %= machineDuck[i];
            }
        }
        return money + (machineDuck[13] * stock);
    }


    private static int TIMING(int money, int[] machineDuck) {
        int stock = 0;
        int up = 0;
        int down = 0;
        int temp = machineDuck[0];

        for (int i = 1; i < 14; i++) {
            if (machineDuck[i] > temp) {
                up++;
                down = 0;
            }
            if (machineDuck[i] < temp) {
                down++;
                up = 0;
            }

            if (up == 3) {
                money += machineDuck[i] * stock;
                stock = 0;
            } else if (down == 3) {
                stock += money / machineDuck[i];
                money %= machineDuck[i];
            }
        }

        return money + (machineDuck[13] * stock);
    }
}
