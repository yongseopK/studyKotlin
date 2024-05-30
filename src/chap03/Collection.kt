package chap03

// 컬렉션 (Collection)

/*
    1. List
        - List는 순서가 있는 요소의 모음, 중복 요소를 허용함
        - 불변 리스트는 listOf()를 사용하여 생성할 수 있음
        - 가변 리스트는 mutableListOf()를 사용하여 생성할 수 있음
        - List는 인덱스를 사용하여 요소에 접근할 수 있음
 */
val numbers = listOf(1, 2, 3, 4, 5)
val firstNumber = numbers[0]
val lastNumber = numbers.last()

val mutableNumbers = mutableListOf(1, 2, 3)

/*
    2. Map

    - Map은 키-값 쌍의 모음입니다. 키는 고유해야 하며, 각 키는 하나의 값과 매핑됨
    - 불변 맵은 mapOf()를 사용하여 생성할 수 있음
    - 가변 맵은 mutableMaoOf()를 사용하여 생성할 수 있음
    - Map은 키를 사용하여 값에 접근할 수 있음
 */
val nameAgeMap = mapOf("Alice" to 25, "Bob" to 30)
val aliceAge = nameAgeMap["Alice"]

val mutableMap = mutableMapOf("Alice" to 25, "Bob" to 30)


/*
    3. 컬렉션 연산

    - 코틀린은 컬렉션에 대해 다양한 연산을 제공함
    - filter : 주어진 조건에 맞는 요소만 선택하여 새로운 컬렉션을 생성함
    - reduce : 컬렉션의 요소를 누적 연산하여 단일 값으로 합침
    - sorted : 컬렉션을 정렬하여 새로운 컬렉션을 생성함
    - groupBy : 주어진 키 선택 함수에 따라 요소를 그룹화하여 Map을 생성함
 */

val numbers1 = listOf(1, 2, 3, 4, 5)
val evenNumbers = numbers1.filter { it % 2 == 0 }
val doubleNumbers = numbers1.map { it * 2 }
val sum = numbers1.reduce { acc, num -> acc + num }
val sortedNumbers = numbers1.sorted()
val groupedNumbers = numbers1.groupBy { if (it % 2 == 0) "even" else "odd" }


/*
    지연 컬렉션 연산

    - 코틀린은 지연 컬렉션 연산을 지원함, 지연 연산은 실제로 필요한
      시점까지 연산을 미루고, 중간 결과를 저장하지 않음
    - 지연 컬렉션 연산은 Sequence를 사용하여 수행됨
    - 대량의 데이터를 처리할 때 지연 연산을 사용하면 메모리 사용량을 줄일 수 있음
 */
val numbers2 = (1..100000).toList()
val evenNumbers1 = numbers2.asSequence()
    .filter { it % 2 == 0 } // 조건
    .map { it * 2 }         // 연산
    .take(5)             // 처음부터 매개변수까지 선택
    .toList()               // 리스트에 저장


/*
    컬렉션 확장 함수

    - 코틀린은 컬렉션에 대한 다양한 확장 함수를 제공함
    - any : 컬렉션에서 주어진 조건을 만족하는 요소가 하나라도 있는지 확인
    - all : 컬렉션의 모든 요소가 주어진 조건을 만족하는지 확인
    - none : 컬렉션에서 주어진 조건을 만족하는 요소가 하나도 없는지 확인
    - find : 주어진 조건을 만족하는 첫 번째 요소를 반환함
    - first, last : 컬렉션의 첫 번째 요소와 마지막 요소를 반환함
    - count : 컬렉션의 요소 개수를 반환함
 */
val numbers3 = listOf(1, 2, 3, 4, 5)
val hasEvenNumber = numbers3.any { it % 2 == 0 }
val allEvenNumbers = numbers3.all { it % 2 == 0 }
val noNegativeNumbers = numbers3.none { it < 0 }
val firstEvenNumber = numbers3.find { it % 2 == 0 }
val lastEvenNumber = numbers3.last()
val count = numbers3.count()

fun main() {

    // List
    mutableNumbers.add(4)
    mutableNumbers.remove(2)

    println("numbers = $numbers")
    println("firstNumber = $firstNumber")
    println("lastNumber = $lastNumber")
    println("mutableNumbers = $mutableNumbers")

    println("\n===========================\n")

    // Map
    mutableMap["charlie"] = 35
    mutableMap.remove("Bob")

    println("nameAgeMap = $nameAgeMap")
    println("mutableMap = $mutableMap")

    println("\n===========================\n")

    // 컬렉션 연산
    println("evenNumbers = $evenNumbers")
    println("doubleNumbers = $doubleNumbers")
    println("sum = $sum")
    println("sortedNumbers = $sortedNumbers")
    println("groupedNumbers = $groupedNumbers")

    println("\n===========================\n")

    // 지연 컬렉션 연산
    println("evenNumbers1 = $evenNumbers1")

    println("\n===========================\n")

    // 컬렉션 확장 함수
    println("hasEvenNumber = $hasEvenNumber")
    println("allEvenNumbers = $allEvenNumbers")
    println("noNegativeNumbers = $noNegativeNumbers")
    println("firstEvenNumber = $firstEvenNumber")
    println("lastEvenNumber = $lastEvenNumber")
    println("count = $count")
}