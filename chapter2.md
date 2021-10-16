#Chapter 2 코틀린 기초
## 함수 와 변수
코틀린 문법 특징 
* 함수 선언 => fun
* 파라미터 이름뒤에 파라미터 타입선언
* 함수를 최상위 수준에 정의가능(클래스 내부에 생성하지 않아도 됨)
* 배열도 일반적인 클래스와 마찬가지
* System.out.println() -> println()
* 세미콜론을 마지막에 붙이지 않아도 됨

### 함수 
#### 코틀린 함수정의
```
function max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
println(max(1, 2)) 
```
### 변수
#### 코틀린 변수정의
```
val a: Int
a = 42
a = 20 (X)

var b: Int
b = 25
b = 21 (O)
```
* val: 변경 불가능한 참조를 저장하는 변수
* var: 변경 가능한 참조를 저장하는 변수

#### 문자열 템플릿
* ${변수}를 사용해서 문자열 템플릿을 사용가능
```
fun main(text: String) {
    println("text: ${text}")
}
```

### 클래스와 프로퍼티
* 클래스 선언시 public생략가능(기본 가시성 => public)
* 클래스 생성자 호출시 new 키워드 사용X
* val => 비공개 필드, 공개 getter 생성
* var => 비공개 필드, 공개 getter, 공개 setter 생성
```
class Person(
    val name: String,
    var isMarried: Boolean
)

val person = Person("Bob", true)
println(person.name)
person.isMarried = false
println(person.isMarried)
```

### enum과 when
#### enum
* enum 선언시 enum class
```
enum class Color (val r: Int, val g: Int, val b: Int) {
    RED(255,0,0),ORANGE(255,165,0); <- 세미콜론 필수
    fun rgb() = (r * 256 + g) * 256 + b <- 메소드 정의 가능
} 
```
####when
* Java swtich -> kotlin when
* switch의 경우 조건에 상수와 숫자만 가능하지만 when의 경우 객체허용
* 인자 없이도 사용가능 
* when을 사용하여 if문과 같은 분기 처리가능

### 스마트캐스트
* JAVA와 달리 타입검사 후 명시적으로 변수 캐스팅을 하지 않더라도 kotlin의 컴파일러가 캐스팅을 수행 

### for
* JAVA의 for와 비슷 하지만 이터레이션하면서 원소와 인덱스를 함께 사용할때 더 편리 (for..in)

### in
* 컬렉션이나 범위의 원소 검사 가능
```
println("Kotlin" in "Java".."Scala") -> Java <= Kotlin && Kotlin <= Scala
true 
println("Kotlin" in setOf("Java", "Scala") -> 객체에 Kotlin 존재여부
false
```

### 예외처리
* 함수가 던질 수 잇는 예외를 미리 선언하지 않아도 가능