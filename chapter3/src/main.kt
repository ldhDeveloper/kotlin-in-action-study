fun <T> joinToString(collection: Collection<T>, separator: String = ", ", prefix: String = "", postfix: String = ""): String  //디폴트 파라매터 선언가능
{
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString();
}

fun main() {
    val set = hashSetOf(1, 7, 53)
    val list = listOf(1,7,53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    // 코틀린은 자바 컬렉션 사용
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    // 자바컬렉션 보다 더 많은 기능 제공
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())
    val numbers = setOf(1, 14, 2)
    println(numbers.maxOrNull())

    println(joinToString(list, "; ", "(", ")"));
    println(joinToString(list));
}
