import java.util.*;

// 17 -> 1, 7, 17
// 에라토스테네스의 체로 소수 구분
// charAt로 하나씩 분리
// 일단 반복문으로 소수 찾고
// 문자 붙여서 소수 판별 dfs? 같은 인덱스 중복은 안 됨

class Solution {
    
    static boolean[] prime = new boolean[10000001];
    static boolean[] visited;
    static String[] num;
    static Set<Integer> set = new HashSet<>();
    static int answer = 0;
    
    public int solution(String numbers) {
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        visited = new boolean[numbers.length()];
        num = new String[numbers.length()];
        
        checkPrime();
        for (int i = 0; i < numbers.length(); i++) {
            num[i] = numbers.charAt(i) + "";
        }
        
        for (int i = 0; i < num.length; i++) {
            visited[i] = true;
            int number = Integer.parseInt(num[i]);
            if (!set.contains(number) && prime[number]) {
                set.add(number);
                answer++;
            }
            dfs(0, num[i]);

            visited[i] = false;
        }
        return answer;
    }
    
    private static void dfs(int depth, String str) {
        // System.out.println("d");
        if (depth == num.length) {
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            String newStr = str + num[i];
            int number = Integer.parseInt(newStr);
            
            // 중복이 아니면서 소수
            if (!set.contains(number) && prime[number]) {
                set.add(number);
                answer++;
            }
            dfs(depth + 1, str + num[i]);
            visited[i] = false;
        }
    }
    
    private static void checkPrime() {
        for (int i = 2; i <= Math.sqrt(10000000); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 10000000; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}