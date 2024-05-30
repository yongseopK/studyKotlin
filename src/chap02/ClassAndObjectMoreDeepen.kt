package chap02

import javax.print.attribute.standard.MediaSize.Other
import kotlin.reflect.KProperty

/*
    중첩 클래스 (Nested Classes)

    - 코틀린에서는 클래스 내부에 다른 클래스를 정의할 수 있음
    - 중첩 클래스는 내부 클래스와 달리 외부 클래스의 멤버에 접근할 수 없음
    - 중첩 클래스는 static으로 간주되며, 외부 클래스의 인스턴스 없이 생성할 수 없음
 */
class Outer1 {
    private val x = 10

    class Nested {
        fun foo() = 2
    }
}


/*
    인라인 클래스 (Inline Classes)

    - 인라인 클래스는 실행 시간에 오버헤드 없이 래핑된 타입을 제공하는 데 사용됨
    - value 키워드를 사용하여 인라인 클래스를 정의할 수 있음
    - 인라인 클래스는 단일 프로퍼티만 가질 수 있으며, 프로퍼티의 타입은 기본 타입이어야 함
 */
inline class Password(private val value: String)

fun login(password: Password) {
    println("Logging in with password : $password")
}


/*
    열거형 클래스 (Enum Classes)

    - 열거형 클래스는 제한된 값들의 집합을 나타내는 데 사용됨
    - enum 키워드를 사용하여 열거형 클래스를 정의할 수 있음
    - 열거형 클래스의 인스턴스는 싱글턴이며, 각 인스턴스는 고유한 이름과 프로퍼티를 가질 수 있음
 */
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}


/*
    연산자 오버로딩 (Operator Overloading)

    - 코틀린에서는 연산자 오버로딩을 지원하여 사용자 정의 타입에 대해 연산자를 정의할 수 있음
    - operator 키워드를 사용하여 연산자 함수를 정의할 수 있음
    - 연산자 오버로딩을 통해 코드의 가독성과 표현력을 높일 수 있음
 */
data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point) = Point(x + other.x, y + other.y)
}

/*
    위임 프로퍼티 (Delegate Properties)

    - 코틀린에서는 프로퍼티의 값을 다른 객체에 위임할 수 있음
    - by 키워드를 사용하여 위임 프로퍼티를 정의할 수 있음
    - 위임 프로퍼티를 사용하면 프로퍼티의 getter와 setter를 다른 객체에 위임할 수 있음
 */
class Example {
    var p: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef")
    }
}

fun main() {
    // 중첩 클래스
    val nested = Outer1.Nested()
    println(nested.foo())

    // 인라인 클래스
    val password = Password("secret")
    login(password)

    // 열거형 클래스
    val color = Color.RED
    println(color)
    println(color.rgb)

    // 연산자 오버로딩
    val p1 = Point(1, 2)
    val p2 = Point(3, 4)
    val p3 = Point(5, 6)
    val sum = p1 + p2 + p3
    println(sum)

    // 위임 프로퍼티
    val example = Example()
    println(example.p)
    example.p = "Hello"
}