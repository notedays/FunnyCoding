package practice.notedays.simple

import java.util.*

class SimpleTaskBox {

	private val tasks:Queue<Runnable> = LinkedList()

	fun addTask(task:Runnable) = tasks.add(task)

	fun removeTask(task:Runnable) = tasks.remove(task)

}