import java.util.*;

// 장르별 가장 많이 재생된 노래
// 장르별 합 정렬 -> 장르 내 노래 정렬 -> 고유번호 오름차순

// Map<String, Integer> 장르, 합
// Map<String, List<>> 장르, 장르별 list

// map으로 장르별 합 저장, 각 장르별 list 생성 (index, value)
// list로 장르 map 정렬
// 장르별 list가 들어있는 map도 정렬


class Solution {
    
    class Genre {
        private String genre;
        private int sum;
        
        public Genre(String genre, int sum) {
            this.genre = genre;
            this.sum = sum;
        }
        
        public String getGenre() {
            return this.genre;
        }
        
        public int getSum() {
            return this.sum;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genresMap = new HashMap<>();
        Map<String, List<int[]>> genresListMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
            
            if (!genresListMap.containsKey(genres[i])) {
                genresListMap.put(genres[i], new ArrayList<>());
            }
            genresListMap.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        // 장르별 내부 노래 정렬
        for (String key : genresListMap.keySet()) {
            genresListMap.get(key).sort((o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            });
        }
        
        List<Genre> genreList = new ArrayList<>();
        
        // 장르별 합 정렬
        for (String key : genresMap.keySet()) {
            genreList.add(new Genre(key, genresMap.get(key)));
        }
        genreList.sort((o1, o2) -> o2.getSum() - o1.getSum());
        
        // 결과 정산
        List<Integer> result = new ArrayList<>();
        for (Genre genre : genreList) {
            String gen = genre.getGenre();
            int index = 0;
            for (int i = 0; i < genresListMap.get(gen).size(); i++) {
                if (index == 2) {
                    break;
                }
                index++;
                result.add(genresListMap.get(gen).get(i)[0]);
            }
        }
        
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}