package mainJF;

import java.awt.EventQueue;
//�û��޸��������
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author 22476
 *
 */
public class JF003 extends JInternalFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	private static JF003 jf001 = null;//�����Ӵ���Ϊ˽��
	private JPasswordField passwordField_1;
	//��̬����������ֻ����һ������synchronized��֤�̰߳���
	public static synchronized JF003 getInstance() {
		if (jf001 == null) {
			jf001 = new JF003 ();
		}
		return jf001;
}

	private JF003() {
		setClosable(true);
		setTitle("�޸�����");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);//�޸�����
		
		JLabel lblNewLabel = new JLabel("�˺�");
		lblNewLabel.setBounds(40, 0, 63, 54);
		getContentPane().add(lblNewLabel);//�˺�
		
		textField = new JTextField();
		textField.setBounds(98, 9, 157, 37);
		getContentPane().add(textField);
		textField.setColumns(10);//�˺������
		
		JLabel lblNewLabel_1 = new JLabel("ԭ����");
		lblNewLabel_1.setBounds(40, 47, 63, 54);
		getContentPane().add(lblNewLabel_1);//ԭ����
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 56, 157, 38);
		getContentPane().add(passwordField);//���������
		
		JLabel lblNewLabel_1_1 = new JLabel("������");
		lblNewLabel_1_1.setBounds(40, 100, 63, 54);
		getContentPane().add(lblNewLabel_1_1);//ȷ��������
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(98, 111, 157, 38);
		getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(265, 10, 159, 36);
		getContentPane().add(lblNewLabel_3);//�˺�������ʾ��
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(265, 58, 159, 36);
		getContentPane().add(lblNewLabel_3_1);//ԭ����������ʾ��
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setBounds(265, 113, 159, 36);
		getContentPane().add(lblNewLabel_3_2);//������������ʾ��
		
		
		
		JButton btnNewButton = new JButton("�޸�");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Check check=new Check();
				check.checkInputZh(textField, lblNewLabel_3);//�˺��ж�
				check.checkInputMm(passwordField, lblNewLabel_3_1);//�����ж�
				check.checkInputMm(passwordField_1, lblNewLabel_3_2);//�������ж�
				while(!check.checkInputZh(textField, lblNewLabel_3)||!check.checkInputMm(passwordField, lblNewLabel_3_1)||!check.checkInputMm(passwordField_1, lblNewLabel_3_2)) {//���ж��˺������Ϊ��ʱ��ֱֹ�ӽ���
					JOptionPane.showMessageDialog(null, "�������˺Ż�����");
					break;
				}
				while(check.checkInputZh(textField, lblNewLabel_3)&&check.checkInputMm(passwordField, lblNewLabel_3_1)&&check.checkInputMm(passwordField_1, lblNewLabel_3_2)) {
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
					break;
				}
			}
		});//�޸İ�ť�¼�
		btnNewButton.setBounds(112, 189, 93, 37);
		getContentPane().add(btnNewButton);
		

		


	}
}
