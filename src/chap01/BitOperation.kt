package chap01

fun main() {

    var a: Int = 1;
    var b: Int = 1;

    // AND 연산자 : 두 비트 모두 1인 경우에만 결과가 1이 됨
    val and = a and b

    // OR 연산자 : 두 비트중 하나라도 1이면 결과가 1이 됨
    val or = a or b

    // XOR 연산자 : 두 비트가 서로 다른 경우에만 결과가 1이 됨
    val xor = a xor b

    // 왼쪽 쉬프트 연산자 : 지정한 수만큼 왼쪽으로 이동시킴
    val shl = a shl b

    // 오른쪽 쉬프트 연산자 : 지정한 수만큼 오른쪽으로 이동시킴
    val shr = a shr b

    // 반전 연산자
    val inv = a.inv()

}