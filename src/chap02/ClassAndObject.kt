package chap02

import java.sql.Connection
import java.sql.DriverManager

/*
    클래스 정의

    - 코틀린에서 클래스는 class 키워드를 사용하여 정의함
    - 클래스는 프로퍼티(속성)와 메서드(함수)를 가질 수 있음
    - 클래스의 생성자는 클래스 헤더에 정의하며, 주 생성자와 부 생성자를 가질 수 있음
 */
class Person(val name: String, var age: Int) {
    fun introduce() {
        println("My name is $name and I am $age years old.")
    }
}

/*
    객체 생성

    - 클래스의 인스턴스(객체)는 생성자를 호출하여 생성함
    - 코틀린에서는 new 키워드를 사용하지 않고 클래스 이름뒤에 괄호를 붙혀 객체를 생성
 */
val person = Person("Seop", 24)

/*
    프로퍼티

    - 코틀린의 클래스는 프로퍼티를 가질 수 있음
    - 프로퍼티는 var(가변) 또는 val(불변)로 선언할 수 있음
    - 프로퍼티는 getter와 setter를 자동으로 생성하며, 사용자 정의
      getter와 setter를 정의할 수도 있음
 */

class Rectangle(/* 이거 */var width: Double, /* 이거 */var height: Double) {
    val area: Double
        get() = width * height
}

/*
    데이터 클래스

    - 데이터를 저장하는 클래스를 간단히 정의할 수 있는 기능
    - data class 키워드를 사용하여 정의함
    - 데이터 클래스는 equals(), hashCode(), toString() 등의 메서드를 자동으로 생성함

    스프링으로 웹을 구현한다는 가정하에 DTO클래스를 생성할때 사용함
 */
data class User(val id: Int, val name: String, val email: String)

/*
    Object 키워드

    - 코틀린에서는 object 키워드를 사용하여 싱글턴 객체를 쉽게 생성할 수 있음
    - object 키워드로 선언된 객체는 애플리케이션 전체에서 하나의 인스턴스만 존재함
 */

// 데이터베이스 연동 예시 코드

object Database {
    private var connection: Connection? = null
    private const val URL = "jdbc:mysql://localhost:3306/database"
    private const val USERNAME = "username"
    private const val PASSWORD = "password"

    fun connect() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)
                println("데이터베이스 연결 성공")
            } catch (e: Exception) {
                e.printStackTrace()
                println("데이터베이스 연결 실패")
            }
        } else {
            println("이미 데이터베이스에 연결되어 있습니다.")
        }
    }

    fun disconnect() {
        if (connection != null) {
            try {
                connection?.close()
                connection = null
                println("데이터베이스 연결 해제 성공")
            } catch (e: Exception) {
                e.printStackTrace()
                println("데이터베이스 연결 해제 실패")
            }
        } else {
            println("데이터베이스에 연결되어 있지 않습니다.")
        }
    }

    fun getConnection(): Connection? {
        return connection
    }
}

/*
    컴패니언 객체

    - 클래스 내부에 companion object를 선언하여 클래스 레벨의 메서드와 프로퍼티를 정의할 수 있음
    - 컴패니언 객체의 멤버는 클래스 이름을 통해 직접 접근할 수 있음
 */
class MyClass {
    companion object {
        fun create(): MyClass {
            return MyClass()
        }
    }
}

val instance = MyClass.create()


fun main() {
    person.introduce()
}
