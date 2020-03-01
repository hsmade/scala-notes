import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

// Futures
implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
val f = Future{Thread.sleep(1000); "ok"}
//f.onComplete(x => println(s"result: ${x.getOrElse("bork")}"))(ExecutionContext.global)

// combining futures with for comprehension
val result = for {
  value <- f
  value2 <- f
} yield value + value2

// force wait for result
val finalResult = Await.result(result, 10.second)
