////Currying

// def sum(f: Int => Int): (Int, Int) => Int = {

// 	def sumF(a: Int, b: Int): Int = 
// 		if (a > b) 0
// 		else f(a) + sumF(a + 1, b)

// 	sumF
	
// } // sum returns another function
// // sumF applies f()

def fact(x: Int): Int 	= if (x == 0) 1 else x * fact(x - 1)

// def sumInts 		= sum(x => x)
// def sumCubes 		= sum(x => x*x*x)
// def sumFactorials 	= sum(fact)


def sum(f: Int => Int)(a: Int, b: Int): Int = 
	if (a > b) 0 else f(a) + sum(f)(a + 1, b)


println(sum(fact)(1, 5))


// Definition of a function with multiple params

// def f(args_1)...(args_n) = E
// where n > 1, is equivalent to 
	// def f(args_1)..(args_n-1) = {def g(args_n) = E; g}
// where g is a fresh indentifier. Or in short :
	// def f(args_1)..(args_n-1) = ( args_n => E)


// def f(args_1)...(args_n-1)(args_n) = E
// 				equivalent
// def f = (args_1 => (args_1 => ...(args_n => E)...))



















