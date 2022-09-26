# 어댑터 패턴 (Adapter pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/192244640-94e96560-db2d-47fd-8e19-67c3dfd02e3d.png" alt="structure">

* Target: `Adapter`가 구현하는 인터페이스. `Client`는 `Target`을 통해 `Adaptee`를 사용한다.
* Adapter: `Client`와 `Adaptee` 중간에서 호환성이 없는 두 컴포넌트를 연결해주는 역할.
* Adaptee: `Client` 측에서 directly 하게 사용할 수 없는 외부 시스템.


## 요약
간단한 어댑터 패턴 구현 예제입니다.<br>
`Adapter`는 Composition 을 사용한 객체 어댑터 또는 `Adaptee`를 상속받는 클래스 어댑터로 구현할 수 있습니다.<br>
해당 예제는 객체 어댑터로 구현돼있습니다.<br>

`Adaptee`인 `XmlContentParser`의 메소드인 `parse()`는 인자로 Xml 파일만을 취급합니다.<br>
사용자가 Json 파일에 대해 해당 함수를 사용하려고 할 때, `JsonToXmlAdapter`가 해당 요청(Json)을 `Adaptee`가 이해할 수 있는 Xml 파일 포맷으로 변경해줍니다.<br>


## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%EA%B5%AC%EC%A1%B0-%ED%8C%A8%ED%84%B4Structural-Patterns#1-%EC%96%B4%EB%8C%91%ED%84%B0-%ED%8C%A8%ED%84%B4adapter-pattern">https://velog.io/@ha0kim/Design-Pattern-구조-패턴Structural-Patterns</a>
- https://medium.com/swlh/adapter-pattern-what-it-is-and-how-to-use-it-83e35a02e7f9
- https://jusungpark.tistory.com/22
- https://refactoring.guru/design-patterns/adapter