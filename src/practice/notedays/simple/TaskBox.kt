package practice.notedays.simple

import util.Music
import java.util.Queue
import java.util.LinkedList

class TaskBox(val taskQueue: Queue<() -> Unit> = LinkedList()) : Thread({
	while (true) {
		synchronized(taskQueue, {
			while (taskQueue.isNotEmpty()) {
				taskQueue.poll().invoke()
			}
		})
		Thread.sleep(50)
	}
}) {
	init {
		start()
	}

	fun addTask(task: () -> Unit) = synchronized(taskQueue, { taskQueue.add(task) })

	fun clear() = synchronized(taskQueue, { taskQueue.clear() })
}


fun main(args: Array<String>) {
	val taskBox = TaskBox()
	taskBox.addTask({
		Music("music/스텔라장_그대만보여.mp3", false).start()
	})
	Thread.sleep(500)
	taskBox.clear()
}