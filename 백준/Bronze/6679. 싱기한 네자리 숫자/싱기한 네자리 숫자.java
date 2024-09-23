import java.util.*;
import java.io.*;

public class Main {
 
    public static void main(String[] args) {
        int start = 1000; // 주어진 범위의 시작값
        
        while (start <= 9999) {
            if (isStrangeNumber(start)) {
                System.out.println(start);
            }
            start++;
        }
    }
    
    public static boolean isStrangeNumber(int number) {
        int base10Sum = sumOfDigits(number, 10);  // 10진수 자리수 합
        int base12Sum = sumOfDigits(number, 12);  // 12진수 자리수 합
        int base16Sum = sumOfDigits(number, 16);  // 16진수 자리수 합
        
        return (base10Sum == base12Sum && base12Sum == base16Sum);
    }
    
    public static int sumOfDigits(int number, int base) {
        int sum = 0;
        while (number > 0) {
            sum += number % base; // 각 자리의 값을 더함
            number /= base; // 다음 자리로 이동
        }
        return sum;
    }
 
}