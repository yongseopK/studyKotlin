package chap02

/*
    클래스 위임 (Class Delegation)

    - 코틀린에서는 클래스 위임을 통해 상속의 대안으로 컴포지션(composition)을 사용할 수 있음
    - by 키워드를 사용하여 다른 클래스의 멤버를 위임할 수 있음
    - 이를 통해 코드 재사용성을 높이고 유연한 설계를 할 수 있음
 */
interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        print(x)
    }
}

class Derived(b: Base) : Base by b

val c = BaseImpl(10)
val derived = Derived(c)

/*
    클래스 봉인 (Sealed Classes)

    - 봉인 클래스는 클래스 계층 구조를 제한하는 데 사용됨
    - 봉인 클래스의 하위 클래스는 같은 파일 내에서만 정의할 수 있음
    - when 식에서 봉인 클래스를 사용하면 모든 하위 클래스를 처리해야 하므로 안전성이 높아짐
 */
sealed class Result
class  Success(val data: String) : Result()
class Error(val message: String) : Result()

fun getResult(): Result {
    val isSuccess = true // 예시로 성공/실패를 결정하는 변수

    return if (isSuccess) {
        Success("Data from server")
    } else {
        Error("Error occurred")
    }
}


/*
    내부 클래스 (Inner Classes)

    - 내부 클래스는 다른 클래스 내부에 정의된 클래스임
    - 내부 클래스는 외부 클래스의 멤버에 접근할 수 있음
    - inner 키워드를 사용하여 내부 클래스를 정의할 수 있음
 */
class Outer {
    private val x = 10

    inner class Inner {
        fun getX() = x
    }
}

val outer = Outer()
val inner = outer.Inner()


/*
    객체 식 (Object Expressions)

    - 객체 식은 익명 객체를 생성하는 데 사용됨
    - 객체 식을 사용하면 클래스를 정의하지 않고도 일회성 객체를 생성할 수 있음
    - 객체 식은 인터페이스나 추상 클래스를 구현할 수 있음
 */
interface EventListener {
    fun onEvent(event: String)
}

fun registerListener(listener: EventListener) {
    // ...
}


/*
    지연 초기화 (Lazy Initalization)

    - 코틀린에서는 lazy 함수를 사용하여 지연 초기화를 구현할 수 있음
    - lazy 함수는 람다식을 인자로 받아 Lazy 객체를 반환함
    - Lazy 객체는 첫 번째 접근 시점에 초기화되며, 이후에는 캐시된 값을 반환함
 */
val value: String by lazy {
    println("Initalizing value")
    "Hello, World!"
}


/*
    데이터 클래스와 불변성 (Data Classes Immutability)

    - 데이터 클래스는 불변 객체를 생성하는 데 유용함
    - data 키워드로 정의된 데이터 클래스는 equals(), hashCode(), toString() 등의
      메서드를 자동으로 생성함
    - 데이터 클래스의 프로퍼티는 val로 선언하여 불변성을 유지할 수 있음
 */
data class Person1(val name: String, val age: Int)



fun main() {
    // 클래스 위임
    derived.print() // 출력: 10

    // 클래스 봉인
    when (val result = getResult()) {
        is Success -> println("\ndata : ${result.data}")
        is Error -> println("\nError : ${result.message}")
    }

    // 내부 클래스
    println(inner.getX())

    // 객체 식
    // 객체 식을 사용하여 EventListener 인터페이스를 구현하는 익명 객체 생성
    registerListener(object : EventListener {
        override fun onEvent(event: String) {
            println("Event received: $event")
        }
    })

    // 지연 초기화
    println(value) // 출력: Initializing value\nHello, World!
    println(value) // 출력: Hello, World!

    // 데이터 클래스 불변성
    val person = Person1("seop", 24)
    println(person)
}

