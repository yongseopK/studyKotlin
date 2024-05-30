package chap01

fun main() {

    // 숫자 타입
    var byte: Byte = 127
    var short: Short = 32767
    var int: Int = 2147483647
    var long: Long = 999999999999999999

    // 최대값, 최소값 상수 정의
    var byteMax: Byte = Byte.MAX_VALUE
    var byteMin: Byte = Byte.MIN_VALUE

    var shortMax: Short = Short.MAX_VALUE
    var shortMin: Short = Short.MIN_VALUE
    // ...

    // 부동소수점수
    val pi = 3.14
    val one = 1.0
    val quarter = .25

    // 과학적 표기법
    val pi1 = 0.324E1 // 3.14 = 0.314 * 10
    val pi100 = 0.314E3 // 314.0 = 0.314 * 1000
    val piOver100 = 3.14E-2 // 0.0314 = 3.14 / 100
    val thousand = 1E3 // 1000.0 = 1 * 1000

    // 코틀린에서는 Double이나 Float의 16진 리터럴을 지원하지
    // 않는다. 디폴트로 부동소수점 리터럴은 Double이다.
    // f나 F를 리터럴 뒤에 붙이면 Float 타입이 된다
    val pii = 3.14f
    val one0 = 1f

    // 자바에서는 D나 d를 부동소수점 뒤에 붙혀 강제로 double 타입 변환 가능
    // 코틀린에서는 이런 접미사를 허용하지 않고, 부동소수점 디폴트는 Double이다.
    // Float 리터럴이 자동으로 Double 타입으로 변환되지 않는다.
    // val piii: Double = 3.14f X

    // Float, Double도 각 타입의 특별한 값을 표현하는 상수를 제공함
    println(Float.MIN_VALUE)                // 1.4E-45
    println(Double.MAX_VALUE)               // 1.797693134862315710308
    println(Double.POSITIVE_INFINITY)       // Infinity
    println(1.0 / Double.NEGATIVE_INFINITY) // -0.0
    println(2 - Double.POSITIVE_INFINITY)   // -Infinity
    println(3 * Float.NaN)                  // NaN

}