package chap01

fun main() {

    // Java는 타입을 명시적으로 작성해야 하지만,
    // Kotlin은 타입 추론을 지원하기에 생략가능

    // Java의 변수 선언
    // String hello = "안녕하세요";
    // int a = 1234567;

    // Kotlin의 변수 선언
    var a = "안녕하세요"
    var b = 1234567890

    // 타입을 명시적으로 정의할 수 있음
    var c: String = "기분좋다"

    // Null이 들어갈 수 있음을 명시적으로 표시 가능
    // Null-Safety 기능을 지원
    var d: String? = ""

    // 상수선언
    // val을 사용하여 Java의 final과 비슷한 변수선언 가능
    val e = 1234
    // e = 3456 X

    // 변수(상수) 선언 시 초깃값 생략 가능
    val text: String
    var line: String

    // 상수 초깃값 생략 시 1회 값 넣기 가능
    text = "안녕하세요"

    line = "안녕하세요"

}