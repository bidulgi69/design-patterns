# 전략 패턴 (Strategy pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/191502558-c705796a-035e-4611-a571-2f549c15aa20.png" alt="structure">

* Strategy: 인터페이스나 추상 클래스로 외부에서 동일한 방식으로 알고리즘을 호출하는 방법을 명시.
* ConcreteStrategy: 명시한 알고리즘을 실제로 구현한 클래스.
* Context: `Strategy` 를 이용하는 역할을 수행. 필요에 따라 `Strategy`를 변경할 수 있도록 setter 메소드 제공.


## 요약
간단한 전략 패턴 구현 예제입니다.<br>
주식의 거래 전략(`Strategy`)으로 `Short`, `Long`, `Scalping`, `LowerLimit` 등이 존재하며,<br>
투자자(`Context`)인 `Institution`, `Insider`, `GeneralInvestor`는 각자의 전략에 맞게 거래를 수행합니다.<br>


## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%ED%96%89%EB%8F%99-%ED%8C%A8%ED%84%B4Behavioral-Patterns-2">https://velog.io/@ha0kim/Design-Pattern-행동-패턴Behavioral-Patterns-2</a>
- https://victorydntmd.tistory.com/292