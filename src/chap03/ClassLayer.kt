package chap03

/*
    기본 클래스 (Base Class)

    - 다른 클래스의 상위 클래스가 되는 클래스임
    - 기본 클래스는 open 키워드를 사용하여 상속 가능하도록 선언함
    - 기본 클래스는 자식 클래스에 의해 상속되어 확장될 수 있음
 */
open class Animal(val name: String) {
    open fun makeSound() {
        println("The animal makes a sound")
    }
}


/*
    파생 클래스 (Derived Class)

    - 기본 클래스를 상속받는 클래스임
    - 파생 클래스는 기본 클래스의 속성과 메서드를 상속받고,
      추가적인 기능을 구현할 수 있음
    - 파생 클래스는 기본 클래스의 open 멤버를 override 키워드를
      서용하여 재정의할 수 있음
 */
class Dog(name: String) : Animal(name) {
    override fun makeSound() {
        println("The dog barks")
    }
}


/*
    추상 클래스 (Abstract Class)

    - 추상 메서드를 포함하는 클래스임
    - 추상 클래스는 abstract 키워드를 사용하여 선언함
    - 추상 클래스는 직접 인스턴스화 할 수 없으며,
      다른 클래스에 의해 상속되어야 함
    - 추상 클래스의 추상 메서드는 파생 클래스에서 구현해야 함
 */

abstract class Shape {
    abstract fun calculateArea(): Double
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun calculateArea(): Double {
        return width * height
    }
}


/*
    인터페이스 (interface)

    - 추상 메서드와 프로퍼티의 집합을 정의하는 타입임
    - 인터페이스는 interface 키워드를 사용하여 선언함
    - 클래스는 하나 이상의 인터페이스를 구현할 수 있음
    - 인터페이스의 메서드는 기본적으로 추상 메서드이며,
      구현 클래스에서 구현해야 함
 */
interface Drawable {
    fun draw()
}

class Circle(val radius: Double) : Shape(), Drawable {
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }

    override fun draw() {
        println("Drawing a circle")
    }
}


/*
    다중 상속

    - 코틀린에서는 클래스 간의 다중 상속을 지원하지 않음
    - 대신 인터페이스를 사용하여 다중 상속과 유사한 효과를 얻을 수 있음
    - 클래스는 여러 인터페이스를 구현할 수 있으며,
      인터페이스 간의 메서드 충돌은 구현 클래스에서 해결해야 함
 */
interface Flyable {
    fun fly()
}

class Bird(name: String) : Animal(name), Flyable {
    override fun fly() {
        println("The bird is flying")
    }

}