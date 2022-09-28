# 프록시 패턴 (proxy pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/192812840-774ac972-6b71-4be2-a620-178561aa534c.png" alt="structure">

* ServiceInterface: `Service`와 `Proxy`를 동일하게 다루기 위한 인터페이스.
* Proxy: `Service`에 대한 레퍼런스 유지. `Client`는 `Proxy`를 통해 `Service`를 동일하게 사용할 수 있다.

## 요약
간단한 프록시 패턴 구현 예제입니다.<br>
프록시 패턴은 가상 프록시, 보호 프록시, 원격 프록시 등 다양한 종류가 있지만,<br>
기본적으로 `Client`가 `Service`를 직접 참조하지 않고 `Proxy` 객체를 통해 기능을 대리한다는 점이 동일합니다.

`VirtualProxy`는 가상 프록시 패턴을 구현했습니다. `Proxy` 객체를 통해 `Service`를 참조하도록 되어있는데, 이 때 `Service`에 대한 레퍼런스를 `Client`의 사용 직후에 생성함으로써 이점을 얻을 수 있습니다. (lazy init)<br>
`ProtectionProxy`는 보호 프록시 패턴을 구현했습니다. `invocationHandler`를 구현함으로써, 특정 메소드 호출 이전에 실행 여부를 결정지을 수 있습니다.<br>

## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%EA%B5%AC%EC%A1%B0-%ED%8C%A8%ED%84%B4Structural-Patterns#7-%ED%94%84%EB%A1%9D%EC%8B%9C-%ED%8C%A8%ED%84%B4proxy-pattern">https://velog.io/@ha0kim/Design-Pattern-구조-패턴Structural-Patterns</a>
- https://today-retrospect.tistory.com/102#05
- https://refactoring.guru/design-patterns/proxy
- https://www.baeldung.com/java-proxy-pattern
