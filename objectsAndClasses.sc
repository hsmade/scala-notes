// objects
object Choice {
  def yes = true
  def no = false
}

// classes
class Ding1 (val x: Int) {
  def quack() = "boo" // public method
  private val y = 1
  var z = 5 // becomes public property like x
}

// use multiple constructors
class Ding2(val x: Int) {
  def this(x: Float) = {
    this(x.toInt)
  }
}

// use object for multiple constructors
class Ding3 (val y: Any)
object Ding3 {
  def apply(y: Int): Ding3 = new Ding3(y)
  def apply(z: String): Option[Ding3] = {
    try {
      Some(Ding3(z.toInt))
    } catch {
      case _: Throwable ⇒ None
    }
  }
}
Ding3("a").getOrElse(Ding3(3)).y

// extend class + override
class Ding4 (z: Int) extends Ding1(z) {
  override def quack(): String = "bloep"
}

// case class, gets some default methods (eq, equals, constructors) and sugar
case class Book(isbn: Int)
val book = Book(1).isbn

// extending / interfaces
// https://www.geeksforgeeks.org/difference-between-traits-and-abstract-classes-in-scala/
// traits
trait Color { val color: String }
trait Height { val height: Int = 7}
class Ding4(val color: String) extends Ding1(1) with Color
val ding = new Ding4("green") with Height

// abstract class
abstract class AbDing1 {
  def abstractMethod() // defines abstract interface
  def Method() {} // defines abstract interface
}

sealed abstract class AbDing2 // can only be extended upon in the same file

class Test extends AbDing1 with Color with Height { // multiple traits allowed, just one extends
  override def abstractMethod(): Unit = {}
  override val color = ""
}

// implicits
// add method to final class
implicit class StringOps(s: String) {
  def isBlank: Boolean = Option(s).fold(true)(_.trim.isEmpty)
}
"hello".isBlank

// implicit parameter
class Ding5
class Foo(val i: Int)(implicit var ctx: Ding5)
implicit val bla: Ding5 = new Ding5
val foo = new Foo(1) // note missing param for ctx
