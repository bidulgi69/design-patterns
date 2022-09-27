# 브리지 패턴 (Bridge pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/192270632-bf62bfc9-4e48-4ebf-8e21-66718b4af797.png" alt="structure">

* Implementor: 분리된 구현부, low-level 개념을 다룸. `Abstraction`의 기능을 구현하기 위한 인터페이스 정의.
* Abstraction: 분리된 추상부, high-level 개념을 다룸. `Implementor`에 대한 레퍼런스를 유지하며 해당 인스턴스를 통해 구현부의 메소드를 호출한다.


## 요약
간단한 브리지 패턴 구현 예제입니다.<br>
브리지 패턴은 개인적인 견해로 행동과 객체를 나누는 방법이라고 생각합니다.<br>
객체에 대한 정보를 `Abstraction`에 구현하고, 해당 객체들이 공통적으로 갖고 있는 행동을 `Implementation`으로 따로 분리합니다.<br>

해당 예제에서는 스타크래프트 유닛을 `Abstraction`으로 설정하고, 유닛들의 공격 타입에 따른 데미지 계산법을 `Implementation`으로 분리했습니다.<br>

## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%EA%B5%AC%EC%A1%B0-%ED%8C%A8%ED%84%B4Structural-Patterns">https://velog.io/@ha0kim/Design-Pattern-구조-패턴Structural-Patterns</a>
- https://refactoring.guru/design-patterns/bridge
- https://sourcemaking.com/design_patterns/bridge
- https://medium.com/@andreaspoyias/design-patterns-a-quick-guide-to-bridge-pattern-9ebf6a77baed