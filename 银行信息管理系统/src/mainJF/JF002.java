package mainJF;

import java.awt.EventQueue;
//�û�ע�����
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

	private static JF002 jf001 = null;//�����Ӵ���Ϊ˽��
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	
	//��̬����������ֻ����һ������synchronized��֤�̰߳���
	public static synchronized JF002 getInstance() {
		if (jf001 == null) {
			jf001 = new JF002 ();
		}
		return jf001;
}

	private JF002() {
		setClosable(true);
		setTitle("�û�ע��");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);//ע�ᴰ��
		
		JLabel lblNewLabel = new JLabel("�˺�");
		lblNewLabel.setBounds(40, 0, 63, 54);
		getContentPane().add(lblNewLabel);//�˺�
		
		textField = new JTextField();
		textField.setBounds(98, 9, 157, 37);
		getContentPane().add(textField);
		textField.setColumns(10);//�˺������
		
		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setBounds(40, 47, 63, 54);
		getContentPane().add(lblNewLabel_1);//����
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 56, 157, 38);
		getContentPane().add(passwordField);//���������
		
		JLabel lblNewLabel_1_1 = new JLabel("ȷ������");
		lblNewLabel_1_1.setBounds(40, 100, 63, 54);
		getContentPane().add(lblNewLabel_1_1);//ȷ������
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(98, 111, 157, 38);
		getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(265, 9, 159, 37);
		getContentPane().add(lblNewLabel_3);//�˺�������ʾ��
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(265, 57, 159, 37);
		getContentPane().add(lblNewLabel_3_1);//����ע����ʾ��
		
		JLabel lblNewLabel_3_2_1 = new JLabel("");
		lblNewLabel_3_2_1.setBounds(265, 112, 159, 37);
		getContentPane().add(lblNewLabel_3_2_1);//ȷ��������ʾ��
		
		JLabel lblNewLabel_1_1_1 = new JLabel("����:");
		lblNewLabel_1_1_1.setBounds(40, 155, 63, 54);
		getContentPane().add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(98, 164, 157, 37);
		getContentPane().add(textField_1);//���������
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("");
		lblNewLabel_3_2_1_1.setBounds(265, 172, 159, 37);
		getContentPane().add(lblNewLabel_3_2_1_1);//������ʾ��
		
		JButton btnNewButton = new JButton("ע��");
		btnNewButton.addActionListener(new ActionListener() {
			File f=new File("f:/eclipse/kehu.txt");
			public void actionPerformed(ActionEvent e) {
				Check check=new Check();
				check.checkInputZh(textField, lblNewLabel_3);
				check.checkInputMm(passwordField, lblNewLabel_3_1);
				check.checkInputMm(passwordField_1, lblNewLabel_3_2_1);
				check.checkInputxm(textField_1, lblNewLabel_3_2_1_1);
				int shuchu=panduan(textField.getText());//���жϽ�����ݸ����
				if(shuchu==0)
					{JOptionPane.showMessageDialog(null, "���˺��ѱ�ע��");}
				else {
					addZH(textField.getText(),textField_1.getText());//�߽����ݼ����ı��ĵ�
					DatabaseConnection dbcs=new DatabaseConnection();//�������ݿ���
					Connection conn=dbcs.getConnection();//��ȡ���ݿ��
					String sql = "insert into scj values(?,?,?)";
					try {
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, textField.getText());
						pstmt.setString(2, textField_1.getText());
						pstmt.setString(3, "0");
						int rs=pstmt.executeUpdate();
						if(rs!=0) {
							JOptionPane.showMessageDialog(null, "ע��ɹ�");
							
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					}
			}
		});//ע�ᰴť�¼�
		btnNewButton.setBounds(108, 211, 93, 37);
		getContentPane().add(btnNewButton);
		

	
	}
	public static void addZH(String zh,String xm) {//����zhΪ�˺�
		File f=new File("f:/eclipse/kehu.txt");
		  try(FileReader fr=new FileReader(f);
		      FileWriter fw=new FileWriter(f,true);){
		    fw.write(zh+"\t");
		    fw.write(xm+"\t");
		    fw.write(0+"\r");
		 
		  }catch(Exception e1) {e1.printStackTrace();}
		  
		}//��������ı��ĵ�

	public static int panduan(String zh) {//����zhΪ�˺�
		File f=new File("f:/eclipse/kehu.txt");
		int shuchu=1;//����ֵ
		  try(FileReader fr=new FileReader(f);
		      FileWriter fw=new FileWriter(f,true);){
		    char[] tmp=new char[1024];
		    int len=0;
		    while((len=fr.read(tmp))!=-1) {
		       if(new String(tmp,0,len).contains(zh)) {//��ȡ�������а���ѧ��
		        shuchu=0;
		        break;
		    }}
		 
		  }catch(Exception e1) {e1.printStackTrace();}
		  return shuchu; 
		}//�ж��Ƿ��˺��ظ�
}
