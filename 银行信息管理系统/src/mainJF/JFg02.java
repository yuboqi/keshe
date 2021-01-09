//package mainJF;
//
//import java.awt.EventQueue;
////管理员修改密码界面
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
//	private static JFg02 jf001 = null;//定义子窗体为私有
//	private JPasswordField passwordField_1;
//	//静态公开方法，只产生一个对象，synchronized保证线程案例
//	public static synchronized JFg02 getInstance() {
//		if (jf001 == null) {
//			jf001 = new JFg02 ();
//		}
//		return jf001;
//}
//
//	private JFg02() {
//		setClosable(true);
//		setTitle("修改密码");
//		setBounds(100, 100, 450, 300);
//		getContentPane().setLayout(null);//修改密码
//		
//		JLabel lblNewLabel = new JLabel("账号");
//		lblNewLabel.setBounds(40, 0, 63, 54);
//		getContentPane().add(lblNewLabel);//账号
//		
//		textField = new JTextField();
//		textField.setBounds(98, 9, 157, 37);
//		getContentPane().add(textField);
//		textField.setColumns(10);//账号输入框
//		
//		JLabel lblNewLabel_1 = new JLabel("原密码");
//		lblNewLabel_1.setBounds(40, 47, 63, 54);
//		getContentPane().add(lblNewLabel_1);//原密码
//		
//		passwordField = new JPasswordField();
//		passwordField.setBounds(98, 56, 157, 38);
//		getContentPane().add(passwordField);//密码输入框
//		
//		JLabel lblNewLabel_1_1 = new JLabel("新密码");
//		lblNewLabel_1_1.setBounds(40, 100, 63, 54);
//		getContentPane().add(lblNewLabel_1_1);//确认新密码
//		
//		passwordField_1 = new JPasswordField();
//		passwordField_1.setBounds(98, 111, 157, 38);
//		getContentPane().add(passwordField_1);//新密码输入框
//		
//		JLabel lblNewLabel_2 = new JLabel("");
//		lblNewLabel_2.setBounds(278, 9, 133, 37);
//		getContentPane().add(lblNewLabel_2);//账号提示框
//		
//		JLabel lblNewLabel_2_1 = new JLabel("");
//		lblNewLabel_2_1.setBounds(278, 57, 133, 37);
//		getContentPane().add(lblNewLabel_2_1);//原密码提示框
//		
//		JLabel lblNewLabel_2_2 = new JLabel("");
//		lblNewLabel_2_2.setBounds(278, 111, 133, 37);
//		getContentPane().add(lblNewLabel_2_2);//新密码提示框
//		
//		
//		JButton btnNewButton = new JButton("修改");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Check check=new Check();
//				check.checkInputZh(textField, lblNewLabel_2);
//				check.checkInputMm(passwordField, lblNewLabel_2_1);
//				check.checkInputMm(passwordField_1, lblNewLabel_2_2);//判断是否为空
//			}
//		});//修改按钮事件
//		btnNewButton.setBounds(108, 159, 93, 37);
//		getContentPane().add(btnNewButton);
//		
//
//
//
//	}
//}
