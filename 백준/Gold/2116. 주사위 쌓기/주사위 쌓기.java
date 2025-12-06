import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Dice {
    private static final int[] OPPOSITE = {5, 3, 4, 1, 2, 0};
    private static final int DICE_FACES = 6;

    private final int[] faces;

    public Dice(int[] faces) {
        if (faces.length != DICE_FACES) {
            throw new IllegalArgumentException("주사위는 6개의 면이 필요합니다.");
        }
        this.faces = faces.clone();
    }

    public int getTopValue(int bottomValue) {
        for (int i = 0; i < DICE_FACES; i++) {
            if (faces[i] == bottomValue) {
                return faces[OPPOSITE[i]];
            }
        }
        throw new IllegalArgumentException("존재하지 않는 바닥면 값: " + bottomValue);
    }

    public int getMaxSideValue(int bottomValue, int topValue) {
        int maxValue = 0;
        for (int face : faces) {
            if (face != bottomValue && face != topValue) {
                maxValue = Math.max(maxValue, face);
            }
        }
        return maxValue;
    }

    public List<Integer> getAllPossibleBottoms() {
        List<Integer> bottoms = new ArrayList<>();
        for (int face : faces) {
            bottoms.add(face);
        }
        return bottoms;
    }
}

class DiceStack {
    private final List<Dice> dices;

    public DiceStack(List<Dice> dices) {
        this.dices = new ArrayList<>(dices);
    }

    public int calculateMaxSideSum() {
        if (dices.isEmpty()) {
            return 0;
        }

        int maxSum = 0;

        Dice firstDice = dices.get(0);
        for (Integer bottomValue : firstDice.getAllPossibleBottoms()) {
            int sum = calculateSumWithBottom(0, bottomValue);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    private int calculateSumWithBottom(int index, int bottomValue) {
        if (index >= dices.size()) {
            return 0;
        }

        Dice currentDice = dices.get(index);
        int topValue = currentDice.getTopValue(bottomValue);
        int sideMax = currentDice.getMaxSideValue(bottomValue, topValue);

        if (index == dices.size() - 1) {
            return sideMax;
        }

        return sideMax + calculateSumWithBottom(index + 1, topValue);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Dice> dices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            int[] faces = new int[6];
            for (int j = 0; j < 6; j++) {
                faces[j] = Integer.parseInt(tokens[j]);
            }
            dices.add(new Dice(faces));
        }

        DiceStack stack = new DiceStack(dices);
        System.out.println(stack.calculateMaxSideSum());
    }
}
