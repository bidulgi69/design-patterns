# 플라이웨이트 패턴 (Flyweight pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/192753226-9e01a4db-bfb3-434c-bc9b-111ce305e17d.png" alt="structure">

* Flyweight: 공유할 클래스들을 정의
* FlyweightFactory: `Flyweight` 인스턴스를 생성, 공유해주는 역할


## 요약
간단한 플라이웨이트 패턴 구현 예제입니다.<br>
플라이웨이트 패턴은 단순하게 말해, 최적화 패턴입니다.<br>
예를 들어, 동일한 객체가 메모리에 대량으로 존재한다면 해당 객체를 캐싱해 공유해주는 것입니다.<br>
객체의 포인터를 공유하기 때문에, `value object`에 대해서만 적용이 가능한 것으로 생각됩니다.<br>

병과`Specialty`는 `Soldier` 클래스를 생성할 때 중복되는 정보입니다. 캐싱을 통해 메모리 사용을 최적화할 수 있습니다.<br>

## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%EA%B5%AC%EC%A1%B0-%ED%8C%A8%ED%84%B4Structural-Patterns#6-%ED%94%8C%EB%9D%BC%EC%9D%B4%EC%9B%A8%EC%9D%B4%ED%8A%B8-%ED%8C%A8%ED%84%B4flyweight-pattern">https://velog.io/@ha0kim/Design-Pattern-구조-패턴Structural-Patterns</a>
- https://refactoring.guru/design-patterns/flyweight