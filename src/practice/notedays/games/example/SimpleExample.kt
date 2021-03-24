package practice.notedays.games.example

fun main(args: Array<String>) {
	SimpleExample()
}

class SimpleExample {
	
	init {

	}

	private fun <D> convertMap(map: Map<String, Any>, dataExtractor: (String, D) -> Any): List<D> {
		val list:MutableList<D> = mutableListOf();
		return list
	}
	
}
