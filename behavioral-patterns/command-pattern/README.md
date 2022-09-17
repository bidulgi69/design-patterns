# 커맨드 패턴 (Command pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/190856278-1474dcb4-b896-4d72-b50f-08712d9b0062.png" alt="structure">

* Invoker: 기능의 실행을 요청하는 호출자 클래스.
* Command: 실행될 기능들에 대한 인터페이스. 
* ConcreteCommand: 실제로 실행되는 기능을 구현한 클래스. `execute()` 함수를 구현한다.
* Receiver: `ConcreteCommand`의 `execute()`를 호출하는 클래스.
* Client: 요청 전달(`ConcreteCommand`를 `Receiver`에 설정) 클래스.

## 요약
간단한 커맨드 패턴 예제를 구현해봤습니다.<br>
클라이언트는 `Cellphone`라는 `Receiver` 클래스를 통해 `Invoker`인 `MusicPlayer`에 커맨드를 전송합니다.<br>
커맨드는 `MusicPlayerOnCommand`, `MusicPlayerOffCommand` 두 개로 이뤄져 있습니다.<br>


## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%ED%96%89%EB%8F%99-%ED%8C%A8%ED%84%B4Behavioral-Patterns#1-%EC%B1%85%EC%9E%84%EC%97%B0%EC%87%84-%ED%8C%A8%ED%84%B4chain-of-responsibility">https://velog.io/@ha0kim/Design-Pattern-행동-패턴Behavioral-Patterns</a>
- https://victorydntmd.tistory.com/295