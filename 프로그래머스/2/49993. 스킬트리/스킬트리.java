class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            skill_trees[i] = skill_trees[i].replaceAll("[^" + skill +"]", "");
            System.out.println(skill_trees[i]);
            
            for (int j = 0; j < skill.length() + 1; j++) {
                if (skill_trees[i].equals(skill.substring(0, j))) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}