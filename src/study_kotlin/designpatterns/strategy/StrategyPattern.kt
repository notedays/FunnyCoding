package designpatterns.starategy

/**
# Strategy Pattern

i) 알고리즘군을 정의하고 각각 캡슐화하여 교환해서 사용하도록 만드는 기법.
i) 알고리즘의 변화에 자유롭고 같은 알고리즘을 사용하는 다른 클라이언트와 독립적으로 알고리즘을 변경할 수 있다.
 */
fun main(args: Array<String>) {
	val character = Knight()
	character.fight()
	character.setWeaponBehavior(BowBehavior())
	character.fight()
}

// 무기별 행동을 정하는 인터페이스
interface WeaponBehavior {
	fun useWeapon()
}

// 행동 구현체
class SwordBehavior : WeaponBehavior {
	override fun useWeapon() = println("칼 휘두르기")
}

class BowBehavior : WeaponBehavior {
	override fun useWeapon() = println("활 쏘기")
}

// 무기를 들고 실제 공격을 하는 캐릭터
abstract class Character(var weapon: WeaponBehavior) {
	fun setWeaponBehavior(weapon: WeaponBehavior) {
		this.weapon = weapon
	}

	fun fight() {
		weapon.useWeapon()
	}
}

// Character를 상속받는 실제 구현 캐릭터
class Knight : Character(SwordBehavior())
class Archer : Character(BowBehavior())


