package myFrame;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class myFrame extends Frame {
	// ����Ʈ ������
	public myFrame() {// �⺻��
		this("my-frame", 500, 500);
	}

	// ������ �����ε�
	public myFrame(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);

		// �̺�Ʈ �ڵ鷯
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});

		// ��ũ�� ȭ���� �� ��� ��ġ
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scrWidth = (int) tk.getScreenSize().getWidth();
		int scrHeight = (int) tk.getScreenSize().getHeight();
		// ��ũ��ȭ�鿡 ��� ����
		int x = scrWidth / 2 - w / 2;
		int y = scrHeight / 2 - h / 2;

		this.setLocation(x, y);

	}

}
