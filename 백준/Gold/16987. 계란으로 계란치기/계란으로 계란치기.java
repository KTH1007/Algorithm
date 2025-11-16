import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Egg {
    private int durability;
    private int weight;

    public Egg(int durability, int weight) {
        this.durability = durability;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getDurability() {
        return durability;
    }

    public boolean isBroken() {
        return this.durability <= 0;
    }

    public void hit(int damage) {
        this.durability -= damage;
    }

    public void restore(int damage) {
        this.durability += damage;
    }
}

class Eggs {
    private final List<Egg> eggs;

    public Eggs(List<Egg> eggs) {
        this.eggs = new ArrayList<>(eggs);
    }

    public int countBroken() {
        return (int) eggs.stream()
                .filter(Egg::isBroken)
                .count();
    }

    public void crash(int index1, int index2) {
        if (index1 == index2) {
            throw new IllegalArgumentException("같은 계란끼리는 칠 수 없습니다");
        }
        Egg egg1 = eggs.get(index1);
        Egg egg2 = eggs.get(index2);

        egg1.hit(egg2.getWeight());
        egg2.hit(egg1.getWeight());
    }

    public void restoreCrash(int index1, int index2) {
        Egg egg1 = eggs.get(index1);
        Egg egg2 = eggs.get(index2);

        egg1.restore(egg2.getWeight());
        egg2.restore(egg1.getWeight());
    }

    public int getSize() {
        return eggs.size();
    }

    public boolean isBroken(int index) {
        return eggs.get(index).isBroken();
    }
}

public class Main {
    static int count = 0;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        List<Egg> inputEggs = new ArrayList<>();

        String[] tokens;
        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            int durability = Integer.parseInt(tokens[0]);
            int weight = Integer.parseInt(tokens[1]);
            inputEggs.add(new Egg(durability, weight));
        }

        Eggs eggs = new Eggs(inputEggs);

        dfs(0, eggs);
        System.out.println(count);
    }

    private static void dfs(int depth, Eggs eggs) {
        if (depth == n) {
            int broken = eggs.countBroken();
            count = Math.max(count, broken);
            return;
        }

        if (eggs.isBroken(depth)) {
            dfs(depth + 1, eggs);
            return;
        }

        boolean hasTarget = false;
        for (int i = 0; i < eggs.getSize(); i++) {
            if (depth == i) continue;
            if (eggs.isBroken(i)) continue;

            hasTarget = true;
            eggs.crash(depth, i);
            dfs(depth + 1, eggs);
            eggs.restoreCrash(depth, i);
        }

        if (!hasTarget) {
            dfs(depth + 1, eggs);
        }
    }
}
