// definitions
var a = 1 // mutable, only evaluates when defined
val b = 1 // imutable, only evaluates when defined
lazy val c = 1 // imutable, only evaluates once, on first use
def dvar = 1 // imutable, evaluates on use

//object tree
Nil == List.empty
//None.isInstanceOf[Nothing]
AnyRef.isInstanceOf[Any]
//AnyVal // for objects, subclass of Any

// functions
def func(x: Int) { print(x) } // no return
def func(x: Int) =  x + 1 // return
def func(x: Int, y: Int = 1) =  x + y // default parameter value
// anonymous functions
val myVar: Int => Int = x => x + 1 // anonymous function
val myVar = (x: Int) => x + 1 // leave out definition, must define parameter type
val myVar: Int => Int = _ + 1 // replace x => x
// curried functions
def funcC(x: Int)(y: Int) = { x + y}
val ding = funcC(1) _
ding(2) // == 3
//variable length arguments
def func(args: Int*) {
  var total = 0
  args.foreach(x => total += x)
}

// lists
val empty: List[Int] = List.empty
//empty.head // exception
empty.headOption == None
//empty.tail // exception
empty.tails.length == 1  // WEIRD
empty.iterator.length == 0
List(List(1,2,3), List(4,5,6)).flatten == List(1, 2, 3, 4, 5, 6)

