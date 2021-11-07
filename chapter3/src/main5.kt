import java.lang.Thread.sleep

data class Person(val name: String, val age: Int)

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

//fun main() {
//    val people = listOf(Person("Alice", 29), Person("Bob", 31))
//    findTheOldest(people)
//}

fun printSample() { println("print!!!") }

fun main() {
    //람다 표현식
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
//    println(people.maxByOrNull { it.age }) // it은 인자를 가리킨다
//    println(people.maxByOrNull() { p: Person -> p.age })
//    println(people.maxByOrNull({ p: Person -> p.age }))
//    println(people.maxByOrNull { p: Person -> p.age })
//    println(people.maxByOrNull { p -> p.age }) // 타입제거도 가능(컴파일러가 추론)


    //함수 파라미터 사용
    fun printStatus(messages: List<String> = listOf("404", "500"), prefix: String = "code" ) {
        messages.forEach {
            println("$prefix $it")
        }
    }
    //printStatus()

    //람다 안에서 바깥 로컬 변수 변경
    fun printErrorCount(codes: List<String> = listOf("200", "303", "400","404", "500")){
        var clientErrors = 0;
        var serverErrors = 0;
        codes.forEach {
            if (it.startsWith("4")) {
                clientErrors++;
            } else if (it.startsWith("5"))  {
                serverErrors++;
            }
        }
        println("$clientErrors client error, $serverErrors server error")
    }
//    printErrorCount()

    //비동기
    fun clickTest(): Int {
        var click = 0
        click++
        Thread {
            click++
            sleep(1000);
        }
        return click;
    }
//    println(clickTest())

//    run(::printSample)

    // 맴버참조
//    println(people.maxByOrNull (Person::age))
    var age = Person::age
    val p = Person("lee", 33)
//    println(age(p))

    //바운드 맴버참조
    val childAge = p::age
//    println(childAge())


    //filter
    val list = listOf(1, 2, 3, 4)
//    println(list.filter { it % 2 == 0 }) //짝수만 필터링


    //map
    val list2 = listOf(1, 2, 3, 4)
//    println(list2.map { it * it }) //제곱 만들기 (1x1, 2x2, 3x3, 4x4)

    val under30 = { p:Person -> p.age < 30 }
    val people2 = listOf(Person("안드로이드", 25), Person("코틀린", 33))
    //all
//    println(people2.all(under30))
    //any
//    println(people2.any(under30))
    //count
//    println(people2.count(under30))
    //find
//    println(people2.find(under30))

    val people3 = listOf(
        Person("안드로이드", 25),
        Person("코틀린", 30),
        Person("자바", 30))

    //groupBy
//    println(people3.groupBy { it.age })

    //flatMap
    val strings = listOf("abc", "def", "abe", "fgh");
//    println(strings.flatMap { it.toList() })

    //with
    fun alphabet() = with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I Know the alphabet!")
        toString()
    }
//    println(alphabet())

    //apply
    fun alphabetUsingApply() = StringBuilder().apply {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I Know the alphabet!")
    }.toString()
//    println(alphabetUsingApply())
}
