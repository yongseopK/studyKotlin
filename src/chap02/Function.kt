package chap02


fun main() {

    /*
        함수의 기본구조

        fun 함수명(매개변수1: 타입1, 매개변수2: 타입2, ...): 반환타입 {
            함수 본문
            return 반환값
        }

        함수명 : 함수의 이름으로, 관례적으로 camelCase를 사용
        매개변수 : 함수에 전달되는 입력값으로, 생략이 가능하다.
                   매개변수는 이름: 타입 형식으로 선언함
        반환타입 : 함수가 반환하는 값의 타입이다. 반환값이 없는 경우 Unit으로
                   표시할 수 있음. 반환타입은 생략 가능하다.
        함수본문 : 함수가 수행할 작업을 담고있는 코드 블록
     */

    //함수 예시
    fun greet(name: String): String {
        return "Hello, $name!"
    }

    // 함수 사용
    val message = greet("Seop")
    println(message)

    /*
        함수를 간결하게 작성하는 방법

        1. 반환타입이 추론 가능한 경우 생략할 수 있으며
           함수 본문이 단일 표현식으로 이루어진 경우 간량하게 작성할 수 있음
     */
    fun square(x: Int) = x * x

    /*
        확장 함수 (Extension Functions)

        - 기존 클래스에 새로운 함수를 추가할 수 있는 기능임.
        - 클래스 내부를 수정하지 않고도 함수를 추가할 수 있어 코드의 모듈성과
          가독성을 높일 수 있음
        - 확장 함수는 "fun 클래스명.함수명(매개변수): 반환타입 {...}" 형태로 선언함
     */
    fun String.capialize(): String {
        return this.capialize()
    }

    /*
        중위 표기법 (Infix Notation)

        - 함수 호출 시 점(.)과 괄호를 생략하고 함수명을 중위 표기법으로 사용할 수 있음
        - 함수 선언 시 infix 키워드를 사용하여 중위 표기법을 사용 가능하도록 표시함
     */
    infix fun Int.multiply(other: Int): Int {
        return this * other
    }

    println(3 multiply 4) // result : 12

    /*
        지역 함수 (Local Functions)

        - 함수 내부에 또 다른 함수를 정의할 수 있음
        - 지역 함수는 상위 함수의 번위 내에서만 접근 가능하며, 상위 함수의
          변수에 접근할 수 있음
     */
    fun outerFunction(x: Int) {
        fun localFunction(y: Int) {
            println(x + y)
        }

        localFunction(5)
    }

    /*
        고차 함수 (Higher-Order Functions)

        - 함수를 매개변수로 받거나 함수를 반환하는 함수를 고차 함수라고 함
        - 코틀린에서는 함수 타입을 지원하여 고차 함수를 쉽게 다룰 수 있음
     */
    fun applyOperation(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
        return operation(x, y)
    }

    fun sum(a: Int, b: Int): Int {
        return a + b;
    }

    val result = applyOperation(3, 4, ::sum)
    println(result)

    /*
        함수 타입 별칭 (Function Type Aliases)

        - 함수 타입을 별도의 타입 별칭으로 정의할 수 있음
        - 함수 타입 별칭을 이용하면 코드의 가독성을 높이고 함수 타입을 재사용할 수 있음
     */


    fun applyOperation1(x: Int, y: Int, operation: Operation): Int {
        return operation(x, y)
    }

    println(applyOperation1(3, 4, { a, b -> a + b }))

    /*
        인라인 함수 (Inline Functions)

        - 함수를 호출하는 대신 함수 본문을 호출 지점에 직접 삽입하는 기능
        - 인라인 함수를 사용하면 함수 호출 오버헤드를 줄일 수 있음
        - 함수 선언 시 inline 키워드를 사용하여 인라인 함수로 표시함
     */
    inlineFunction { println("Inside block") }

    /*
        비지역 반환 (Non-Local Returns)

        - 람다식 내부에서 람다식을 포함하는 함수를 종료하고 반환할 수 있음
        - 비지역 반환을 사용하면 복잡한 제어 흐름을 간단하게 표현할 수 있음
     */
    fun nonLocalReturn(list: List<Int>) {
        list.forEach {
            if (it == 0) {
                return
            }
            print("$it ")
        }
        println("End of function")
    }

    nonLocalReturn(listOf(1, 2, 0, 3))

    /*
        확장 프로퍼티 (Extension Properties)

        - 기존 클래스에 새로운 프로퍼티를 추가할 수 있는 기능
        - 확장 프로퍼티는 클래스 내부를 수정하지 않고도 프로퍼티를 추가할 수 있어
          코드의 모듈성을 높일 수 있음
     */


    val str = "Hello"
    println(str.lastChar)
}

// 함수 타입 별칭
typealias Operation = (Int, Int) -> Int


// 인라인 함수
inline fun inlineFunction(block: () -> Unit) {
    println("Before block")
    block()
    println("After block")
}

// 확장 프로퍼티
val String.lastChar: Char
    get() = this[length - 1]