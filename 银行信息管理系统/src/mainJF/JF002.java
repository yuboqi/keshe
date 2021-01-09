package mainJF;

import java.awt.EventQueue;
//用户注册界面
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//import connection.DatabaseConnection;
import Dao.DatabaseConnection;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
/**
 * 
 * @author 22476
 *
 */
public class JF002 extends JInternalFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	private static JF002 jf001 = null;//定义子窗体为私有
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	
	//静态公开方法，只产生一个对象，synchronized保证线程案例
	public static synchronized JF002 getInstance() {
		if (jf001 == null) {
			jf001 = new JF002 ();
		}
		return jf001;
}

	private JF002() {
		setClosable(true);
		setTitle("用户注册");
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
		getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(265, 9, 159, 37);
		getContentPane().add(lblNewLabel_3);//账号输入提示框
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(265, 57, 159, 37);
		getContentPane().add(lblNewLabel_3_1);//密码注册提示框
		
		JLabel lblNewLabel_3_2_1 = new JLabel("");
		lblNewLabel_3_2_1.setBounds(265, 112, 159, 37);
		getContentPane().add(lblNewLabel_3_2_1);//确认密码提示框
		
		JLabel lblNewLabel_1_1_1 = new JLabel("姓名:");
		lblNewLabel_1_1_1.setBounds(40, 155, 63, 54);
		getContentPane().add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(98, 164, 157, 37);
		getContentPane().add(textField_1);//姓名输入框
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("");
		lblNewLabel_3_2_1_1.setBounds(265, 172, 159, 37);
		getContentPane().add(lblNewLabel_3_2_1_1);//姓名提示框
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			File f=new File("f:/eclipse/kehu.txt");
			public void actionPerformed(ActionEvent e) {
				Check check=new Check();
				check.checkInputZh(textField, lblNewLabel_3);
				check.checkInputMm(passwordField, lblNewLabel_3_1);
				check.checkInputMm(passwordField_1, lblNewLabel_3_2_1);
				check.checkInputxm(textField_1, lblNewLabel_3_2_1_1);
				int shuchu=panduan(textField.getText());//将判断结果传递给输出
				if(shuchu==0)
					{JOptionPane.showMessageDialog(null, "该账号已被注册");}
				else {
					addZH(textField.getText(),textField_1.getText());//线将数据加入文本文档
					DatabaseConnection dbcs=new DatabaseConnection();//定义数据库类
					Connection conn=dbcs.getConnection();//获取数据库接
					String sql = "insert into scj values(?,?,?)";
					try {
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, textField.getText());
						pstmt.setString(2, textField_1.getText());
						pstmt.setString(3, "0");
						int rs=pstmt.executeUpdate();
						if(rs!=0) {
							JOptionPane.showMessageDialog(null, "注册成功");
							
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					}
			}
		});//注册按钮事件
		btnNewButton.setBounds(108, 211, 93, 37);
		getContentPane().add(btnNewButton);
		

	
	}
	public static void addZH(String zh,String xm) {//参数zh为账号
		File f=new File("f:/eclipse/kehu.txt");
		  try(FileReader fr=new FileReader(f);
		      FileWriter fw=new FileWriter(f,true);){
		    fw.write(zh+"\t");
		    fw.write(xm+"\t");
		    fw.write(0+"\r");
		 
		  }catch(Exception e1) {e1.printStackTrace();}
		  
		}//将其加入文本文档

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
