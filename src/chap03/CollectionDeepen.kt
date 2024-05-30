package chap03

import chap02.Person

/*
    컬렉션 파티셔닝 그룹화

    - partition 함수를 사용하여 컬렉션을 조건에 따라 두 개의 컬렉션으로
      분할할 수 있음
    - groupBy 함수를 사용하여 컬렉션을 특정 키에 따라 그룹화할 수 있음
 */
val numbers4 = listOf(1, 2, 3, 4, 5, 6)

val people = listOf(
    Person("Alice", 25),
    Person("Bob", 30),
    Person("Charlie", 25),
    Person("David", 35)
)

val peopleByAge = people.groupBy { it.age }


/*
    컬렉션 플랫닝

    - flatMap 함수를 사용하여 컬렉션의 각 요소를 다른 컬렉션으로 매핑하고,
      결과를 단일 컬렉션으로 평탄화할 수 있음
 */
val nestedList = listOf(
    listOf(1, 2, 3),
    listOf(4, 5, 6),
    listOf(7, 8, 9)
)

val flattenedList = nestedList.flatten()


/*
    컬렉션 동작 재정의

    - 컬렉션의 동작을 재정의하여 사용자 정의 동작을 구현할 수 있음
    - MutableList의 add, remove, clear등의 함수를 오버라이드하여 동작을 변경할 수 있음
 */
class CustomList<T> : ArrayList<T>() {
    override fun add(element: T): Boolean {
        println("Adding element : $element")
        return super.add(element)
    }

    override fun remove(element: T): Boolean {
        println("Removing element : $element")
        return super.remove(element)
    }
}


/*
    컬렉션 확장 함수 직접 작성

    - 코틀린에서는 기존 컬렉션 클래스에 대한 확장 함수를 직접 작성할 수 있음
    - 확장 함수를 사용하여 컬렉션에 사용자 정의 기능을 추가할 수 있음
 */
fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T>{
    val result = mutableListOf<T>()
    for (item in this) {
        if(predicate(item)) {
            result.add(item)
        }
    }
    return result
}


/*
    컬렉션과 Null 안전성

    - 코틀린의 컬렉션은 Null안전성을 고려하여 설계되었음
    - 컬렉션 타입 뒤에 ?를 붙이면 Nullable 컬렉션이 되며, Null 값을 저장할 수 있음
    - Nullable 컬렉션에 대해서는 안전한 호출(?.)이나
      Null 검사(?:)를 사용하여 Null 값을 처리할 수 있음
 */
val nullableList: List<Int?> = listOf(1, 2, null, 4)
val filteredList = nullableList.filterNotNull()

val nullableMap: Map<String, Int?> = mapOf("A" to 1, "B" to null)
val value = nullableMap?.get("B") ?: 0

fun main() {

    //컬렉션 파티셔닝 그룹화
    val (evenNumbers, oddNumbers) = numbers4.partition { it % 2 == 0 }
    println("evenNumbers = $evenNumbers")
    println("oddNumbers = $oddNumbers")
    println("peopleByAge = $peopleByAge")

    println("\n=======================\n")

    // 컬렉션 플랫닝
    println(flattenedList)

    println("\n=======================\n")

    // 컬렉션 동작 재정의
    val list = CustomList<Int>()
    list.add(1)
    list.add(2)
    list.remove(1)

    println("list = $list")

    println("\n=======================\n")

    // 컬렉션 확장 함수 직접 작성
    val numbers = listOf(1, 2, 3, 4, 5)
    val evenNumbers1 = numbers.customFilter { it % 2 == 0 }
    println("evenNumbers1 = $evenNumbers1")

    println("\n=======================\n")

    // 컬렉션과 Null 안전성
    println("filteredList = $filteredList")
    println("value = $value")
}
