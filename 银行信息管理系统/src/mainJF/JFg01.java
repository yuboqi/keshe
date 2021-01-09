package mainJF;

import java.awt.EventQueue;
//管理员登录界面
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
 * 
 * @author 22476
 *
 */
public class JFg01 extends JInternalFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	private static JFg01 jf001 = null;//定义子窗体为私有
	//静态公开方法，只产生一个对象，synchronized保证线程案例
	public static synchronized JFg01 getInstance() {
		if (jf001 == null) {
			jf001 = new JFg01 ();
		}
		return jf001;
}

	private JFg01() {
		setClosable(true);
		setTitle("登入窗口");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);//登入窗口
		
		JLabel lblNewLabel = new JLabel("管理员账号");
		lblNewLabel.setBounds(40, 21, 63, 54);
		getContentPane().add(lblNewLabel);//账号
		
		textField = new JTextField();
		textField.setBounds(98, 30, 157, 37);
		getContentPane().add(textField);
		textField.setColumns(10);//账号输入框
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setBounds(40, 88, 63, 54);
		getContentPane().add(lblNewLabel_1);//密码
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 97, 157, 38);
		getContentPane().add(passwordField);//密码输入框
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(278, 30, 146, 37);
		getContentPane().add(lblNewLabel_2);//账号输入提示框
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(278, 98, 146, 37);
		getContentPane().add(lblNewLabel_2_1);//密码提示框
		
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Check check=new Check();
				check.checkInputZh(textField, lblNewLabel_2);
				check.checkInputMm(passwordField, lblNewLabel_2_1);
				int shuchu=panduan(textField.getText());//判断是否有改管理员
				while(!check.checkInputZh(textField, lblNewLabel_2)||!check.checkInputMm(passwordField, lblNewLabel_2_1)) {
					JOptionPane.showMessageDialog(null, "请输入账号或密码");
					break;	
				}
				while(check.checkInputZh(textField, lblNewLabel_2)&&check.checkInputMm(passwordField, lblNewLabel_2_1)) {
					if(shuchu==0) {
						jf001.dispose();//点击登录自动关该界面
						JFgly jg=new JFgly();
						break;
					}
					else {
						JOptionPane.showMessageDialog(null, "未找到该用户");
						break;
					}
				}			
			}
		});//登录按钮事件
		btnNewButton.setBounds(116, 175, 93, 37);
		getContentPane().add(btnNewButton);
		
	}
	
	
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
