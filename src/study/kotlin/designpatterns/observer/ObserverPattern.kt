package study.kotlin.designpatterns.observer

/**
# 옵저버 패턴
- Subject와 Observer 들의 일대다 관계
- Subject의 상태변화에 따라 반응할 객체가 여럿일 때 용이

i) Subject (interface)
- 옵저버의 등록 / 해지 / 브로드캐스팅 담당

i) Observer (interface)
- 원하는 Subject에 등록되어 Subject의 브로드캐스팅을 받을 수 있는 구독자
 */
fun main(args: Array<String>) {
	val bjChanghyeon = BJChangHyeon()
	val jenny = Jenny()
	val bjTaegu = BJTaegu()

	// bj 창현을 구독중인 제니와 태구	
	bjChanghyeon.registObserver(jenny)
	bjChanghyeon.registObserver(bjTaegu)


	bjChanghyeon.registVideo(Video("BJ 창현", "4월 거리 노래방", "따뜻한 감성 발라더 - 성시경"))
	
	// 제니 - bj 창현 구독 취소 & bj 태구 구독
	bjChanghyeon.removeObserver(jenny)
	bjTaegu.registObserver(jenny)
	
	bjChanghyeon.registVideo(Video("BJ 창현", "5월 거리 노래방", "속이 뻥 뚤리는 시원한 고음 폭격기 - 소찬휘"))

	bjTaegu.registVideo(Video("BJ 태구", "태구의 켠김에 왕까지", "보다가 암걸리는 발컨으로 켠김에 왕까지 가보자!!"))
}

// Observer들이 구독할 채널
interface Subject<I> {
	fun registObserver(observer: Observer<I>)
	fun removeObserver(observer: Observer<I>)
	fun notifyObservers()
}

// Subject를 구독하는 구독자
interface Observer<I> {
	fun update(info: I)
}

// Observer들이 Subject로 부터 구독 중인 데이터
data class Video(val register: String, val title: String, val context: String) {
	override fun toString(): String {
		return "[$title : $context] by $register"
	}
}


// Subject를 구현& 확장하는 추상 클래스
abstract class BJ : Subject<Video> {
	// 구독자 목록
	val observerList: MutableList<Observer<Video>> = mutableListOf();

	// 최신 비디오
	var latestVideo: Video = Video("", "", "")

	override fun registObserver(observer: Observer<Video>) {
		synchronized(observerList) {
			observerList.add(observer)
		}
	}

	override fun removeObserver(observer: Observer<Video>) {
		synchronized(observerList) {
			observerList.remove(observer)
		}
	}

	override fun notifyObservers() {
		observerList.forEach({ it.update(latestVideo) })
	}

	fun registVideo(video: Video) {
		this.latestVideo = video
		notifyObservers();
	}
}

// Subject를 구현한 BJ창현 클래스
class BJChangHyeon : BJ()

// 단순히 구독자인 Jenny
class Jenny : Observer<Video> {
	override fun update(info: Video) {
		println("제니 구독 중 - $info")
	}
}

// BJ 창현의 구독자이면서 BJ이기도 한 BJ 태구
class BJTaegu : BJ(), Observer<Video> {
	override fun update(info: Video) {
		println("BJ태구 구독 중 - $info")
	}
}

