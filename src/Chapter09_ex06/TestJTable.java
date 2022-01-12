package Chapter09_ex06;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.EventHandler;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import myFrame.MyJFrame;
import static Chapter09_ex06.R.*;

public class TestJTable extends MyJFrame {

	public TestJTable() {
		super("JTable 연습", 640, 480);
	}

	private void mkTableData() {
		// columnNames = new Object[] { "IDX", "USER", "EMAIL", "PHONE" };
//		data = new Object[][] { { 1, "hong", "hong@naver.com", "010-1234-5678" },
//				{ 2, "kim", "kim@naver.com", "010-2222-2222" }, { 3, "lee", "lee@naver.com", "010-3333-3333" }, };
		columnNames = new Vector();
		columnNames.add("IDX");
		columnNames.add("NAME");
		columnNames.add("EMAIL");
		columnNames.add("PHONE");

		// Object[][] 배열을 대체하는 코드 →model로 넘어가야됨
		data = dao.selectAll();
	}

	protected void displayLayer() {
		mkTableData();
		contentPan = getContentPane();
		contentPan.add(BorderLayout.WEST, new LeftPane());
		contentPan.add(BorderLayout.SOUTH, new BottomPane());

		tbModel = new DefaultTableModel(data, columnNames);
		table = new JTable(tbModel);
		scrollPane = new JScrollPane(table);
		contentPan.add(scrollPane);
	}

	protected void addRowDataTest() {
		tbModel.setDataVector(null, columnNames);// 테이블만 남고 데이터 지워짐
		tbModel.addRow(new Object[] { 4, "kang", "kang@naver.com", "010-4444-4444" });
		tbModel.addRow(new Object[] { 5, "aaa", "aaa@naver.com", "010-5555-5555" });
	}

	protected void actionEvent() {
		// 버튼 이벤트 핸들러 추가
		allBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbModel.setDataVector(null, columnNames);// 테이블만 남고 데이터 지워짐
				Vector<Vector> saramList = dao.selectAll();
				for (Vector vector : saramList) {
					tbModel.addRow(vector);
				}
			}
		});

		inputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// textField의 데이터를 읽어온다.
				String name = txtFld2.getText();
				txtFld2.setText("");// 입력후 다시 공란
				String email = txtFld3.getText();
				txtFld3.setText("");
				String phone = txtFld4.getText();
				txtFld4.setText("");
				// TableModel에 반영해주기.
				// dao에 저장 후
				dao.insert(new SaramDto(0, name, email, phone));
				// list를 다시 그려준다.
				displayList();

			}

			private void displayList() {
				tbModel.setDataVector(null, columnNames);// 테이블만 남고 데이터 지워짐
				Vector<Vector> saramList = dao.selectAll();
				for (Vector vector : saramList) {
					tbModel.addRow(vector);
				}
			}
		});

		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtFld2.getText();
				Vector vector = dao.search(new SaramDto(0, name, "", ""));
				tbModel.setDataVector(null, columnNames);
				tbModel.addRow(vector);
//				txtFld2.setText("");// 입력후 다시 공란
			}

		});

		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idx = txtFld1.getText();
				String name = txtFld2.getText();
				String email = txtFld3.getText();
				String phone = txtFld4.getText();
				//Vector vector = dao.modify(new SaramDto(0, name, "", ""));
			}
		});

		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtFld2.getText();
				Vector vector = dao.delete(new SaramDto(0, name, "", ""));
				tbModel.setDataVector(null, columnNames);
				//tbModel.removeRow();
			}
		});

		finishBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(TestJTable.this, "굿바이 안녕");
				dispose();
				System.exit(0);

			}
		});

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(">>> 마우스를 눌렀다.");
				JTable tbl = (JTable) e.getSource();
				// 테이블의 전체 행과 열 알아내기
				int totalcol = tbl.getColumnCount();
				int totalrow = tbl.getRowCount();
				// 선택한 컬럼의 행과 열 알아내기
				int row = table.getSelectedRow();
				int col = table.getSelectedRowCount();
				// 데이터 가져오기
				int idx = (int) tbModel.getValueAt(row, 0);
				String name = (String) tbModel.getValueAt(row, 1);
				String email = (String) tbModel.getValueAt(row, 2);
				String phone = (String) tbModel.getValueAt(row, 3);
				// 찾아 온 데이터 적용하기
				txtFld1.setText("" + idx);
				txtFld2.setText(name);
				txtFld3.setText(email);
				txtFld4.setText(phone);
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}
		});

	}

	public static void main(String[] args) {
		new TestJTable().setVisible(true);

	}

}
