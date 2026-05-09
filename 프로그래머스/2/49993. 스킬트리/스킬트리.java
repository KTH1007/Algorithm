import java.util.*;

// 스킬 순서대로 찍었는지 확인

// C B D 
// D 는 B 스킬이 필요, B 는 C 스킬이 필요
// 각각의 단어 검사 메서드 필요
// 단어마다 알파벳이 스킬트리를 지켰는지 확인
// 단어 알파벳은 Set에 보관
// alpha 배열에 이전 스킬 트리 보관
// D -> alpha[3] = B, alpha[1] = C, ' '은 필요한 스킬트리 없음
// 단어의 알파벳 하나씩 꺼내서 int 전환 후 값 확인 ' '이 아니면 set에 alpha[num]이 있는지 확인
// 없으면 false

class Solution {
    static char[] alpha;
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        alpha = new char[26];
        Arrays.fill(alpha, ' ');
        
        // 스킬트리 저장 (B의 경우 C 저장)
        for (int i = 1; i < skill.length(); i++) {
            int num = (int) (skill.charAt(i)) - 65;
            alpha[num] = skill.charAt(i - 1);
        }
        
        for (String s : skill_trees) {
            if (vaildateSkillTree(s)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static boolean vaildateSkillTree(String skill) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < skill.length(); i++) {
            int num = (int) (skill.charAt(i)) - 65;
            
            // System.out.println(num);
            
            if (alpha[num] != ' ') {
                if (!set.contains(alpha[num])) {
                    return false;
                }
            } 
            
            set.add(skill.charAt(i));
        }
        
        return true;
    }
}