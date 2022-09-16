# 인터프리터 패턴 (Interpreter pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/190687554-4566ef88-3328-47f2-85ca-c46694ff75c6.png" alt="structure">

* AbstractExpression: 추상 구문 트리에 속한 모든 노드(Expression)에 해당하는 클래스들이 구현해야할 `interpret()` 메소드를 선언한 인터페이스.
* TerminalExpression: 문법에 정의한 터미널 기호와 관련된 해석 방법을 구현. (e.g. `VariableExpression`)
* NonTerminalExpression: 터미널 기호가 아닌 모든 기호에 대해 interpret() 메소드를 구현. 일반적으로 다른 expression 들을 재귀적으로 호출한다. (e.g. `PlusExpression`)
* Context: String expression, 인터프리터에 보내는 정보(해석 대상).
* Client: `interpret()` 호출.
<br>

## 요약
후위 연산 표현식에 대한 계산기를 구현해봤습니다.<br>
`[0-9]` 는 다른 expression 을 참조하지 않고 단순히 숫자 값을 반환하면 되기 때문에, `TerminalExpression` 이라고 할 수 있습니다.<br>
`+, -, *, /` 과 같은 사칙연산은 두 개의 expression 을 `interpret` 한 뒤 결과를 연산하는 `NonTerminalExpression` 이라고 할 수 있습니다.<br>


## Usage

    chmod +x ./gradlew && ./gradlew test

## References
- https://johngrib.github.io/wiki/pattern/interpreter/
- https://kingchan223.tistory.com/311
- <a href="https://velog.io/@ha0kim/Design-Pattern-%ED%96%89%EB%8F%99-%ED%8C%A8%ED%84%B4Behavioral-Patterns#3-%EC%9D%B8%ED%84%B0%ED%94%84%EB%A6%AC%ED%84%B0-%ED%8C%A8%ED%84%B4interpreter-pattern">https://velog.io/@ha0kim/Design-Pattern-행동-패턴Behavioral-Patterns</a>