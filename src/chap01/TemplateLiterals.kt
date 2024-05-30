package chap01

fun main() {


    /*
        문자열 리터럴 정의

        문자열 리터럴의 정의는 큰따옴표(")로 문자를 감싸는 것이다.

        val hello = "Hello, world!"
        ```.
        문자열에 특수 문자가 들어가면 이스케이프 시퀀스를 사용해야 한다.
        val text = "Hello, world!\nThis is \"multiline\" string" println("\u03C0 \u2248 3.14") // π ≈ 3.14

        기본적으로 자바 문자열과 같다.
        코틀린은 여러 식에서 문자열을 합성해 내는 훨씬 강력한 방법을 지원한다.
        ### 문자열 템플릿
        import java.util.Date
        fun main() {
            val name = readLine()
            println("Hello, name! \nToday is{Date()}")
        }

        기본적으로 ${} 의 중괄호 사이에 넣기만 하면 어떤 코틀린 식이든 문자열에 넣을 수 있다.
        간단한 변수 참조인 경우 $name 같이 중괄호를 생략하고 달러 기호만 붙여도 된다.
        이런 기능을 문자열 템플릿 이라고 한다.
        John을 입력하고 실행한 예
        Hello, John! Today is Wed Sep 14 08:36:12 UTC 2022


        ### 로우 문자열(raw string)
        로우 문자열을 사용하면 이스케이프 시퀀스를 사용하지 않고도 문자열을 작성할 수 있다.
        이런 리터럴은 큰따옴표 세개로 둘러 싸여 있고, 새줄 문자를 포함한 임의의 문자를 포함할 수 있다.
        val message = """ Hello,
        {Date() } """.trimIndent() ```
        trimIndent()는 여러줄에 공통된 최소 들여쓰기를 제거해 주는 표준 코틀린 함수이다.
        로우 문자열에 특수문자를 추가하고 싶은 경우 ${} 안에 특수문자를 넣으면 된다.

        val message = """
        This is triple quote : ' ${"\"\"\""} '
        """.trimIndent() // This is triple quote : ' """ '
        JVM으로 컴파일 되는 애플리케이션에서 문자열은 JVM의 String클래스로 표현된다.
     */
}