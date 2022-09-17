# 싱글톤 패턴 (Singleton pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/190868083-b44f48be-c8f5-45e9-9272-1bba262b9014.png" alt="structure">

* Singleton(): 하나의 인스턴스만을 유지하기 위해서 `new`를 실행할 수 없도록 생성자를 private 으로 선언, 정적 참조변수에 값을 저장한다.
* getInstance(): 위와 동일하게 단일 객체를 유지하기 위해서 정적 메소드를 지원해야한다.


## 요약
간단한 싱글톤 패턴을 구현한 예제입니다.<br>
위애서 설명했듯이 `Singleton` 클래스인 `Counter`는 단일 인스턴스를 지원하기 위한 private 생성자, 정적 참조변수, 정적 메소드를 지원합니다.<br>
`Counter` 클래스는 멤버 변수인 `count` 값을 업데이트할 수 있는데, 멀티스레드 환경에서는 race condition 이 발생할 수 있다.<br>
이를 방지하기 위해서 정적 참조변수를 선언과 동시에 초기화하고, `synchronized` 키워드를 활용해 멀티스레드 환경에서도 정상적으로 지원할 수 있도록 만들었습니다.

## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%EC%83%9D%EC%84%B1-%ED%8C%A8%ED%84%B4Creational-Patterns">https://velog.io/@ha0kim/Design-Pattern-생성-패턴Creational-Patterns</a>