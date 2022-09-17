# 빌더 패턴 (Builder Pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/190866270-dae771fa-9653-4715-acca-7935bbc67672.png" alt="structure">

* Director: `Builder`를 이용하여 객체를 생성
* Builder: 객체를 생성하는 방법과 형태를 가진 인터페이스
* ConcreteBuilder: `Builder` 인터페이스의 구현체로 구현하고자 하는 각 객체의 특징을 정의
* Product: `Director`가 `Builder`를 이용해 생성하는 결과 객체 (`build()` 호출)
<br>

## 요약
간단한 빌더 패턴 예제를 구현해봤습니다.<br>
예제에서는 `Builder`를 인터페이스로 구현하지 않고, Nested Static Class 로 구현헀습니다.<br>
생성하고자 하는 `Product`의 내부에 `ConcreteBuilder` 를 생성하고, `Product` 클래스의 필수 값들을 인자로 받는 생성자를 정의합니다.<br>
선택 값들은 step-by-step 으로 `ConcreteBuilder`의 함수 호출을 통해 assign 할 수 있도록 했습니다.<br>


## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%EC%83%9D%EC%84%B1-%ED%8C%A8%ED%84%B4Creational-Patterns">https://velog.io/@ha0kim/Design-Pattern-생성-패턴Creational-Patterns</a>