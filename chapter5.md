# 5. 람다로 프로그래밍

## 5.1 람다 : 코드 블록을 함수 인자로 넘기기
* 클래스를 선언하고 클래스 인스턴스에 함수를 넘기는 방식이 아닌 람다 식을 사용하여 코드 블록을 함수 인자로 전달한다.
```
button.setOnClickListener{ /* 클릭 시 수행할 동작 */ }
```
* 코틀린에서 람다나 맴버 참조 함수를 인자로 받는 함수를 통해 짧고 이해하기 쉽게 개선이 가능
* 람다는 값처럼 여기저기 전달할 수 있는 동작의 모음
```
{ x: Int, y: Int -> x + y }            
```
람다 식은 중괄호로 둘러싸여 있고 -> 를 기준으로 인자 목록과 람다 본문을 구분해준다.

* 람다의 파라미터가 하나 뿐이고 그 타입을 컴파일러가 추론할 수 있는경우 it을 사용할수 있다.(하지만 명시하는 편이 낫다)
* 람다를 변수에 저장할 때는 반드시 파라미터 타입을 명시해야 한다.(추론할 문맥이 존재하지 않는다.)
* 람다에서 함수의 파라미터의 사용이 가능하다.
* 람다안에서 로컬 변수의 값 변경이 가능하다.(비동기적으로 실행될경우 함수 호출이 끝난다음 로컬변수가 변경될수도 있다.)

### 맴버참조
이중클론(::)을 사용하요 맴버 참조가 가능하다. 
```
val nextAction = ::sendEmail
```
람다 대신 맴버 참조도 가능하다

## 5.2 컬렉션 함수형 API
### filter
* 컬렉션에서 원치 않는 원소를 제거한다
```
/* 리스트에서 짝수만 뽑아내는 예제 */

>>> val list = listOf(1, 2, 3, 4)
>>> println(list.filter { it % 2 == 0 }) //짝수만 필터링
[2, 4]
```
### map
* 각원소에 적용한 결과를 모아서 새 컬랙션을 만든다
```
/* 각 원소의 제곱으로 모인 리스트를 만드는 map 예제 */

>>> val list = listOf(1, 2, 3, 4)
>>> println(list.map { it * it }) //제곱 만들기 (1x1, 2x2, 3x3, 4x4)
[1, 4, 9, 16]
```
### count
* 조건에 만족 하는 원소의 수를 반환
```
/* 사람 리스트 -> 이름 리스트 변환 예제 */

>>> val people = listOf(Person("안드로이드", 29), Person("코틀린", 30))
>>> println(people.map { it.name })
[안드로이드, 코틀린]
```
### all 
* 모든 원소가 만족하는지
```
>>> val people = listOf(Person("안드로이드", 25), Person("코틀린", 33))
>>> println(people.all(under30))
false

```
### any
* 만족하는 원소가 하나라도 있는지
### find
* 조건에 만족하는 첫번째 원소
### groupBy
* 리스트를 여러 그룹으로 이뤄진 맵으로 변경
### flatMap
* 여러 리스트를 한 리스트로 모은다(중복제거)

## 5.3 지연 계산 컬렉션 연산
* 컬렉션 함수를 연쇠적으로 사용할 경우 매단계마다 중간 결과를 임시로 담는다
* 중간 결과를 저장하지 않고 효율적으로 사용하기 위헤 Sequence 인터페이스를 사용한다 이 과정을 지연 계산 연산이라 한다.

### 시퀀스 연산
* 시퀀스 연산은 원소를 한번에 하나씩 처리한다 (즉시 계산의 경우 전체 컬렉션에 연산을 적용)
* 앞의 연산과정에서 제외된경우 다음연산을 진행하지 않아 전체 변환 횟수가 줄어든다.
* generateSequence 함수를 사용해 시퀀스를 만들수 있다.

## 5.4 자바 함수형 인터페이스 활용
* 코틀린 람다를 자바 API에 활용할 수 있다.
* * 함수형 인터페이스를 인자로 하는 자바 메소드에 코틀린 람다를 전달 할 수있다. (예: Runable, Callable)
```
/* 자바 */
void post(int delay, Runnable run)


/* 코틀린 */
post(1000) { println("람다로 전달") }
```
컴파일러가 자동으로 람다를 Runnable로 변환해줌


* 람다를 함수형 인터페이스로 명시적 변경이 가능(변수에 저장도 가능하다)
```
fun createAllDoneRunnable(): Runnable {
    return Runnable { println("Done!") }
}

>>> createAllDoneRunnable().run()

Done!
```
```
/* SAM 생성자를 사용해 리스너 재사용 하기 */
val listener = View.OnClickListener { view ->
    val text = when (view.id) {
        R.id.button1 -> "First Button"
        R.id.button2 -> "Second Button"
        else -> "Unknown Button"
    }
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

button1,setOnClickListener(listener)
button2,setOnClickListener(listener)
```
## 5.5 수신객체 지정 람다
### with
객체의 이름을 반복하지 않고 그 객체에 접근이 가능함
### apply
객체의 이름을 반복하지 않고 그 객체에 접근이 가능하고 자신에게 전달된 객체를 반환환다.