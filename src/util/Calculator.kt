package util

class Calculator {
	
	public fun calculate(num1: Int, num2: Int, oper: String): Int = when (oper) {
		"+" -> num1 + num2
		"-" -> num1 - num2
		"*" -> num1 * num2
		else -> if (num2 != 0) num1 / num2 else 0
	}
	
}