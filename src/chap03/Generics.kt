package chap03

import chap02.User

/*
    코틀린의 제네릭은 클래스, 함수, 인터페이스 등에서 타입을
    파라미터화하여 재사용성과 타입 안정성을 제공하는 기능임.
    제네릭을 사용하면 코드 중복을 줄이고 타입 안전성을 높일 수 있음
 */

/*
    1. 제네릭 클래스

    - 클래스 정의 시 타입 파라미터를 사용하여 제네릭 클래스르 만들 수 있음
    - 타입 파라미터는 클래스 이름 뒤에 <T>와 같이 지정함
    - 타입 파라미터는 클래스 내부에서 타입으로 사용됨
 */
class Box<T>(private var value: T) {
    fun getValue(): T = value
    fun setValue(newValue: T) {
        value = newValue
    }
}

val intBox = Box<Int>(10)
val StringBox = Box<String>("Hello")


/*
    제네릭 함수

    - 함수 정의 시 타입 파라미터를 사용하여 제네릭 함수를 만들 수 있음
    - 타입 파라미터는 함수 이름 앞에 <T>와 같이 지정함
    - 타입 파라미터는 함수의 매개변수나 반환 타입으로 사용됨
 */
fun <T> printValue(value: T) {
    println(value)
}


/*
    제네릭 인터페이스

    - 인터페이스 정의 시 타입 파라미터를 사용하여 제네릭 인터페이스를 만들 수 있음
    - 타입 파라미터는 인터페이스 이름 뒤에 <T>와 같이 지정함
    - 제네릭 인터페이스를 구현하는 클래스에서 타입 파라미터를 지정해야함
 */
interface Repository<T> {
    fun getById(id: Int): T
    fun save(entity: T)
}

class UserRepository : Repository<User> {
    override fun getById(id: Int): User {
        TODO("Not yet implemented")
    }

    override fun save(entity: User) {
        TODO("Not yet implemented")
    }
}


/*
    타입 파라미터 제약

    - 타입 파라미터에 제약을 추가하여 특정 타입만 사용할 수 있도록 제한할 수 있음
    - 타입 파라미터 뒤에 : 제약조건 을 추가하여 제약을 지정함
    - 제약 조건으로는 클래스, 인터페이스, Any, Nothing 등이 사용될 수 있음
 */
fun <T : Comparable<T>> sort(list: List<T>): List<T> {
    return list.sorted()
}


/*
    변성 (Variance)

    - 제네릭 타입의 하위 타입 관계를 지정하는 기능임
    - 코틀린에서는 공변성(Covariance)과 반공변성(Contravariance)을 지원함
    - 공변성은 out 키워드를 사용하여 지정하며, 반공변성은 in 키워드를 사용하여 지정함
 */
abstract class Animal1
class Cat : Animal1()
class Mouse : Animal1()

class Cage<out T : Animal1>(val animal1: T)

val catCage: Cage<Cat> = Cage(Cat())
val animalCage: Cage<Animal1> = catCage


/*
    스타 프로젝션 (Star Projection)

    - 제네릭 타입 파라미터를 * 로 대체하여 해당 타입의 상한 경계를
      지정하는 기능임
    - 스타 프로젝션을 사용하면 제네릭 타입의 상세 타입 정보를 제거하고
      안전하게 사용할 수 있음
 */

fun printValues(list: List<*>) {
    for(value in list) {
        println(value)
    }
}

fun main() {

    // 제네릭 클래스
    println("intBox = $intBox")
    println("StringBox = $StringBox")

    println("\n===============================\n")

    // 제네릭 함수
    printValue<Int>(10)
    printValue<String>("Hello")

    println("\n===============================\n")

    // 타입 파라미터 제약
    val numbers = listOf(3, 1, 4, 2)
    println(sort(numbers))

    println("\n===============================\n")

    // 스타 프로젝션
    val numbers1 = listOf(1, 2, 3)
    val strings = listOf("A", "B", "C")
    printValues(numbers1)
    printValues(strings)
}