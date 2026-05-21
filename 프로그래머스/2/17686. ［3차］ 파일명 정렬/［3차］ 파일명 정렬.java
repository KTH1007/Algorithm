import java.util.*;

//  HEAD, NUMBER, TAIL(확장자)
// HEAD 사전순 정렬 (대문자 치환)
// NUMBER 숫자 앞 0은 무시 후 숫자 큰 순 비교


// 2. HEAD 정렬
// List<Stirng[]> file name - head
// head는 반복문으로 숫자 나오기 전까지 꺼내서 대문자 치환
// list 정렬 후 file name 꺼내기

// 3. NUMBER 정렬
// List<FileNumber[]> file nmae - number 
// 파일 이름에서 숫자가 시작하는 부분부터 . 이 나올 때까지
// list에 넣고 정렬
// 기존 head는 유지해야 함 그러면 head가 같은 거끼리만 비교해야 되는데
// 


class Solution {
    public String[] solution(String[] files) {
        
        // getHead와 getNumber로 정렬
        List<String> list = new ArrayList<>();
        for (String file : files) {
            // System.out.println(getHead(file) + " " + getNumber(file));
            // System.out.println();
            list.add(file);
        }
        
        list.sort((o1, o2) -> {
            if (getHead(o1).equals(getHead(o2))) {
                return getNumber(o1) - getNumber(o2);
            }
            return getHead(o1).compareTo(getHead(o2));
        });
        
        String[] answer = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private static Integer getNumber(String file) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < file.length(); i++) {
            char c = file.charAt(i);
            if (c == '.') break;
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        
        String strNum = sb.toString();
        return Integer.parseInt(strNum);
    }
    
    private static String getHead(String file) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < file.length(); i++) {
            char c = file.charAt(i);
            if (c >= '0' && c <= '9') {
                break;
            }
            sb.append(c);
        }
        
        String head = sb.toString();
        
        return head.toUpperCase();
    }
}