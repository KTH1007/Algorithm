import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            skill_trees[i] = skill_trees[i].replaceAll("[^" + skill + "]", "");
        }
        
        for (int i = 0; i < skill_trees.length; i++) {
            int length = skill_trees[i].length();
            if (skill.substring(0, length).equals(skill_trees[i])) answer++;
        }
        return answer;
    }
}