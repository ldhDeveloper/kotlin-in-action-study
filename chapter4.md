# 4. 클래스, 객체, 인터페이스
## 4.1 클래스 계층 정의
### interface
* interface 사용 (java => extends/implements 인터페이스명, kotlin =>  :인터페이스명)
* 오버라이드시 override 반드시 명시
### open, final, abstract변경자
* kotlin에서 default final => 상속금지
* 상속가능하게 하려는경우 open명시(예: open fun 함수명()) 
* abstract(추상클래스)의 경우 open을 명시할 필요가 없다(반드시 오버라이드 해야만함)
### 가시성 변경자
* public(모든곳에서 접근가능)
, protected(같은/하위 클래스에서 접근가능)
, private(같은 클래스에서만 접근가능)
, internal(같은 모듈에서 접근가능 - 코틀린에서 추가)
* 기본 가시성은 public
* protected의 경우 자바와 코틀린의 내용이 다름(JAVA => 같은 패키지 안에서 접근가능, 코틀린 => 자신클래스와 상속받은 클래스에서만 가능)
### 봉인된 클래스
* sealed 변경자를 사용하여 상위 클래스를 상속한 하위클래스의 정의를 제한가능
* 봉인된 클래스는 클래스 외부의 자신을 상속한 클래스를 둘수 없음

## 4.2 뻔하지 않은 생성자와 프로퍼티를 갖는 클래스 선언
### 클래스 초기화
```
class User(val nickname: String)   -> nickname이라는 프로퍼티가 생성
=
class User constructor(_nickname: String) {
    val nickname: String
    init {
        nickname = _nickname
    }
   }
```
* 클래스의 선언시 주생성자를 생성할수 있다
```
class User(val nickname: String, val isSubscribed: Boolean = true)
```
* 디폴트 값을 지정한 프로퍼티 생성도 가능하다
### 부 생성자
* 여러개의 생성자 가 필요한 경우 부 생성자를 선언할수 잇따
* 부 생성자는 constructor 키워드로 시작한다
* 클래스에 주 생성자가 없다면 모든 부 생성자는 상위 클래스를 초기화하거나 다른 생성자에게 생성을 위임해야한다.

### 인터페이스에 선언된 프로퍼티 구현
* 프로퍼티의 getter setter를 커스텀으로 구현가능하다
* get과 set의 가시성을 변경할 수 있다

##4.3 컴파일러가 생성한 메소드
* JAVA와 마찬가지로 toString, equals, hashCode 등의 메소드를 자동 생성해주고 오버라이드도 가능하다.
* by 키워드를 사용하여 인터페이스에 대한 구현을 다은 객체에 위임하여 사용이 가능하다.(코드를 줄일 수 있다.)

##4.4 object 키워드: 클래스 선언과 인스턴트 생성
* 객체(object) 선언시 싱글턴 클래스를 정의할수 있다.
* 동반 객체는 정적 메소드와 필드의 정의를 대신한다.
* 외부에서 동반 객체에 대한 확장함수와 프로퍼티 정의가 가능하다.
* 무명 객체는 JAVA의 무명 내부 클래스를 대신한다.