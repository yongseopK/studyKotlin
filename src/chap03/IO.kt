package chap03

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable

/*
    파일 읽기

    - java.io.File 클래스를 사용하여 파일을 읽을 수 있음
    - readText() 확장 함수를 사용하여 파일의 내용을 문자열로 읽을 수 있음
    - readLines() 확장 함수를 사용하여 파일의 내용을 라인 단위로
      읽어 리스트로 반환할 수 있음
    - useLines() 확장 함수를 사용하여 파일의 라인을 시퀀스로 읽을 수 있음
 */
val inputFile = File("src/chap03/input.txt")
val content = inputFile.readText()
val lines = inputFile.readLines()


/*
    파일 쓰기

    - java.io.File 클래스를 사용하여 파일에 쓸 수 있음
    - writeText() 확장 함수를 사용하여 문자열을 파일에 쓸 수 있음
    - appendText() 확장 함수를 사용하여 문자열을 파일에 추가할 수 있음
    - bufferedWriter() 확장 함수를 사용하여 버퍼를 사용하여 효율적으로 파일에 쓸 수 있음
 */
val outputFile = File("src/chap03/output.txt")


/*
    파일 및 디렉토리 조작

    - java.io.File 클래스를 사용하여 파일 및 디렉토리를 조작할 수 있음
    - exists() 함수를 사용하여 파일이나 디렉토리의 존재 여부를 확인할 수 있음
    - mkdir() 함수를 사용하여 디렉토리를 생성할 수 있음
    - delete() 함수를 사용하여 파일이나 디렉토리를 삭제할 수 있음
 */
val newFile = File("example.txt")


/*
    리소스 자동 닫기

    - use 함수를 사용하여 리소스를 자동으로 닫을 수 있음
    - use 함수는 람다식 내에서 리소스를 사용하고,
      람다식이 종료되면 자동으로 리소스를 닫음
    - Reader, Writer, InputStream, OutputStream 등의
      리소스를 use 함수와 함께 사용할 수 있음
 */
val reader = File("src/chap03/input.txt").bufferedReader()


/*
    표준 입력과 출력

    - readLine() 함수를 사용하여 표준 입력에서 한 줄을 읽을 수 있음
    - print(), println() 함수를 사용하여 표준 출력으로 텍스트를 출력할 수 있음
 */


/*
    직렬화와 역직렬화

    - 코틀린에서는 객체의 직렬화와 역직렬화를 지원함
    - Serializable 인터페이스를 구현하는 클래스는 직렬화할 수 있음
    - ObjectOutputStream과 ObjectInputStream을
      사용하여 객체를 직렬화하고 역직렬화 할 수 있음
 */

data class Person2(val name: String, val age: Int) : Serializable

val person = Person2("Alice", 25)



fun main() {

    // 파일 읽기
    println("content = $content")
    println("lines = $lines")
    inputFile.useLines { lines -> lines.forEach { println("it = $it")} }

    println("\n================================\n")

    // 파일 쓰기
    outputFile.writeText("Hello, World!")
    outputFile.appendText("\nAppended text")
    outputFile.bufferedWriter().use { writer ->
        writer.write("Line 1\n")
        writer.write("Line 2\n")
    }

    println("\n================================\n")

    // 파일 및 디렉토리 조작
    if(newFile.exists()) {
        println("File exists")
    } else {
        println("File dose not exist")
    }

    val directory = File("newDirectory")
    directory.mkdir()

    newFile.delete()
    directory.delete()

    println("\n================================\n")

    // 리소스 자동 닫기
    reader.use { reader ->
        val content = reader.readText()
        println("content = $content")
    }

    println("\n================================\n")

    // 표준 입력과 출력
    print("Enter your name: ")
    val name = readLine()
    println("Hello, $name!")

    println("\n================================\n")

    //직렬화와 역직렬화

    // 직렬화
    val outputStream = ObjectOutputStream(FileOutputStream("person.dat"))
    outputStream.writeObject(person)
    outputStream.close()

    // 역직렬화
    val inputStream = ObjectInputStream(FileInputStream("person.dat"))
    val deserializedPerson = inputStream.readObject() as Person2
    inputStream.close()

    println(deserializedPerson)

}