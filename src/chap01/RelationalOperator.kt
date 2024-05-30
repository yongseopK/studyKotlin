package chap01

fun main() {

    /*
        비교연산자

        == : 같다
        != : 같지 않다
        < : ~ 보다 작다
        <= : ~ 보다 작거나 같다
        > : ~ 보다 크다
        >= : ~ 보다 크거나 같다.
     */

    // 두 인자가 모두 같은 타입일때만 ==와 !=를 허용한다.

    val a = 1  // Int
    val b = 2L // Long
    // println(a == b) Error
    println(a.toLong() == b) // Ok

    /*
        코틀린 타입은 두 인자가 모두 같은 타입일때만 ==와 !=를 허용한다.
        한 인자는 Int이고, 한 인자는 Long이면 ==를 적용할 수 없다.

        하지만 모든 수 타입의 값은 서로 <, <=, >, >= 를 사용해 비교할 수 있다.
        이는 수 타입 사이 산술연산이 가능한 모든 경우를 다룰 수 있도록 오버로딩 된 것과 마찬가지 이다.
        따라서 아래와 같은 코드가 가능하다.
     */
    1 <= 2L || 3 > 4.5

    // Char, Boolean값도 비교연산 지원

    // Char, Boolean값도 비교연산을 지원한다. 하지만 같은 타입의 값만 비교할 수 있다
    false == true // false
    false < true // true
    // false > 1 Error
    'a' < 'b' // true
    // 'a' > 0 Error

    /*
        부동수수점의 NaN값 비교

        부동소주점은 NaN값을 특별취급한다.
        기본적으로 NaN은 그 어떤 값과도 같지않다.
        특히 다른 NaN과도 같지 않고, 무한대를 포함한 다른 어떤 값보다 작지도 않고, 크지도 않다.
        이런 규칙은 컴파일러가 부동 소수점 타입이라는 사실을 알때만 적용한다.
     */

    println(Double.NaN == Double.NaN)   // false
    println(Double.NaN != Double.NaN)   // true
    println(Double.NaN <= Double.NaN)   // false
    println(Double.NaN < Double.POSITIVE_INFINITY)  // false
    println(Double.NaN > Double.NEGATIVE_INFINITY)  // false

}