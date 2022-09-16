# 이터레이터 패턴 (Iterator pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/190697219-a4b1ce5a-4c59-4054-ad82-540b890a43c3.png" alt="structure">

* Iterator: 순서대로(`next()`) 객체를 검색하는 인터페이스
* Aggregate: `Iterator` 역할을 생성하는 인터페이스
<br>

## 요약
간단한 이터레이터 패턴 예제를 구현해봤습니다.<br>
`Classroom` 는 `ConcreteAggregate` 를 구현한 클래스로, `Student` 배열을 조회하는 `Iterator` 를 생성하는 클래스입니다.<br>
`ClassroomIterator` 는 `ConcreteIterator` 를 구현한 클래스로, `Student` 배열을 조회하는 역할입니다.

## Usage

    ./gradlew test


## References
<a href="https://velog.io/@ha0kim/Design-Pattern-%ED%96%89%EB%8F%99-%ED%8C%A8%ED%84%B4Behavioral-Patterns#4-%EC%9D%B4%ED%84%B0%EB%A0%88%EC%9D%B4%ED%84%B0-%ED%8C%A8%ED%84%B4-iterator-pattern">https://velog.io/@ha0kim/Design-Pattern-행동-패턴Behavioral-Patterns</a>