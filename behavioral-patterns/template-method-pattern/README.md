# 템플릿 메소드 패턴 (Template Method pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/191562666-71e8c857-2b78-434f-9805-be562ade102c.png" alt="structure">

* AbstractClass: 추상 클래스로, 전체적인 구조를 `templateMethod()` 내에 정의한다. 
* ConcreteClass: `AbstractClass`에서 abstract 로 정의된 함수들을 실제로 구현한 클래스.

## 요약
간단한 템플릿 메소드 패턴 구현 예제입니다.<br>
주말과 평일 일과는 비슷하지만 시간을 얼마나 사용하는지에 따라 달라지는데,<br>
일과의 공통적인 부분을 `templateMethod()` 내에 정의하고, 구체적인 계획은 `ConcreteClass`인 `WeekendRoutine`과 `WeekdayRoutine` 클래스에서 구현합니다.<br>


## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%ED%96%89%EB%8F%99-%ED%8C%A8%ED%84%B4Behavioral-Patterns-2">https://velog.io/@ha0kim/Design-Pattern-행동-패턴Behavioral-Patterns-2</a>
- https://coding-factory.tistory.com/712