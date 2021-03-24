package study.kotlin.basic

fun main() {
	val general = General("소영", 31)
	println(general == General("소영", 31))
	println(general.hashCode())
	println(general)

	println()

	val data = Data("정원", 33)
	println(data == Data("정원", 33))
	println(data.hashCode())
	println(data)

	println()

	val datas = mutableListOf<Data>()
	datas.add(data.copy())
	datas.add(data.copy(name = "카나"))
	datas.add(data.copy(name = "카나", age = 31))

	for ((name, age) in datas) {
		println("$age 살 $name")
	}
}


class General(val name: String, val age: Int)

data class Data(val name: String, val age: Int)