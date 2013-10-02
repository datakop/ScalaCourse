class Rational(x: Int, y: Int) {
	def numer = x
	def denom = y

	def neg = new Rational(-numer, denom)

	def add(that: Rational) = 
		new Rational(
			numer* that.denom + that.numer * denom,
			denom * that.denom)

	def sub(that: Rational) = 
		add(that.neg)

	override def toString(): String =  numer + "/" + denom 

	
	
}

val x = new Rational(1,3)
val y = new Rational(5,7)
val z = new Rational(3,2)


println((x.sub(y)).sub(z))

