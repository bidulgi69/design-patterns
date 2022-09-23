# 메멘토 패턴 (Memento pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/191928384-818a6b87-5b20-48ae-8c45-1814f96e06d6.png" alt="structure">

* Originator: 객체의 상태를 저장. `Memento`를 생성하며, 후에 `Memento` 객체를 사용해 실행 취소할 수 있다.
* Memento: `Originator`의 상태를 유지하는 객체.
* Caretaker: 복수의 `Memento`의 상태를 유지해주는 객체.


## 요약
간단한 메멘토 패턴 구현 예제입니다.<br>
Spring 에서 지원하는 `@Transactional` 처럼, 에러 발생 시 Entity 를 롤백시켜주는 기능을 메멘토 패턴으로 구현해봤습니다.<br>


## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%ED%96%89%EB%8F%99-%ED%8C%A8%ED%84%B4Behavioral-Patterns-2#11-%EA%B8%B0%EB%85%90%ED%92%88-%ED%8C%A8%ED%84%B4-memento-pattern">https://velog.io/@ha0kim/Design-Pattern-행동-패턴Behavioral-Patterns-2</a>
- https://refactoring.guru/design-patterns/memento
- https://en.wikipedia.org/wiki/Memento_pattern