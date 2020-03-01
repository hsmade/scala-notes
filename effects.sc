import scala.util.{Failure, Success, Try}

// options
def yes_?(flag: Boolean): Option[String] =  if (flag) Some("yes") else None
val maybe = yes_?(false)
val definitely = maybe getOrElse "no"
val isit: Option[Boolean] = None orElse Some(true)

val opt1: Option[Int] = Some(1)
val opt1: Option[Int] = None

// Try
val try1: Try[Int] = Success(1)
val try2: Try[Int] = Failure(new Exception("failed"))
try1 match {
  case Success(_) => true
  case Failure(e) => e
}

// Either - result: Left || Right. Left is always the error state
val ofof: Either[Exception, Int] = Left(new Exception("failed"))

// for comprehension
for {
  val1 <- List(1) // needs to implement map, filter, flatten
  val2 <- {print("bla"); List(val1) }
} yield val2

// pattern matching
case class Ding3(iets: Int, ietsanders: String)
val ding2 = new Ding3(1, "bla")
ding2 match {
  case Ding3(3, "view") => print("die")
  case Ding3(x, "bloep") => print(x)
  case y @ Ding3(7, "bliep") => print(y.iets)
  case _ => print("geen idee")
}
