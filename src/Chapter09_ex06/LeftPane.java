package Chapter09_ex06;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static Chapter09_ex06.R.*;

public class LeftPane extends JPanel {
   
   public LeftPane() {
      JPanel rowPan1 = new JPanel();
      rowPan1.add(new JLabel(" ���̵� :"));
      rowPan1.add(txtFld1);
      
      JPanel rowPan2 = new JPanel();
      rowPan2.add(new JLabel("�� ��:"));
      rowPan2.add(txtFld2);
      
      JPanel rowPan3 = new JPanel();
      rowPan3.add(new JLabel("�̸���:"));
      rowPan3.add(txtFld3);
      
      JPanel rowPan4 = new JPanel();
      rowPan4.add(new JLabel("�ڵ���:"));
      rowPan4.add(txtFld4);
      
      JPanel gridPan = new JPanel(new GridLayout(5, 1));
      gridPan.add(rowPan1);
      gridPan.add(rowPan2);
      gridPan.add(rowPan3);
      gridPan.add(rowPan4);
      
      this.add(gridPan);
   }
}