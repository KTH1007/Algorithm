import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());

        var Sequence = new int[N];
        for (int i = 0; i < N; i++) Sequence[i] = Integer.parseInt(br.readLine());

        if(Sequence[2]-Sequence[1] == Sequence[1]-Sequence[0])
            System.out.print(Sequence[N-1] + (Sequence[1]-Sequence[0]));
        else System.out.print(Sequence[N-1] * (Sequence[1]/Sequence[0]));
    }
}