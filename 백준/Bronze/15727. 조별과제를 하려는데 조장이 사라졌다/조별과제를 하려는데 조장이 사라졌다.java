import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //성우의 현재 위치와 민건이의 집까지의 거리
        
        if(N%5 == 0) {
            System.out.println(N/5);
        } else {
            System.out.println(N/5+1);
        }
    }
}