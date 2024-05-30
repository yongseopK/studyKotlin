package chap02

/*
    클래스 위임을 사용한 데코레이터 패턴 구현

    - 클래스 위임을 사용하여 데코레이터 패턴을 간단하게 구현할 수 있음
    - 데코레이터 패턴은 객체에 추가적인 책임을 동적으로 부여하는 패턴임
    - 클래스 위임을 통해 기존 객체를 감싸는 래퍼 클래스를 만들어 기능을 확장할 수 있음
 */
interface Coffee {
    fun getCost(): Double
    fun getDescription(): String
}

class SimpleCoffee: Coffee{
    override fun getCost() = 1.0
    override fun getDescription() = "Simple coffee"
}

class MilkCoffee(private val coffee: Coffee) : Coffee by coffee {
    override fun getCost() = coffee.getCost() + 0.5
    override fun getDescription() = "${coffee.getDescription()}, milk"
}

class WhipCoffee(private val coffee: Coffee) : Coffee by coffee {
    override fun getCost() = coffee.getCost() + 0.7
    override fun getDescription() = "${coffee.getDescription()}, whip"
}


/*
    클래스 위임을 사용한 컴포지션 패턴 구현

    - 클래스 위임을 사용하여 컴포지션 패턴을 간단하게 구현할 수 있음
    - 컴포지션 패턴은 객체를 구성하는 방식으로 재사용성을 높이는 패턴임
    - 클래스 위임을 통해 다른 객체의 메서드를 호출하여 기능을 조합할 수 있음
 */
interface Engine {
    fun start()
    fun stop()
}

class ElectricEngine : Engine {
    override fun start() {
        println("Electric engine started")
    }
    override fun stop() {
        println("Electric engine stopped")
    }
}

class Car(private val engine: Engine) : Engine by engine {
    fun drive() {
        engine.start()
        println("Car is driving")
        engine.stop()
    }
}


/*
    동반 객체를 사용한 팩토리 메서드 패턴 구현

    - 동반 객체를 사용하여 팩토리 메서드 패턴을 구현할 수 있음
    - 팩토리 메서드 패턴은 객체 생성 로직을 캡슐화하여 유연성과 확장성을 제공하는 패턴임
    - 동반 객체에 팩토리 메서드를 정의하여 객체 생성을 간소화할 수 있음
 */
interface Shape {
    fun draw()
}

class Rectangle1 : Shape {
    override fun draw() {
        println("Drawing a rectangle")
    }

    companion object {
        fun create() = Rectangle1()
    }
}

class Circle : Shape {
    override fun draw() {
        println("Drawing a circle")
    }

    companion object {
        fun create() = Circle()
    }
}


/*
    실드 클래스를 사용한 불변 데이터 구조 구현

    - 실드 클래스를 사용하여 불변 데이터 구조를 구현할 수 있음
    - 실드 클래스는 계층 구조를 제한하고 패턴 매칭을 통해 안전하게 데이터를 다룰 수 있음
    - 불변 데이터 구조는 스레드 안정성과 부작용 없는 프로그래밍을 지원함
 */
sealed class Tree<out T>
data class Node<out T>(val value: T, val left: Tree<T>, val right: Tree<T>) : Tree<T>()
object Leaf : Tree<Nothing>()



fun main() {

    // 데코레이터 패턴
    val coffee = WhipCoffee(MilkCoffee(SimpleCoffee()))
    println("Cost : ${coffee.getCost()}")
    println("Description : ${coffee.getDescription()}")

    // 컴포지션 패턴
    val car = Car(ElectricEngine())
    car.drive()

    // 팩토리 메서드
    val shapes = listOf(Rectangle1.create(), Circle.create())
    shapes.forEach { it.draw() }

    // 불변 데이터 구조
    fun<T> Tree<T>.contains(element: T): Boolean = when(this) {
        is Node -> value == element || left.contains(element) || right.contains(element)
        Leaf -> false
    }

    val tree = Node(5,
        Node(3, Node(1, Leaf, Leaf), Node(4, Leaf, Leaf)),
        Node(7, Node(6, Leaf, Leaf), Node(8, Leaf, Leaf))
        )

    println(tree.contains(4)) // true
    println(tree.contains(9)) // false
}