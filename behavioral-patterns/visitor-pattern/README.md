# 방문자 패턴 (Visitor pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/191711900-f3a96d16-56df-44b3-a7b2-8b9e8d002933.png" alt="structure">

* Visitor: `ConcreteElement`를 방문하며 실행할 메소드를 정의하는 인터페이스.
* ConcreteVisitor: 실행할 메소드를 구현한 클래스.
* Element: `accept()` 메소드를 정의한 인터페이스.
* ConcreteElement: `accept()` 메소드를 구현하며, `Visitor` 객체는 `ConcreteElement` 객체를 통하여 메소드를 실행한다.


## 요약
간단한 방문자 패턴 구현 예제입니다.<br>
방문자 패턴은 OCP 원칙을 준수하는 패턴으로, `accept()` 메소드를 추가함으로써 기존 구조의 변경없이 새로운 기능을 확장할 수 있습니다.<br>
Spring framework 의 classpath resource 에 xml, yml, json 파일들이 존재한다고 가정하고,<br>
파일들이 공통적으로 수행해야 하는 load 작업을 `Visitor`에 위임함으로써 다양한 파일 extension 에 대해 기능을 확장할 수 있도록 했습니다.<br>


## References
* <a href="https://velog.io/@ha0kim/Design-Pattern-%ED%96%89%EB%8F%99-%ED%8C%A8%ED%84%B4Behavioral-Patterns-2#8-%EB%B0%A9%EB%AC%B8%EC%9E%90-%ED%8C%A8%ED%84%B4-visitor-pattern">https://velog.io/@ha0kim/Design-Pattern-행동-패턴Behavioral-Patterns-2</a>
* https://www.baeldung.com/java-visitor-pattern
* https://sourcemaking.com/design_patterns/visitor