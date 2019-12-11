package practice.notedays.games

import javax.swing.JFrame

abstract class GameApp(appTitle: String, appWidth: Int, appHeight: Int) : JFrame() {

	// @ 렌더링 처리 스레드
	val renderer = Thread({
		while (true) {
			try {
				getComponent(0).repaint()
				Thread.sleep(30)
			} catch (e: Exception) {
				e.printStackTrace()
			}
		}
	})

	abstract fun makeCanvas(): GameCanvas

	init {
		// @ 실제 캔버스 추가
		add("Center", makeCanvas())

		// @ 앱 기본 설정
		setTitle(appTitle)
		setSize(appWidth, appHeight)
		setVisible(true)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

		// @ 렌더링 시작
		renderer.start()
	}

}