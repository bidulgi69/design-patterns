# 프로토타입 패턴 (Prototype pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/190869776-e741f2ad-0ed9-4469-91a6-889ed1387412.png" alt="structure">

* Prototype: 복제하는 인터페이스 정의.
* ConcretePrototype: 복제하는 연산(`clone()`) 구현.
* Client: 복제 요청을 통해 새로운 객체 생성.

## 요약
간단한 프로토타입 패턴 구현 예제입니다.<br>
인스턴스 `TerranBionicUnit`은 필요한 인자값이 많아 생성자를 통해 생성하는 것은 어렵습니다.<br>
이 때, `Cloneable` 인터페이스를 구현한 `clone()` 메소드를 통해 위 작업을 캡슐화하고, 단순화 할 수 있습니다.<br> 

## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%EC%83%9D%EC%84%B1-%ED%8C%A8%ED%84%B4Creational-Patterns">https://velog.io/@ha0kim/Design-Pattern-생성-패턴Creational-Patterns</a>
- https://kingchan223.tistory.com/295