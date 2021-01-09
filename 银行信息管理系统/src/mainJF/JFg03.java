package mainJF;

import java.awt.EventQueue;
//管理员注册界面
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
/**
 * 
 * @author 22476
 *
 */
public class JFg03 extends JInternalFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	private static JFg03 jf001 = null;//定义子窗体为私有
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	//静态公开方法，只产生一个对象，synchronized保证线程案例
	public static synchronized JFg03 getInstance() {
		if (jf001 == null) {
			jf001 = new JFg03 ();
		}
		return jf001;
}

	private JFg03() {
		setClosable(true);
		setTitle("管理员注册");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);//注册窗口
		
		JLabel lblNewLabel = new JLabel("账号");
		lblNewLabel.setBounds(40, 0, 63, 54);
		getContentPane().add(lblNewLabel);//账号
		
		textField = new JTextField();
		textField.setBounds(98, 9, 157, 37);
		getContentPane().add(textField);
		textField.setColumns(10);//账号输入框
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setBounds(40, 47, 63, 54);
		getContentPane().add(lblNewLabel_1);//密码
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 56, 157, 38);
		getContentPane().add(passwordField);//密码输入框
		
		JLabel lblNewLabel_1_1 = new JLabel("确认密码");
		lblNewLabel_1_1.setBounds(40, 100, 63, 54);
		getContentPane().add(lblNewLabel_1_1);//确认密码
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(98, 111, 157, 38);
		getContentPane().add(passwordField_1);//确认密码框
		
		JLabel lblNewLabel_2 = new JLabel("注册验证码");
		lblNewLabel_2.setBounds(40, 149, 63, 54);
		getContentPane().add(lblNewLabel_2);//注册验证码
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(98, 158, 157, 37);
		getContentPane().add(textField_1);//注册码输入框
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(278, 9, 146, 37);
		getContentPane().add(lblNewLabel_3);//账号输入提示框
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(278, 57, 146, 37);
		getContentPane().add(lblNewLabel_3_1);//密码输入提示框
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setBounds(278, 111, 146, 37);
		getContentPane().add(lblNewLabel_3_2);//确认密码输入提示框
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setBounds(278, 158, 146, 37);
		getContentPane().add(lblNewLabel_3_3);//注册验证码输入提示框
		
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s="123";
				Check check=new Check();
				check.checkInputZh(textField, lblNewLabel_3);
				check.checkInputMm(passwordField, lblNewLabel_3_1);
				check.checkInputMm(passwordField_1, lblNewLabel_3_2);
				//check.checkInputzcm(textField_1, lblNewLabel_3_3);//判断注册码码
				int shuchu=panduan(textField.getText());
				while(textField_1.getText()==s) {
					JOptionPane.showMessageDialog(null, "验证码错误");
					break;
				}
				while(textField_1.getText()!=s) {
					if(shuchu==0)
						{JOptionPane.showMessageDialog(null, "该账号已被注册");
						break;}
					if(shuchu==1) {
						addZH(textField.getText(),textField.getText());//线将数据加入文本文档
						JOptionPane.showMessageDialog(null, "注册成功");
						break;
					}
					
				}
				
			}
		});//注册按钮事件
		btnNewButton.setBounds(114, 205, 93, 37);
		getContentPane().add(btnNewButton);
		
	}
	
	public static void addZH(String zh,String xm) {//参数zh为账号
		File f=new File("f:/eclipse/guanli.txt");
		  try(FileReader fr=new FileReader(f);
		      FileWriter fw=new FileWriter(f,true);){
		    fw.write(zh+"\t");
		    fw.write(xm+"\t");
		    fw.write(0+"\r");
		 
		  }catch(Exception e1) {e1.printStackTrace();}
		  
		}//将其加入文本文档

	public static int panduan(String zh) {//参数zh为账号
		File f=new File("f:/eclipse/guanli.txt");
		int shuchu=1;//赋初值
		  try(FileReader fr=new FileReader(f);
		      FileWriter fw=new FileWriter(f,true);){
		    char[] tmp=new char[1024];
		    int len=0;
		    while((len=fr.read(tmp))!=-1) {
		       if(new String(tmp,0,len).contains(zh)) {//读取的数据中包含学号
		        shuchu=0;
		        break;
		    }}
		 
		  }catch(Exception e1) {e1.printStackTrace();}
		  return shuchu; 
		}//判断是否账号重复
}


