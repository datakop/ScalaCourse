
// x is a fixed point of a function f if 
// f(x) = x

import math.abs

val tolerance = 0.0001

def isCloseEnough(x: Double, y: Double) = 
	abs((x - y) / x) / x < tolerance

def fixedPoint(f: Double => Double)(firstGuess: Double) = {
	def iterate(guess: Double): Double = {
		println("guess " + guess)
		val next = f(guess)
		println("	next " + next)
		if (isCloseEnough(guess, next)) next
		else iterate(next)
	}
	iterate(firstGuess)
}

def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

fixedPoint(x => 1 + x/2)(1)

// sqrt(x) = the number y such that y*y = x
// sqrt(x) = the number y such that y = x / y


def sqrt(x: Double) = fixedPoint(averageDamp(y => x/y))(1)

println(sqrt(2))