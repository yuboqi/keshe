package mainJF;

import java.awt.EventQueue;
//用户修改密码界面
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

	private static JF003 jf001 = null;//定义子窗体为私有
	private JPasswordField passwordField_1;
	//静态公开方法，只产生一个对象，synchronized保证线程案例
	public static synchronized JF003 getInstance() {
		if (jf001 == null) {
			jf001 = new JF003 ();
		}
		return jf001;
}

	private JF003() {
		setClosable(true);
		setTitle("修改密码");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);//修改密码
		
		JLabel lblNewLabel = new JLabel("账号");
		lblNewLabel.setBounds(40, 0, 63, 54);
		getContentPane().add(lblNewLabel);//账号
		
		textField = new JTextField();
		textField.setBounds(98, 9, 157, 37);
		getContentPane().add(textField);
		textField.setColumns(10);//账号输入框
		
		JLabel lblNewLabel_1 = new JLabel("原密码");
		lblNewLabel_1.setBounds(40, 47, 63, 54);
		getContentPane().add(lblNewLabel_1);//原密码
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 56, 157, 38);
		getContentPane().add(passwordField);//密码输入框
		
		JLabel lblNewLabel_1_1 = new JLabel("新密码");
		lblNewLabel_1_1.setBounds(40, 100, 63, 54);
		getContentPane().add(lblNewLabel_1_1);//确认新密码
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(98, 111, 157, 38);
		getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(265, 10, 159, 36);
		getContentPane().add(lblNewLabel_3);//账号输入提示框
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(265, 58, 159, 36);
		getContentPane().add(lblNewLabel_3_1);//原密码输入提示框
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setBounds(265, 113, 159, 36);
		getContentPane().add(lblNewLabel_3_2);//新密码输入提示框
		
		
		
		JButton btnNewButton = new JButton("修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Check check=new Check();
				check.checkInputZh(textField, lblNewLabel_3);//账号判断
				check.checkInputMm(passwordField, lblNewLabel_3_1);//密码判断
				check.checkInputMm(passwordField_1, lblNewLabel_3_2);//新密码判断
				while(!check.checkInputZh(textField, lblNewLabel_3)||!check.checkInputMm(passwordField, lblNewLabel_3_1)||!check.checkInputMm(passwordField_1, lblNewLabel_3_2)) {//当判断账号密码框为空时防止直接进入
					JOptionPane.showMessageDialog(null, "请输入账号或密码");
					break;
				}
				while(check.checkInputZh(textField, lblNewLabel_3)&&check.checkInputMm(passwordField, lblNewLabel_3_1)&&check.checkInputMm(passwordField_1, lblNewLabel_3_2)) {
					JOptionPane.showMessageDialog(null, "修改成功");
					break;
				}
			}
		});//修改按钮事件
		btnNewButton.setBounds(112, 189, 93, 37);
		getContentPane().add(btnNewButton);
		

		


	}
}
