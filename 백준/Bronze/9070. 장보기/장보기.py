class mart:
    def __init__(self,temp,price,n):
        self.temp = temp
        self.price = price
        self.n = n
    def value(self):
      for i in range(self.n):
        w, c = map(int, input().split())
        v = c/w
        if self.temp > v:
          self.temp = v
          self.price = c
        if self.temp == v: #같은 가격으로 살 수 있는 최대 중량이 같은 맛살이 두 개 이상인 경우 낮은 가격 선택
          if self.price > c:
              self.price = c
      return self.price
      
      

t=int(input())
for i in range(t):
    n=int(input())
    temp = 100001 #조건 탐색을 위한 변수
    price = 0 #초기 값 설정
    m = mart(temp,price,n)
    print(m.value())
