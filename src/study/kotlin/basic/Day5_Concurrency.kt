package basic

fun main(args: Array<String>) {
	for(i in 1..10) {
		Thread({
			up()
			println("num_$num")
		})
	}
}

var num = 0

fun up() {
	num++
}