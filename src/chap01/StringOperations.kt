package chap01

fun main() {

    // length, lastIndex

    // 모든 String 인스턴스는 문자열에 들어있는 문자 수를 표현하는 length와
    // 문자열의 마지막 문자 인덱스를 표현하는 lastIndex 프로퍼티를 제공한다.
    "Hello!".length // 6
    "Hello!".lastIndex // 5

    // []로 개별문자 접근

    // [] 연산자에 인덱스를 넣어 개별문자에 접근할 수 있다.
    // 인덱스는 0부터 시작한다.
    // 잘못된 인덱스를 넘기면 자바와 마찬가지로 StringIndexOutOfBoundsException예외가 발생한다.
    val s = "Hello! "
    println(s[0]) // H
    println(s[1]) // e
    println(s[5]) // !
//    println(s[10]) // 잘못된 인덱스

    // 두 문자 연결

    // + 연산자로 두 문자를 연결할 수 있다.
    val sum = "12"
    val str = "the sum is : " + sum // "The sum is $sum" 으로 대체 가능

    // 두 문자열 비교

    // 문자열은 ==와 !=를 사용해서 동등성을 비교할 수 있다.
    // 이들 연산은 문자열의 내용을 비교하므로 문자의 순서과 길이가 같으면
    // 다른 객체의 인스턴스를 같은 문자열로 간주한다.
    val s1 = "Hello!"
    val s2 = "Hel" + "lo!";

    println(s1==s2) // true

    // 참조동등성을 비교하려면 ===와 !== 연산자를 사용하면 된다.
    // 문자열은 사전식 순서로 정렬되므로 <, >, <=, >= 같은 연산자를 비교할 수 있다.
    println("abc" < "cba") // true
    println("123" > "34")  // false
}