# 옵저버 패턴 (Observer pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/190711800-b4987f7a-a746-4a13-89a5-0f34cedf97bf.png" alt="structure">

* Observer: 데이터의 변경을 통보받는 인터페이스. Subject 에서 발생한 데이터 변경은 `notifyObservers()` 메소드 호출로 `ConcreteObserver` 에게 통보된다.
* Subject: `ConcreteObserver` 객체를 관리하는 컴포넌트. `Observer` 인터페이스를 참조해서 `ConcreteObserver` 를 관리하므로, `ConcreteObserver` 의 변화에 독립적일 수 있다.
* ConcreteSubject: 데이터 변경을 위한 `setState()` 메소드를 소유한 컴포넌트. `setState` 로 자신의 데이터를 업데이트 한 뒤, `notifyObservers()` 메소드를 호출한다.
* ConcreteObserver: `ConcreteSubject` 의 변경을 통보받는 컴포넌트. 변경된 데이터는 `ConcreteSubject` 의 `getState()` 메소드를 호출해 조회한다. (또는 `notify()` 함수의 인자로 넘겨준다.)
<br>

## 요약
간단한 옵저버 패턴 예제를 구현해봤습니다.<br>
`Publisher` 는 `ConcreteSubject` 를 구현한 클래스로 자신이 소유한 데이터 변경 시 `ConcreteObserver` 의 `notify()` 메소드를 호출합니다.<br>
`Subscriber` 는 `ConcreteObserver` 를 구현한 클래스로 `Publisher` 의 데이터 변경 시 호출되는 클래스입니다.<br>
<br>
코틀린의 경우 `Delegates.observable()` 을 이용해 옵저버 패턴을 구현할 수 있습니다.
`TextView`, `TextViewSubscriber` 는 각각 `ConcreteSubject`, `ConcreteObserver` 를 구현한 클래스입니다.<br>

## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%ED%96%89%EB%8F%99-%ED%8C%A8%ED%84%B4Behavioral-Patterns#5-%EC%98%B5%EC%A0%80%EB%B2%84-%ED%8C%A8%ED%84%B4observer-pattern">https://velog.io/@ha0kim/Design-Pattern-행동-패턴Behavioral-Patterns</a>
- https://github.com/dbacinski/Design-Patterns-In-Kotlin#observer--listener
