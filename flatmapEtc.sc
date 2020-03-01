// map, flatten, flatmap
List(1,2).map(x => x + 1) == List(2,3)
List(1,2).map(_ + 1) == List(2,3)

List(Some(1), None).map(x => x) == List(Some(1), None)
List(Some(1), None).flatten == List(1)
List(Some(1), None).flatMap(_.map(x => x + 1)) == List(2)

List(1,2,3).filter(_ < 3) == List(1,2)

// for comprehension
for {
  val1 <- List(1) // needs to implement map, filter, flatten
  val2 <- {print("bla"); List(val1) }
} yield val2

// map + reduce
// calculate average of list. ._1 is first item in seq, ._2 is second
val res = List(1,5,6,7,3,4).map((_, 1)).reduce((a,b) => (a._1 + b._1, a._2 + b._2))
val average = res._1/res._2.toFloat

// calculate sum of list
List(1,2,3,4).reduce((a,b) => a + b) == 10
List(1,2,3,4).reduce(_ + _) == 10 // same
List(1, 2, 3, 4).sum == 10

// fold is reduce with starting value
List.empty.fold("default")((a,b) => a+b) == "default"

// scan, reduce with the steps saved
List(1,2,3,4).scan(10)((a,b) => a + b) == List(10, 11, 13, 16, 20)