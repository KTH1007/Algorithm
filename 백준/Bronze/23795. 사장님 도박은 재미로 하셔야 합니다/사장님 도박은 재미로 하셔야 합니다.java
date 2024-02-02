import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[1999];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] == -1) {
                break;
            }
        }
        sc.close();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (arr[i] == -1) {
                sum = sum + 1;
                break;
            }
        }
        System.out.println(sum);
    }
}