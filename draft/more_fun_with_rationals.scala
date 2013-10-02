// Self
// Predictons 
// Assertions
// Constructors ( Several constractors )
// 

class Rational(x: Int, y: Int) {
	// Requires
	require(y != 0, "denominator must be nonzero")

	// Second constractor
	def this(x: Int) = this(x, 1)

	// Private
	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
	// private val g = gcd(x, y)

	// Data
	def numer = x /// g
	def denom = y /// g

	// Methods
	def less(that: Rational) = this.numer * that.denom < that.numer * this.denom

	def max(that: Rational) = if (this.less(that)) that else this

	def neg = new Rational(-numer, denom)

	def add(that: Rational) = 
		new Rational(
			numer* that.denom + that.numer * denom,
			denom * that.denom)

	def sub(that: Rational) = 
		add(that.neg)

	override def toString(): String =  {
		val g = gcd(numer, denom)
		numer / g + "/" + denom / g
	}
}

val x = new Rational(1,1)
val y = new Rational(5,7)
val z = new Rational(3,2)

println(x.max(y))


