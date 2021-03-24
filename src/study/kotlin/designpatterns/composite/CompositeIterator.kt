package study.kotlin.designpatterns.composite

import java.util.Stack

// # 재귀 함수를 활용하여 MenuComponent 트리구조의 최하층 객체까지 도달하여 데이터를 가져오는 Iterator 
class CompositeIterator(val iterator: Iterator<MenuComponent>) : Iterator<MenuComponent> {
	val stack: Stack<Iterator<MenuComponent>> = Stack()

	init {
		stack.push(iterator)
	}

	override fun hasNext(): Boolean {
		if (stack.empty()) return false
		else with(stack.peek()) {
			if (!hasNext()) {
				stack.pop()
				return hasNext() // 재귀함수 호출
			}
			return true
		}
	}

	override fun next(): MenuComponent {
		if (!hasNext()) {
			return MenuItem("", "", false, 0.0)
		}
		with(stack.peek().next()) {
			if (this is Menu) {
				stack.push(this.iterator())
			}
			return this
		}
	}
}

// 빈 값들을 정의해주는 Iterator (NPE 체킹 안하는 용도로)
class EmptyIterator : Iterator<MenuComponent> {
	override fun hasNext(): Boolean = false
	override fun next() = MenuItem("", "", false, 0.0)
}