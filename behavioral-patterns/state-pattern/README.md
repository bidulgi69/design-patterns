# 상태 패턴 (State pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/191909372-39d955f7-8c78-4161-a5b7-98a1a2239d36.png" alt="structure">

* Context: `State`를 소유하며 요청을 보내는 주체. `setState()` 메소드를 통해 `State`의 변경이 가능하다. 
* State: 상태에 따른 동작을 정의하는 인터페이스.
* ConcreteState: `State` 인터페이스에 정의된 메소드 구현.

## 요약
간단한 상태 패턴 구현 예제입니다.<br>
상태 패턴은 프로그램 내에 유한한 개수의 상태 종류가 존재하고, 상태 간 전이(transition) 경우의 수 또한 유한할 경우 사용할 수 있습니다.<br>
프로그램에 새로운 상태 값을 추가해야 할 때, `if-else`, `switch, when` 등에서 branch 를 계속 추가하면 기존 클래스의 변경이 발생합니다.<br>
이러한 경우 상태 패턴을 통해 복잡하지 않고 기존 클래스의 변경 없이 새로운 상태 값에 대한 행동을 추가할 수 있습니다.<br>
상태 패턴은 전략 패턴과 비슷하지만, 전략 패턴의 `ConcreteStrategy`들이 동일한 목표를 위해 구현되는 반면,<br>
`ConcreteState`들은 현재 상태 값에 따라 완전히 다른 목표를 가질 수 있습니다.<br><br>
해당 프로젝트는 신호등의 신호 변경을 예로 들어 구현했습니다.<br>
신호등은 `RedLight`, `GreenLight`, `YellowLight`의 상태 값을 가지고 있습니다.<br>
각각 다른 상태로의 전이가 발생하기도 하며, 전이의 경우의 수는 유한합니다.<br>



## References
- https://www.baeldung.com/java-state-design-pattern
- https://ko.wikipedia.org/wiki/상태_패턴
- https://refactoring.guru/design-patterns/state