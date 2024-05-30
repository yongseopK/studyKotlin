package chap01

fun main() {

    // 배열 정의, arrayOf()

    // 배열 구조를 구현하는 코틀린 타입은 Array다.
    // T는 원소의 타입을 뜻한다.
    // 배열 크기를 미리 안다면 표준함수중 하나를 사용해 배열을 생성할 수 있다.
    val a = emptyArray<String>()    // Array<String> (원소 0개)
    val b = arrayOf("Hello", "World")   // Array<String> (원소 2개)
    val c = arrayOf(1, 4, 9)    // Array<Int> (원소 3개)

    /*
        각 함수는 제네릭(Generic)하다. 즉 호출 시 원소타입을 지정해야 한다.
        타입 추론으로 b, c는 호출의 타입을 인자들의 타입에서 알 수 있다.
        a는 컴파일러가 타입을 추론할 단서가 없으므로 <> 사이에 원소 타입을 명시해야함
     */

    // 람다식과 Array()

    // 사용자가 입력한 값에 이르는 정수의 제곱으로 이뤄진 배열을 만든다.
    val size = readLine()!!.toInt();
    val squares = Array(size) { (it + 1) * (it + 1) }

    /*
        - 중괄호 안에 들어있는 언어 요소를 람다라고 부른다.
        - 람다는 인덱스(size)를 기반으로 값을 계산하는 식을 정의한다.
        - 인덱스를 표현하는 변수로 자동으로 선언되는 it를 사용한다.
        - 배열 인덱스는 0부터 (배열크기 -1)로 이 배열에는 1, 4, 9...의 값이 들어간다.
     */

    // 박싱타입(boxing type), 원시타입(primitive type)

    /*
        Array는 개별 원소값을 지정할 수 없다. 대신 앞서처럼 람다식을 활용할 수 있다.
        개별 원소를 지정하기 위해 ByteArray, ShortArray, LongArray, FloatArray,
        DoubleArray, CharArray, BooleanArray 라는 특화된 배열 타입을 제공한다.
        이런 특화된 배열에도 arrayOf()나 Array()에 해당하는 함수가 함께 따라온다.
     */

    val operations = charArrayOf('+', '-', '*', '/', '%')
    val squares1 = IntArray(10) { (it + 1) * (it + 1) }

    // 자바와 달리 코틀린에는 new 연산자가 없기 때문에 배열 인스턴스 생성이
    // 일반 함수 호출처럼 보인다.

    /*
        배열 타입

        배열 타입은 문자열 타입과 꽤 비슷하다.
        size와 lastIndex 프로퍼티가 있고, 점과 인덱스 연산으로 접근하는 점이 비슷하다.
        잘못된 인덱스를 사용하면 런타임에 IndexOutBoundsException이 발생한다.
     */

    val squares2 = arrayOf(1, 4, 9, 16)
    squares2.size // 4
    squares2.lastIndex // 3
    squares2[3] // 16
    squares2[1] // 4

    /*
        배열 원소 변경

        문자열과 달리 배열에서는 원소를 변경할 수 있다.
     */
    squares2[2] = 100   // squares2 : 1, 4, 100, 16
    squares2[3] += 9    // squares2 : 1. 4, 100, 25
    squares2[0]--       // squares2 : 0, 4, 100, 25

    /*
        참조형 데이터

        자바처럼 배열 타입의 변수 자체에는 실제 데이터에 대한 참조를 저장한다.
        이로인해 배열 변수에 다른 배열을 대입하면 같은 데이터 집합을 공유한다.
     */

    val numbers = squares2
    numbers[0] = 1000       // 바뀐 데이터가 squares2와 numbers에 공유됨
    println(squares2[0])    // 1000

    /*
        배열 복제

        원본과 별도의 배열을 만들고 싶다면 copyOf() 함수를 사용해야 한다.
        copyOf()는 필요시 다른 크기의 배열을 만들어 내기도 한다.
     */

    val numbers1 = squares2.copyOf()
    numbers1[0] = 1000  // squares2에는 영향이 없다.
    squares2.copyOf(2) // 뒤가 잘림 1, 4
    squares2.copyOf(5) // 부족한 부분에 0이 채워짐 1, 4, 9, 16, 0

    /*
        다른 타입의 배열은 대입이 안된다.

        배열 타입 변수에 타입이 다른 배열을 대입할 수 없다.
     */

    var a1 = arrayOf(1, 4, 9, 16)
    // a1 = arrayOf("one", "two") Error

    // 자바는 상위 타입의 배열에서 하위 타입 배열을 대입할 수 있었다.
    // 배열이 가변 데이터 구조이므로 이런 대입은 런타임시 문제가 될 수 있다.

    // Object[] objects = new String[] { "one", "two", "three" };
    // objects[0] = new Object() ; // ArrayStoreException 예외 발생

    // 위 이유로 코틀린은 다른 배열 타입과 대입을 금지한다.
    // 코틀린에서 String은 Any의 하위 타입이지만 Array는 Array의 하위 타입이 아니다.


    // 변성(variance)
    val strings = arrayOf("one", "two", "three")
    // val objects: Array<Any> = strings 예외


    /*
        배열 원소 추가

        배열을 생성하면 길이를 바꿀 수 없지만,
        + 연산자로 원소를 추가한 새로운 배열을 만들 수 있다.
     */

    val d = intArrayOf(1, 2, 3) + 4 // 원소를 하나만 추가 : 1, 2, 3, 4
    val e = intArrayOf(1, 2, 3) + intArrayOf(5, 6)  // 다른 배열을 추가 : 1, 2, 3, 4, 5, 6


    /*
        배열 비교

        문자열과 달리 배열에 대한 ==, != 연산자는 원소자체를 비교하지 않고 참조를 비교한다.
     */
    intArrayOf(1, 2, 3) == intArrayOf(1, 2, 3) // true


    /*
        배열 표준 함수

        isEmpty         배열이 비었는지 검사                                 intArrayOf(1, 2).isEmpty()      false
        isNotEmpty      배열에 원소가 있는지 검사                            intArrayOf(1, 2).isNotEmpty()   true
        indexOf         인자와 일치하는 최초의 배열 아이템의 인덱스를 반환   intArrayOf(1, 2, 3).indexOf(2)  1
     */
}