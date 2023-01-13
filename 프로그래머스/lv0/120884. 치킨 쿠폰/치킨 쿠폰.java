class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int coupon = 0;
        coupon = chicken / 10;
        answer += coupon;
        coupon += chicken % 10;
        while(coupon >= 10){  //쿠폰 109개
            //쿠폰 100개 쓰고 새로운 쿠폰 10개 추가 남은 쿠폰 19개
            //
            answer += coupon/10; 
            int a = coupon % 10;
            int b = coupon / 10;
            coupon = a + b;
        }
        return answer;
    }
}