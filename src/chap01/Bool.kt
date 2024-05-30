package chap01

fun main() {

    // 불타입과 논리 연산
    // 참(true)이나 거짓(false)중 하나로 판명되는 불(Boolean) 타입과 논리연산을 제공한다.

    val hasErrors = false;
    val testPassed = true;


    // Boolean은 수타입과 다른 타입이며, 암시적이든 toInt() 같은 명시적인
    // 내장 연산을 써서든 수로 변환할 수 없다. 반대로 수를 Boolean으로 변환할 수도 없다.

    // Boolean이 지원하는 연산
    // ! : 논리 부정
    // or, and, xor : 즉시계산 방식의 논리합, 논리곱, 논리배타합
    // ||, && : 지연 계산 방식의 논리합, 논리곱
        // 지연 계산 연산자(||, &&)는 자바의 동일 연산자와 같은 의미를 제공한다.
        // || 왼쪽 피연산자가 참이면 오른쪽 피연산자를 계산하지 않는다.
        // &&의 왼쪽 피연산자가 거짓이면 오른쪽 피연산자를 계산하지 않는다.

    // 동등성/비동등성 연산자
//    println(( x == 1 ) or ( y == 1 )) // true
//    println(( x == 0 ) || ( y == 0 )) // false
//    println(( x == 1 ) and ( y != 1 )) // true
//    println(( x == 1 ) and ( y == 1 )) // false
//    println(( x == 1 ) xor ( y == 1 )) // true
//    println(( x == 1 ) xor ( y != 1 )) // false
//    println( x == 1 || y / (x - 1) != 1) // true
//    println( x != 1 && y / (x - 1) != 1) // false
}
