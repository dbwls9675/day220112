package myFrame;

import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class MyJFrame extends JFrame {
	protected Container contentPan = null;

	public MyJFrame() {
		this("My JFrame", 200, 200);
	}

	public MyJFrame(String title, int w, int h) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(title);
		setSize(w, h);

		displayLayer();
		actionEvent();

		// 스크린 화면의 정 가운데 배치
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scrWidth = (int) tk.getScreenSize().getWidth();
		int scrHeight = (int) tk.getScreenSize().getHeight();
		// 스크린화면에 가운데 정렬
		int x = scrWidth / 2 - w / 2;
		int y = scrHeight / 2 - h / 2;

		this.setLocation(x, y);
	}

	protected abstract void displayLayer();

	protected abstract void actionEvent();
}
