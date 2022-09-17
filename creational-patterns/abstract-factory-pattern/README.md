# 추상 팩토리 패턴 (Abstract Factory Pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/190864134-0592bb7c-b724-45da-82c2-707c3d27b961.png" alt="structure">

* AbstractFactory: `AbstractProduct`를 생성하는 메소드로 인터페이스 정의.
* ConcreteFactory: 구체적인 제품 객체를 생성하는 연산을 구현한다.
* AbstractProduct: 개념적 제품 객체에 대한 인터페이스 정의.
* ConcreteProduct: 구체적으로 `ConcreteFactory` 가 생성할 객체를 정의하고, `AbstractProduct` 의 메소드 구현.
* Client: `AbstractFactory`, `AbstractProduct` 인터페이스 사용.
<br>

## 요약
간단한 추상 팩토리 패턴 예제를 구현해봤습니다.<br>
`AbstractFactory`에서 제공하는 `AbstractProduct`의 종류로, `Cuisine`과 `Sauce`를 정의했습니다.<br>
`Client`는 원하는 `ConcreteFactory`인 `*ChefFactory`를 선택해 특정 국가의 음식과 소스 객체를 생성할 수 있습니다.<br>
추상 팩토리 패턴은 다양한 요구사항을 interface에 선언하여 처리할 수 있습니다.


## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%EC%83%9D%EC%84%B1-%ED%8C%A8%ED%84%B4Creational-Patterns">https://velog.io/@ha0kim/Design-Pattern-생성-패턴Creational-Patterns</a>
- https://kotlinworld.com/366
