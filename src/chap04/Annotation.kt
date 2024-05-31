package chap04

/*
    @JvmStatic

    - 코틀린 컴패니언 객체의 멤버를 자바의 static 멤버로 노출시킴
        -> 자바에서 코틀린 컴패니언 객체의 멤버를 사용하려면 Class.Companion.method()
           같은 형식을 사용해야하는데, 해당 애너테이션을 사용하면 Class.method()로 사용가능
 */
class MyClass {
    companion object {
        @JvmStatic
        fun myStaticMethod() {
            println("This is a static method")
        }
    }
}


/*
    @JvmOverloads

    - 자바에서 사용할 때 기본 인자를 가진 함수의 오버로드를 생성함
        -> 자바에서 호출할 때 기본 인자를 생략하고 호출할 수 있음
 */
@JvmOverloads
fun myFunction(a: Int, b: String = "default") {
    println("a: $a, b: $b")
}


/*
    @JvmName

    - 자바에서 사용할 때 함수나 속성의 이름을 변경함
        -> 코틀린 코드에서 정의한 이름과 다른 이름으로 자바 코드에서 노출할 수 있음

    사용 예시
        - 코틀린의 예약어와 충동을 피하기 위해 이름을 변경해야 할 때
        - 자바의 네이밍 컨벤션에 맞추기 위해 이름을 변경해야 할 때
        - 오버로딩된 함수나 속성의 시그니처가 자바에서 충돌할 때

    ex) @JvmName("contains")
        fun `in`(element: Int): Boolean {
            return true
        }
        - in은 코틀린의 예약어라서 함수이름으로 사용할 수 없는데, JvmName을 사용하면
          자바에서 contains라는 이름으로 호출할 수 있음
 */


@JvmName("myRenamedFunction")
fun myFunction() {
    println("This function will be renamed in Java")
}

// 자바 호출 예시 : Class.myRenamedFunction();


/*
    @Throws

    - 함수가 발생시킬 수 있는 예외를 명시적으로 선언할 수 있음
        -> 코드 실행 시 별다른 기능은 하지 않지만, 코드 가독성과 자바의 상호 운용성을 위해 사용
 */
@Throws(IllegalArgumentException::class)
fun myFunction1(value: Int) {
    if(value < 0) {
        throw IllegalArgumentException("Value must be non-negative")
    }
}


/*
    @Deprecated

    - 함수, 클래스 등이 더 이상 사용되지 않음을 나타냄
        -> 대체되는 함수, 클래스를 명시적으로 알려줄 수 있음
 */
@Deprecated("Use newFunction() instead", ReplaceWith("newFunction()"))
fun oldFunction() {
    // ...
}

fun newFunction() {
    // ...
}

