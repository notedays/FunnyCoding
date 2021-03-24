package study.kotlin.designpatterns.iterator

import java.util.Hashtable

fun main(args: Array<String>) {
	with(Waitress(PancakeHouseMenu(), DinerMenu(), CafeMenu())) {
		printMenu()
		printVegetarianMenu()
	}

}

/**
# 이터레이터 패턴

 */

data class MenuItem(
	val name: String,
	val description: String,
	val vegetarian: Boolean,
	val price: Double
) {
	override fun toString() = "$name, $price$ -- $description"
}

interface Menu : Iterable<MenuItem?> {
	companion object {
		val BREAKFAST = 0
		val LUNCH = 1
		val DINNER = 2
	}

	fun getType(): Int
}

class PancakeHouseMenu : Menu {
	override fun iterator() = menuItems.iterator()
	override fun getType(): Int = Menu.BREAKFAST

	val menuItems: MutableList<MenuItem> = mutableListOf()

	init {
		with(menuItems) {
			add(MenuItem("K&B 팬케이크 세트", "스크램블드 에그와 토스트가 곁들여진 팬케이크", true, 2.99))
			add(MenuItem("레귤러 팬케이크 세트", "달걀 후라이와 소시지가 곁들여진 팬케이크", false, 2.99))
			add(MenuItem("블루베리 팬케이크", "신선한 블루베리와 블루베리 시럽으로 만든 팬케이크", true, 3.49))
			add(MenuItem("와플", "와플, 취향에 따라 블루베리나 딸기를 얹을 수 있습니다.", true, 3.59))
		}
	}
}

class DinerMenu : Menu {

	override fun iterator() = menuItems.iterator()
	override fun getType(): Int = Menu.LUNCH

	val menuItems: Array<MenuItem?> = arrayOfNulls(6)

	private val menuAdder = { menu: MenuItem ->
		with(menuItems.indexOf(null)) {
			if (this > -1) menuItems[this] = menu
			else println("죄송합니다. 메뉴가 꽉 찼습니다. 더 이상 추가할 수 없습니다.")
		}
	}

	init {
		menuAdder.invoke(MenuItem("채식주의자용 BLT", "통밀 위에 (식물성) 베이컨, 상추, 토마토를 얹은 메뉴", true, 2.99))
		menuAdder.invoke(MenuItem("BLT", "통밀 위에 베이컨, 상추, 토마토를 얹은 메뉴", false, 2.99))
		menuAdder.invoke(MenuItem("오늘의 스프", "감자 샐러드를 곁들인 오늘의 스프", false, 3.29))
		menuAdder.invoke(MenuItem("핫도그", "사워크라우트, 갖은 양념, 양파, 치즈가 곁들어진 핫도그", false, 3.05))
	}
}

class CafeMenu : Menu {
	override fun iterator() = menuItems.values.iterator()
	override fun getType(): Int = Menu.DINNER

	val menuItems: Hashtable<String, MenuItem> = Hashtable()

	private val menuAdder = { menu: MenuItem -> menuItems.put(menu.name, menu) }

	init {
		menuAdder.invoke(MenuItem("베지 버거와 에어 프라이", "통밀빵, 상추, 토마토, 감자튀김이 첨가된 베지 버거", true, 3.99))
		menuAdder.invoke(MenuItem("오늘의 스프", "샐러드가 곁들여진 오늘의 스프", false, 3.69))
		menuAdder.invoke(MenuItem("베리또", "통 핀토콩과 살사, 구아카몰이 곁들여진 푸짐한 베리또", true, 4.29))
	}
}

class Waitress(vararg val menus: Menu) {

	val menuFilter = { time: Int -> menus.filter { time == it.getType() } }
	val vegetarianFilter = { menuItem: MenuItem? -> menuItem?.vegetarian ?: false }

	val menuPrinter = { menu: Menu ->
		when (menu.getType()) {
			Menu.BREAKFAST -> println("아침 메뉴\n----")
			Menu.LUNCH -> println("점심 메뉴\n----")
			Menu.DINNER -> println("저녁 메뉴\n----")
		}
		menu.iterator().forEach { it?.let { println(it) } }
		println()
	}

	fun printMenu() { // 메뉴에 있는 모든 항목 출력
		menus.forEach { menuPrinter.invoke(it); println() }
	}

	fun printMenuWithType(type: Int) = menuPrinter.invoke(menuFilter.invoke(type).first())
	fun printVegetarianMenu() {
		println("채식주의자 메뉴\n----")
		menus.forEach { it.iterator().forEach { if (vegetarianFilter.invoke(it)) println(it) } }
	}

}