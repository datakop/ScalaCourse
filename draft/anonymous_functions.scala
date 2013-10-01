
////// Higher-Order Functions 
// def sumInts(a: Int, b: Int): Int = 
// 	if (a > b) 0 else a + sumInts(a + 1, b)


// def cube(x: Int): Int = x*x*x

// def sumCubes(a: Int, b: Int): Int = 
// 	if (a > b) 0 else cube(a) + sumCubes(a + 1, b)


// println(cube(1))

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//// Function as parameter
//// 

// def sum(f: Int => Int, a: Int, b: Int): Int =
	// if (a > b) 0
	// else f(a) + sum(f, a + 1, b)


// def sumInts(a: Int, b: Int) 		= sum(id, a, b)
// def sumCubes(a: Int, b: Int) 		= sum(cube, a, b)
// def sumFactorials(a: Int, b: Int) 	= sum(fact, a, b)

// def id(x: Int): Int 	= x
// def cube(x: Int): Int 	= x*x*x
// def fact(x: Int): Int 	= if (x == 0) 1 else fact(x - 1)


// println(sumFactorials(1, 5))

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

////// Function without name
//// Anonymous Functions 

(x: Int) => x * x * x

(x: Int, y: Int) => x + y

def sumInts(a: Int, b: Int) 		= sum(x => x, a, b)
def sumCubes(a: Int, b: Int) 		= sum(x => x * x * x, a, b)

// println(sumCubes(1, 5))


def sum(f: Int => Int, a: Int, b: Int): Int = {
	def loop(a: Int, acc: Int): Int = {
		if (a > b) acc
		else loop(a + 1, acc + f(a))
	}
	loop(a, 0)
}

println(sum(x => x, 1, 3))















