# 책임 연쇄 패턴 (Chain of Responsibility Pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/190854983-1ead24b6-8ab7-477a-92e6-a1dc799f77af.png" alt="structure">

* Handler: 요청을 수신하고 처리 객체 집합에 전달하는 인터페이스.
* ConcreteHandler: 요청을 실제로 처리하는 객체. 다음 `Handler` 에 대한 정보를 갖고 있다.
<br>

## 요약
간단한 책임 연쇄 패턴 예제입니다.<br>
처리 객체 집합은 `StoreApiHandler`, `KitchenApiHandler`, `DeliveryApiHandler` 순서로 이뤄져 있습니다.<br>
`Client` 의 모든 요청은 `StoreApiHandler` 에게 전달되며, 처리 객체가 자신이 처리할 수 없다고 판단되면 집합의 다음 객체에게 요청 정보를 넘겨줍니다.


## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%ED%96%89%EB%8F%99-%ED%8C%A8%ED%84%B4Behavioral-Patterns#1-%EC%B1%85%EC%9E%84%EC%97%B0%EC%87%84-%ED%8C%A8%ED%84%B4chain-of-responsibility">https://velog.io/@ha0kim/Design-Pattern-행동-패턴Behavioral-Patterns</a>