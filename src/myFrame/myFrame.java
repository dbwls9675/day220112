package myFrame;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class myFrame extends Frame {
	// 디폴트 생성자
	public myFrame() {// 기본값
		this("my-frame", 500, 500);
	}

	// 생성자 오버로딩
	public myFrame(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);

		// 이벤트 핸들러
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});

		// 스크린 화면의 정 가운데 배치
		Toolkit tk = this.getToolkit().getDefaultToolkit();
		int scrWidth = (int) tk.getScreenSize().getWidth();
		int scrHeight = (int) tk.getScreenSize().getHeight();
		// 스크린화면에 가운데 정렬
		int x = scrWidth / 2 - w / 2;
		int y = scrHeight / 2 - h / 2;

		this.setLocation(x, y);

	}

}
