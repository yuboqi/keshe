//package mainJF;
//
//import java.awt.EventQueue;
////����Ա�޸��������
//import javax.swing.JInternalFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import javax.swing.JPasswordField;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
//public class JFg02 extends JInternalFrame {
//	private JTextField textField;
//	private JPasswordField passwordField;
//
//	private static JFg02 jf001 = null;//�����Ӵ���Ϊ˽��
//	private JPasswordField passwordField_1;
//	//��̬����������ֻ����һ������synchronized��֤�̰߳���
//	public static synchronized JFg02 getInstance() {
//		if (jf001 == null) {
//			jf001 = new JFg02 ();
//		}
//		return jf001;
//}
//
//	private JFg02() {
//		setClosable(true);
//		setTitle("�޸�����");
//		setBounds(100, 100, 450, 300);
//		getContentPane().setLayout(null);//�޸�����
//		
//		JLabel lblNewLabel = new JLabel("�˺�");
//		lblNewLabel.setBounds(40, 0, 63, 54);
//		getContentPane().add(lblNewLabel);//�˺�
//		
//		textField = new JTextField();
//		textField.setBounds(98, 9, 157, 37);
//		getContentPane().add(textField);
//		textField.setColumns(10);//�˺������
//		
//		JLabel lblNewLabel_1 = new JLabel("ԭ����");
//		lblNewLabel_1.setBounds(40, 47, 63, 54);
//		getContentPane().add(lblNewLabel_1);//ԭ����
//		
//		passwordField = new JPasswordField();
//		passwordField.setBounds(98, 56, 157, 38);
//		getContentPane().add(passwordField);//���������
//		
//		JLabel lblNewLabel_1_1 = new JLabel("������");
//		lblNewLabel_1_1.setBounds(40, 100, 63, 54);
//		getContentPane().add(lblNewLabel_1_1);//ȷ��������
//		
//		passwordField_1 = new JPasswordField();
//		passwordField_1.setBounds(98, 111, 157, 38);
//		getContentPane().add(passwordField_1);//�����������
//		
//		JLabel lblNewLabel_2 = new JLabel("");
//		lblNewLabel_2.setBounds(278, 9, 133, 37);
//		getContentPane().add(lblNewLabel_2);//�˺���ʾ��
//		
//		JLabel lblNewLabel_2_1 = new JLabel("");
//		lblNewLabel_2_1.setBounds(278, 57, 133, 37);
//		getContentPane().add(lblNewLabel_2_1);//ԭ������ʾ��
//		
//		JLabel lblNewLabel_2_2 = new JLabel("");
//		lblNewLabel_2_2.setBounds(278, 111, 133, 37);
//		getContentPane().add(lblNewLabel_2_2);//��������ʾ��
//		
//		
//		JButton btnNewButton = new JButton("�޸�");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Check check=new Check();
//				check.checkInputZh(textField, lblNewLabel_2);
//				check.checkInputMm(passwordField, lblNewLabel_2_1);
//				check.checkInputMm(passwordField_1, lblNewLabel_2_2);//�ж��Ƿ�Ϊ��
//			}
//		});//�޸İ�ť�¼�
//		btnNewButton.setBounds(108, 159, 93, 37);
//		getContentPane().add(btnNewButton);
//		
//
//
//
//	}
//}
