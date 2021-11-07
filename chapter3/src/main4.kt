interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String): User

class SubscribingUser(val email: String): User {
    override val nickname: String
        get() = email.substringBefore('@')
}
fun main() {
    println(PrivateUser("test@kotlinlang.org").nickname)
    println(SubscribingUser("test@kotlinlang.org").nickname)
}

