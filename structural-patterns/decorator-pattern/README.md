# 데코레이터 패턴 (Decorator pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/192739445-31915396-80cf-4a35-943e-3eb09e01d474.png" alt="structure">

* Component: `ConcreteComponent`와 `Decorator`를 동등하게 다루기 위한 인터페이스.
* Decorator: 기능 추가를 위해 생성될 `ConcreteDecorator`들이 상속받을 추상 클래스. 해당 클래스에서 `Component`에 대한 레퍼런스를 유지한다.


## 요약
간단한 데코레이터 패턴 구현 예제입니다.<br>
데코레이터 패턴은 기능을 확장하고자 할 때 사용됩니다. Inheritance 를 활용한 기능의 확장은 runtime 에 적용될 수 없으며,<br>
Client 와 Library 코드 모두 복잡하고, 커지게 될 가능성이 매우 높습니다.<br>
이 때, `Component`를 확장한 Wrapper 클래스인 `Decorator`를 활용함으로써, 코드의 큰 변경없이 기능을 확장할 수 있는 장점이 있습니다.<br>

`Repository`는 `Book`에 대해 crud 함수를 정의한 인터페이스 입니다.<br>
crud 함수들이 실행될 때 로깅 기능을 확장하기 위해서 `Decorator`를 정의하고,<br>
`RepositoryLogger` 클래스에서 기존 `Component`의 함수와 자신이 정의한 로깅 기능을 함께 호출하도록 해 기능을 확장했습니다.<br> 

## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%EA%B5%AC%EC%A1%B0-%ED%8C%A8%ED%84%B4Structural-Patterns#4-%EB%8D%B0%EC%BD%94%EB%A0%88%EC%9D%B4%ED%84%B0-%ED%8C%A8%ED%84%B4decorator-pattern">https://velog.io/@ha0kim/Design-Pattern-구조-패턴Structural-Patterns</a>
- https://refactoring.guru/design-patterns/decorator