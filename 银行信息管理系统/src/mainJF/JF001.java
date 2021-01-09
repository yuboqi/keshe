package mainJF;

import java.awt.EventQueue;
//用户登录界面
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
/**
 * 
 * @author 22476
 *
 */
public class JF001 extends JInternalFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private JDesktopPane desktopPane;
	
	static Check check=new Check();


	private static JF001 jf001 = null;//定义子窗体为私有
	//静态公开方法，只产生一个对象，synchronized保证线程案例
	public static synchronized JF001 getInstance() {
		if (jf001 == null) {
			jf001 = new JF001 ();
		}
		return jf001;
}

	private JF001() {
		setClosable(true);
		setTitle("登入窗口");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);//登入窗口
		
		JLabel lblNewLabel = new JLabel("账号");
		lblNewLabel.setBounds(40, 21, 63, 54);
		getContentPane().add(lblNewLabel);//账号
		
		textField = new JTextField();
		textField.setBounds(98, 30, 157, 37);
		getContentPane().add(textField);
		textField.setColumns(10);//账号输入框
		

		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(260, 30, 164, 37);
		getContentPane().add(lblNewLabel_3);//账号输入提示框
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setBounds(40, 88, 63, 54);
		getContentPane().add(lblNewLabel_1);//密码
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 97, 157, 38);
		getContentPane().add(passwordField);//密码输入框
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(265, 97, 159, 35);
		getContentPane().add(lblNewLabel_2);//密码输入提示框
		
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				check.checkInputZh(textField, lblNewLabel_3);//调用check的类方法判断账号是否为空
				check.checkInputMm(passwordField, lblNewLabel_2);//调用Check类方法判断密码是否为空
				int shuchu=panduan(textField.getText());
				while(!check.checkInputZh(textField, lblNewLabel_3)||!check.checkInputMm(passwordField, lblNewLabel_2)) {//当判断账号密码框为空时防止直接进入
					JOptionPane.showMessageDialog(null, "请输入账号或密码");
					break;
				}
				while(check.checkInputZh(textField, lblNewLabel_3)&&check.checkInputMm(passwordField, lblNewLabel_2)) {
					
					if(shuchu==0) {//如果含有改账号密码则能进入新窗口
						jf001.dispose();//自动关闭
						JF004 jf=new JF004();
						jf.setVisible(true);
						jf.setLocationRelativeTo(null);
						break;
					}

					else {//未含有改账号则输出错误
						JOptionPane.showMessageDialog(null, "账号或密码错误");
						break;
					}
				}
			

			}

		});//登录按钮事件
		btnNewButton.setBounds(116, 175, 93, 37);
		getContentPane().add(btnNewButton);

	}
	
	public static int panduan(String zh) {//参数zh为账号
		File f=new File("f:/eclipse/kehu.txt");
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
