# 파사드 패턴 (Facade pattern)

## 구조
<img src="https://user-images.githubusercontent.com/17774927/192750636-21b50c5d-591f-4e67-8f21-75baa751d6d5.png" alt="structure">

* Facade: `Subsystem Class`들과 상호작용하는 인터페이스. 복잡한 과정을 간편화된 인터페이스로 제공한다.
* Subsystem Class: `Facade`를 통해 접근되는 라이브러리, API 등.

## 요약
간단한 파사드 패턴 구현 예제입니다.<br>
파사드 패턴은 라이브러리 또는 복잡한 클래스들의 집합에 대해 간편화된 인터페이스를 제공해주는 패턴입니다.<br>

해당 예제는 유튜브 영상을 mp3 파일로 추출해주는 기능을 `YoutubeParser`라는 인터페이스의 함수로 간편화합니다.<br>
사용자가 입력한 영상의 url 에서 `videoId`를 추출하고, HTTP 연결을 하고, 요청을 보내 데이터를 받아온 byte 배열을 File 로 쓰는 작업을 `convert(url)` 함수로 간편화했습니다.<br>

## References
- <a href="https://velog.io/@ha0kim/Design-Pattern-%EA%B5%AC%EC%A1%B0-%ED%8C%A8%ED%84%B4Structural-Patterns#5-%ED%8D%BC%EC%82%AC%EB%93%9C-%ED%8C%A8%ED%84%B4facade-pattern">https://velog.io/@ha0kim/Design-Pattern-구조-패턴Structural-Patterns</a>
- https://refactoring.guru/design-patterns/facade