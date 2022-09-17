# 팩토리 메소드 패턴 (Factory Method Pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/190867151-52ea05af-1163-41d7-b9d4-bdc25bb31364.png" alt="structure">

* Factory: `Product`를 생성하는 메소드로 인터페이스 정의.
* ConcreteFactory: 구체적인 제품 객체를 생성하는 연산을 구현한다.
* AbstractProduct: 개념적 제품 객체에 대한 인터페이스 정의.
* ConcreteProduct: 구체적으로 `ConcreteFactory` 가 생성할 객체를 정의하고, `AbstractProduct` 의 메소드 구현.


## 요약
간단한 팩토리 메소드 패턴을 구현한 예제입니다.
`AbstractFactory`인 `FruitFactory`에서는 `Fruit`이라는 `Product`를 제공합니다.<br>
팩토리 메소드 패턴은 하나의 객체를 생성하는 역할을 수행합니다.<br>
하지만, `AbstractFactory`에서 다양한 타입의 객체를 제공해야 할 경우 사용할 수 없습니다.<br>
위와 같은 경우에는 추상 팩토리 패턴을 사용해 다양한 요구사항을 처리할 수 있도록 해야 합니다.<br>


## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%EC%83%9D%EC%84%B1-%ED%8C%A8%ED%84%B4Creational-Patterns">https://velog.io/@ha0kim/Design-Pattern-생성-패턴Creational-Patterns</a>