import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Dice {
    private int one;
    private int two;
    private int three;
    private int four;
    private int five;
    private int six;

    public Dice(int one, int two, int three, int four, int five, int six) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
    }

    public int getOne() {
        return one;
    }

    public int getTwo() {
        return two;
    }

    public int getThree() {
        return three;
    }

    public int getFour() {
        return four;
    }

    public int getFive() {
        return five;
    }

    public int getSix() {
        return six;
    }
}

public class Main {
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tokens;

        List<Dice> dice = new ArrayList<>();
        while (n-- > 0) {
            tokens = br.readLine().split(" ");
            int one = Integer.parseInt(tokens[0]);
            int two = Integer.parseInt(tokens[1]);
            int three = Integer.parseInt(tokens[2]);
            int four = Integer.parseInt(tokens[3]);
            int five = Integer.parseInt(tokens[4]);
            int six = Integer.parseInt(tokens[5]);

            dice.add(new Dice(one, two, three, four, five, six));
        }

       getDiceSum(dice);

        System.out.println(max);
    }

    private static void getDiceSum(List<Dice> dice) {
        int bottom;
        int top;
        int sum;

        bottom = bottomA(dice, 0)[0];
        top = bottomA(dice, 0)[1];
        sum = getMax(bottom, top);
        calculate(1, dice, sum, bottom, top);

        bottom = bottomB(dice, 0)[0];
        top = bottomB(dice, 0)[1];
        sum = getMax(bottom, top);
        calculate(1, dice, sum, bottom, top);

        bottom = bottomC(dice, 0)[0];
        top = bottomC(dice, 0)[1];
        sum = getMax(bottom, top);
        calculate(1, dice, sum, bottom, top);

        bottom = bottomD(dice, 0)[0];
        top = bottomD(dice, 0)[1];
        sum = getMax(bottom, top);
        calculate(1, dice, sum, bottom, top);

        bottom = bottomE(dice, 0)[0];
        top = bottomE(dice, 0)[1];
        sum = getMax(bottom, top);
        calculate(1, dice, sum, bottom, top);

        bottom = bottomF(dice, 0)[0];
        top = bottomF(dice, 0)[1];
        sum = getMax(bottom, top);
        calculate(1, dice, sum, bottom, top);
    }

    private static void calculate(int depth, List<Dice> dice, int sum, int bottom, int top) {
        if (depth == dice.size()) {
            max = Math.max(max, sum);
            return;
        }

        Dice newDice = dice.get(depth);

        int newBottom;
        int newTop;

        newBottom = bottomA(dice, depth)[0];
        newTop = bottomA(dice, depth)[1];
        if (newBottom == top) {
            calculate(depth + 1, dice, sum + getMax(newBottom, newTop), newBottom, newTop);
        }

        newBottom = bottomB(dice, depth)[0];
        newTop = bottomB(dice, depth)[1];
        if (newBottom == top) {
            calculate(depth + 1, dice, sum + getMax(newBottom, newTop), newBottom, newTop);
        }

        newBottom = bottomC(dice, depth)[0];
        newTop = bottomC(dice, depth)[1];
        if (newBottom == top) {
            calculate(depth + 1, dice, sum + getMax(newBottom, newTop), newBottom, newTop);
        }

        newBottom = bottomD(dice, depth)[0];
        newTop = bottomD(dice, depth)[1];
        if (newBottom == top) {
            calculate(depth + 1, dice, sum + getMax(newBottom, newTop), newBottom, newTop);
        }

        newBottom = bottomE(dice, depth)[0];
        newTop = bottomE(dice, depth)[1];
        if (newBottom == top) {
            calculate(depth + 1, dice, sum + getMax(newBottom, newTop), newBottom, newTop);
        }

        newBottom = bottomF(dice, depth)[0];
        newTop = bottomF(dice, depth)[1];
        if (newBottom == top) {
            calculate(depth + 1, dice, sum + getMax(newBottom, newTop), newBottom, newTop);
        }
    }

    private static int[] bottomA(List<Dice> dice, int seq) {
        int bottom = dice.get(seq).getOne();
        int top = dice.get(seq).getSix();

        return new int[]{bottom, top};
    }

    private static int[] bottomB(List<Dice> dice, int seq) {
        int bottom = dice.get(seq).getTwo();
        int top = dice.get(seq).getFour();

        return new int[]{bottom, top};
    }

    private static int[] bottomC(List<Dice> dice, int seq) {
        int bottom = dice.get(seq).getThree();
        int top = dice.get(seq).getFive();

        return new int[]{bottom, top};
    }

    private static int[] bottomD(List<Dice> dice, int seq) {
        int bottom = dice.get(seq).getFour();
        int top = dice.get(seq).getTwo();

        return new int[]{bottom, top};
    }

    private static int[] bottomE(List<Dice> dice, int seq) {
        int bottom = dice.get(seq).getFive();
        int top = dice.get(seq).getThree();

        return new int[]{bottom, top};
    }

    private static int[] bottomF(List<Dice> dice, int seq) {
        int bottom = dice.get(seq).getSix();
        int top = dice.get(seq).getOne();

        return new int[]{bottom, top};
    }

    private static int getMax(int bottom, int top) {
        int maxVal = 0;
        for (int i = 1; i <= 6; i++) {
            if (i != bottom && i != top) {
                maxVal = Math.max(maxVal, i);
            }
        }
        return maxVal;
    }
}
