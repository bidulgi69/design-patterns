# 합성 패턴 (Composite pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/192588526-4872b6a6-55d8-46c2-8111-316f076059b0.png" alt="structure">

* Leaf: 구체적인 부분 클래스로 단일 객체를 표현.
* Component: `Leaf`와 `Composite` 의 공통 인터페이스 정의.
* Composite: 여러개의 `Component` 타입의 멤버를 수용할 수 있도록 설계해야 함.

## 요약
간단한 합성 패턴 구현 예제입니다.<br>
합성 패턴은 트리, 계층 구조 형태일 때 사용 가능한 패턴입니다.<br>
Decorator 패턴과 다른 점은, `Composite`이 [0-N]의 `Component`를 수용할 수 있습니다.

예제는 제품의 총 가격을 계산하는 `getPrice()`를 공통적으로 갖는 `Component` 인터페이스를 구현합니다.<br>
단일 객체인 `Leaf`에서는 자신의 가격을 리턴해주면 됩니다.<br>
여러개의 `Component`를 수용하는 `Composite`에서는 각 `Component`를 순회하며 얻은 가격의 총합을 리턴합니다.<br>

## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%EA%B5%AC%EC%A1%B0-%ED%8C%A8%ED%84%B4Structural-Patterns#3-%ED%95%A9%EC%84%B1-%ED%8C%A8%ED%84%B4composite-pattern">https://velog.io/@ha0kim/Design-Pattern-구조-패턴Structural-Patterns</a>
- https://refactoring.guru/design-patterns/composite
