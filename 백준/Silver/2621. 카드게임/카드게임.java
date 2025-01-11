import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Card> list = new ArrayList<>();
        int[] numCount = new int[10];
        int max = 0;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            String color = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            list.add(new Card(color, num));

            numCount[num]++;
        }

        list.sort(null);

        boolean isSameColor = list.stream().allMatch(card -> card.getColor().equals(list.get(0).getColor()));

        if (isSameColor) {
            boolean flag = true;
            int num = list.get(0).getNum();
            for (int i = 1; i < 5; i++) {
                if (num - list.get(i).getNum() != 1) {
                    flag = false;
                    break;
                } else {
                    num = list.get(i).getNum();
                }
            }

            if (flag) {  // 1번
                System.out.println(900 + list.get(0).getNum());
                return;
            } else { // 4번
                max = Math.max(max, 600 + list.get(0).getNum());
            }
        }

        for (int i = 0; i < 10; i++) {
            if (numCount[i] == 4) { // 2번
                max = Math.max(max, 800 + i);
            } else if (numCount[i] == 3) {  // 3번
                for (int j = 0; j < 10; j++) {
                    if (j != i && numCount[j] == 2) {
                        max = Math.max(max, 700 + (i * 10) + j);
                    }
                }
                max = Math.max(max, 400 + i); // 6번
            } else if (numCount[i] == 2) {
                for (int j = 0; j < 10; j++) {
                    if (j != i && numCount[j] == 2) { // 7번
                        max = Math.max(max, 300 + (j * 10) + i);
                    }
                }
                max = Math.max(max, 200 + i); // 8번
            }
        }

        max = Math.max(max, 100 + list.get(0).getNum()); // 9번

        boolean flag = true;
        int num = list.get(0).getNum();
        for (int i = 1; i < 5; i++) {
            if (num - list.get(i).getNum() != 1) {
                flag = false;
                break;
            } else {
                num = list.get(i).getNum();
            }
        }
        if (flag) { // 5번
            max = Math.max(max, 500 + list.get(0).getNum());
        }

        System.out.println(max);
    }

    static class Card implements Comparable<Card> {
        String color;
        int num;

        public Card(String color, int num) {
            this.color = color;
            this.num = num;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Card o) {
            return o.getNum() - this.getNum();
        }
    }
}
