class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            skill_trees[i] = skill_trees[i].replaceAll("[^" + skill + "]", "");
            
            for (int j = 0; j < skill.length() + 1; j++) {
                String sub_skill = skill.substring(0, j);
                if (skill_trees[i].equals(sub_skill)) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}