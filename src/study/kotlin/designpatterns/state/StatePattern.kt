package study.kotlin.designpatterns.state

fun main(args: Array<String>) {
	val machine = GumballMachine(100)
	machine.insertQuarter()
//	machine.ejectQuarter()
//
//	machine.insertQuarter()
//	machine.turnCrank()
//	machine.dispense()
}

/**
# 스테이트 패턴?
- 객체의 내부 상태가 바뀜에 따라서 객체의 행동을 바꿀 수 있음.
 */
class GumballMachine(var count: Int) {

	val noQuarterState = NoQuarterState(this)
	val hasQuarterState = HasQuarterState(this)
	val soldOutState = SoldOutState(this)
	val soldState = SoldState(this)

	lateinit var state: State

	init {
		if (count > 0) {
			state = noQuarterState
		}
	}

	public fun insertQuarter() = state.insertQuarter()
	public fun ejectQuarter() = state.ejectQuarter()
	public fun turnCrank() = state.turnCrank()
	public fun dispense() = state.dispense()
}


interface State {
	fun insertQuarter()
	fun ejectQuarter()
	fun turnCrank()
	fun dispense()
}

class NoQuarterState(val machine: GumballMachine) : State {

	override fun insertQuarter() = with(machine) {
		println("동전을 넣으셨습니다.")
		state = hasQuarterState
	}

	override fun ejectQuarter() = println("동전을 넣어주세요.")
	override fun turnCrank() = println("동전을 넣어주세요")
	override fun dispense() = println("동전을 넣어주세요")
}

class HasQuarterState(val machine: GumballMachine) : State {

	override fun insertQuarter() = println("동전은 한개만 넣어주세요.")
	override fun ejectQuarter() = with(machine) {
		println("동전이 반환됩니다.")
		state = noQuarterState
	}

	override fun turnCrank() = with(machine) {
		println("손잡이를 돌리셨습니다.")
		state = soldState
	}

	override fun dispense() = println("알맹이가 나갈 수 없습니다.")
}

class SoldState(val machine: GumballMachine) : State {

	override fun insertQuarter() = println("잠깐만 기다려 주세요. 알맹이가 나가고 있습니다.")
	override fun ejectQuarter() = println("이미 알맹이를 뽑으셨습니다.")
	override fun turnCrank() = println("손잡이는 한번만 돌려주세요.")
	override fun dispense() = with(machine) {
		if (--count == 0) {
			println("알맹이가 전부 소진되었습니다.")
			state = soldOutState
		} else {
			println("알맹이가 나갑니다. 남은 알맹이 : $count")
			state = noQuarterState
		}
	}
}

class SoldOutState(val machine: GumballMachine) : State {

	override fun insertQuarter() = println("모든 알맹이가 소진되어 이용하실 수 없습니다.")
	override fun ejectQuarter() = println("동전을 넣어주세요.")
	override fun turnCrank() = println("동전을 넣어주세요")
	override fun dispense() = println("동전을 넣어주세요")
}

