package study.kotlin.designpatterns.composite

fun main(args: Array<String>) {

	val pancakeHouseMenu = Menu("팬케이크 하우스 메뉴", "아침 메뉴").apply {
		add(MenuItem("K&B 팬케이크 세트", "스크램블드 에그와 토스트가 곁들여진 팬케이크", true, 2.99))
		add(MenuItem("레귤러 팬케이크 세트", "달걀 후라이와 소시지가 곁들여진 팬케이크", false, 2.99))
		add(MenuItem("블루베리 팬케이크", "신선한 블루베리와 블루베리 시럽으로 만든 팬케이크", true, 3.49))
		add(MenuItem("와플", "와플, 취향에 따라 블루베리나 딸기를 얹을 수 있습니다.", true, 3.59))
	}

	val dessertMenu = Menu("디저트 메뉴", "디저트를 즐겨 보세요!").apply {
		add(MenuItem("애플 파이", "바삭바삭한 크러스트에 바닐라 아이스크림이 얹혀 있는 애플 파이", true, 1.59))
	}

	val dinerMenu = Menu("식당 메뉴", "점심 메뉴").apply {
		add(MenuItem("채식주의자용 BLT", "통밀 위에 (식물성) 베이컨, 상추, 토마토를 얹은 메뉴", true, 2.99))
		add(MenuItem("BLT", "통밀 위에 베이컨, 상추, 토마토를 얹은 메뉴", false, 2.99))
		add(MenuItem("오늘의 스프", "감자 샐러드를 곁들인 오늘의 스프", false, 3.29))
		add(MenuItem("핫도그", "사워크라우트, 갖은 양념, 양파, 치즈가 곁들어진 핫도그", false, 3.05))
		add(MenuItem("파스타", "마리나라 소스 스파게티. 효모빵도 드립니다.", true, 3.89))
		add(dessertMenu)
	}

	val cafeMenu = Menu("카페 메뉴", "저녁 메뉴").apply {
		add(MenuItem("베지 버거와 에어 프라이", "통밀빵, 상추, 토마토, 감자튀김이 첨가된 베지 버거", true, 3.99))
		add(MenuItem("오늘의 스프", "샐러드가 곁들여진 오늘의 스프", false, 3.69))
		add(MenuItem("베리또", "통 핀토콩과 살사, 구아카몰이 곁들여진 푸짐한 베리또", true, 4.29))
	}

	val allMenus = Menu("전체 메뉴", "전체 메뉴").apply {
		add(pancakeHouseMenu)
		add(dinerMenu)
		add(cafeMenu)
	}

	Waitress(allMenus).let {
		it.printMenu()
		it.printVegetarianMenu()
	}
}

/*
 # 컴포지트 패턴?
 
 i) 객체들을 트리 구조로 구성하여 부분과 전체를 나타내는 계층구조로 만들 수 있음.
 i) 클라이언트에서 개별 객체와 다른 객체들로 구성된 복합 객체를 똑같은 방법으로 다룰 수 있음.
 
 -- 아래의 예시에서는 각각의 메뉴를 나타내는 MenuItem과 메뉴 목록을 나타내는 Menu를 하나의 복합 객체인 MenuComponent로 취급하여 다룸
 */

// 트리 구조를 위한 기본 메소드들과 기본 적으로 제공될 메소드 (출력 & 채식주의자 판별)
abstract class MenuComponent : Iterable<MenuComponent> {
	open fun add(menuComponent: MenuComponent): Boolean {
		throw UnsupportedOperationException()
	}

	open fun remove(menuComponent: MenuComponent): Boolean {
		throw UnsupportedOperationException()
	}

	open fun getChild(i: Int): MenuComponent {
		throw UnsupportedOperationException()
	}

	open fun vegetarian(): Boolean = false

	open fun print() {
		throw UnsupportedOperationException()
	}
}

// 개별 메뉴 정보를 담는 클래스 
data class MenuItem(
	val name: String,
	val description: String,
	val vegetarian: Boolean,
	val price: Double
) : MenuComponent() {
	override fun iterator() = EmptyIterator()
	override fun print() {
		println("$name${if (vegetarian) "(v)" else ""}, $price$ -- $description")
	}

	override fun vegetarian() = vegetarian
}

// MenuItem들을 담을 수 있는 메뉴 목록 클래스
class Menu(
	val name: String,
	val description: String,
	val menuComponents: MutableList<MenuComponent> = arrayListOf()
) : MenuComponent() {
	override fun iterator(): Iterator<MenuComponent> = CompositeIterator(menuComponents.iterator())
	override fun add(menuComponent: MenuComponent) = menuComponents.add(menuComponent)
	override fun remove(menuComponent: MenuComponent) = menuComponents.remove(menuComponent)
	override fun getChild(i: Int) = menuComponents[i]
	override fun print() {
		println("\n$name [$description]\n----------------------------")
		menuComponents.forEach { it.print() }
	}
}

class Waitress(val allMenus: MenuComponent) {
	fun printMenu() = allMenus.print()
	fun printVegetarianMenu() {
		println("\n채식주의자 메뉴\n----------------------------")
		allMenus.filter { it.vegetarian() }.forEach { it.print() }
	}
}