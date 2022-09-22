# 중재자 패턴 (Mediator pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/191725476-2992667c-63d2-4dfd-a405-d5e85d67ac5f.png" alt="structure">

* Mediator: `Colleague` 객체간의 상호작용을 위한 인터페이스 정의.
* ConcreteMediator: `Mediator` 구현한 클래스.
* Colleague: 다른 `Colleague`와 상호작용하기 위한 인터페이스 정의.
* ConcreteColleague: `Mediator`를 통해 다른 `Colleague`와 상호작용.

## 요약
간단한 중재자 패턴 구현 예제입니다.<br>
중재자 패턴은 객체들 간의 상호작용 관계가 복잡할 때, 너무 많이 얽혀있을 때 중재자를 둠으로써 객체들을 loosely coupled 할 수 있도록 도와줍니다.<br>
병원의 스케줄링은 대개 접수처에서 관리합니다.<br>
간호사, 안내 데스크에서는 고객을 의사에게 진료/진찰 받을 수 있도록 관리 예약을 요청합니다.<br>
각각의 간호사들과 안내 데스크가 서로 의사소통 할 수도 있지만 관리가 매우 복잡해지기 때문에,<br>
`Reception` 이라는 `Mediator` 에서 `Colleague` 들의 상호작용을 관리해줍니다.<br>

## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%ED%96%89%EB%8F%99-%ED%8C%A8%ED%84%B4Behavioral-Patterns-2#9-%EC%A4%91%EC%9E%AC%EC%9E%90-%ED%8C%A8%ED%84%B4-mediator-pattern">https://velog.io/@ha0kim/Design-Pattern-행동-패턴Behavioral-Patterns-2</a>
- https://refactoring.guru/design-patterns/mediator