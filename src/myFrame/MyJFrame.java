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

		// ��ũ�� ȭ���� �� ��� ��ġ
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scrWidth = (int) tk.getScreenSize().getWidth();
		int scrHeight = (int) tk.getScreenSize().getHeight();
		// ��ũ��ȭ�鿡 ��� ����
		int x = scrWidth / 2 - w / 2;
		int y = scrHeight / 2 - h / 2;

		this.setLocation(x, y);
	}

	protected abstract void displayLayer();

	protected abstract void actionEvent();
}
