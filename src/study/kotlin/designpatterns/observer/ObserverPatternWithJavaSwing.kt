package study.kotlin.designpatterns.observer

import java.awt.BorderLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JOptionPane


/*
 # Java Swing 의  옵저버 패턴
 
 i) Observable 인 JButton
 i) Observer인 ActionListener
 
 -> ActionListener를 Subject인 JButton에 등록하여
 JButton 에서 이벤트 발생 시 Listener에게 전달!
 */
fun main(args: Array<String>) {
	SwingObserverExample()
}

class SwingObserverExample {

	val frame = JFrame()
	val button = JButton("누르면 뭐가 나오지??")
	val dialog = JOptionPane()

	init {
		frame.add(BorderLayout.CENTER, button)
		frame.setSize(400, 300)
		frame.setVisible(true)

		button.addActionListener {
			var randomText = if (Math.random() < 0.5) "Go!!\nWhat you want to do!" else "Stop!!\nThe things that you're goint to do"
			JOptionPane.showMessageDialog(frame, randomText)
		}

		button.addActionListener {
			println("Button is Clicked!!")
		}
	}
}