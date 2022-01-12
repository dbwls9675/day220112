package Chapter09_ex06;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.EventHandler;

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
	JTable table;
	DefaultTableModel tbModel;
	JScrollPane scrollPane;

	Object[][] data;
	Object[] columnNames;

	public TestJTable() {
		super("JTable ����", 640, 480);
	}

	private void mkTableData() {
		columnNames = new Object[] { "IDX", "USER", "EMAIL", "PHONE" };
		data = new Object[][] { { 1, "hong", "hong@naver.com", "010-1234-5678" },
				{ 2, "kim", "kim@naver.com", "010-2222-2222" }, { 3, "lee", "lee@naver.com", "010-3333-3333" }, };
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
		tbModel.setDataVector(null, columnNames);// ���̺� ���� ������ ������
		tbModel.addRow(new Object[] { 4, "kang", "kang@naver.com", "010-4444-4444" });
		tbModel.addRow(new Object[] { 5, "aaa", "aaa@naver.com", "010-5555-5555" });
	}

	protected void actionEvent() {
		// ��ư �̺�Ʈ �ڵ鷯 �߰�
		allBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(">>> allBtn Ŭ��!");

			}
		});

		inputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// textField�� �����͸� �о�´�.
				String name = txtFld2.getText();
				txtFld2.setText("");// �Է��� �ٽ� ����
				String email = txtFld3.getText();
				txtFld3.setText("");
				String phone = txtFld4.getText();
				txtFld4.setText("");
				// TableModel�� �ݿ����ֱ�.
				tbModel.addRow(new Object[] { sequence++, name, email, phone });

			}
		});

		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(">>> searchBtn Ŭ��!");

			}
		});

		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(">>> modifyBtn Ŭ��!");

			}
		});

		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(">>> deleteBtn Ŭ��!");

			}
		});

		finishBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(TestJTable.this, "�¹��� �ȳ�");
				dispose();
				System.exit(0);

			}
		});

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(">>> ���콺�� ������.");
				JTable tbl = (JTable) e.getSource();
				// ���̺��� ��ü ��� �� �˾Ƴ���
				int totalcol = tbl.getColumnCount();
				int totalrow = tbl.getRowCount();
				// ������ �÷��� ��� �� �˾Ƴ���
				int row = table.getSelectedRow();
				int col = table.getSelectedRowCount();
				// ������ ��������
				int idx = (int) tbModel.getValueAt(row, 0);
				String name = (String) tbModel.getValueAt(row, 1);
				String email = (String) tbModel.getValueAt(row, 2);
				String phone = (String) tbModel.getValueAt(row, 3);
				//ã�� �� ������ �����ϱ�
				txtFld1.setText(""+idx);
				txtFld2.setText(name);
				txtFld3.setText(email);
				txtFld4.setText(phone);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	public static void main(String[] args) {
		new TestJTable().setVisible(true);

	}

}
