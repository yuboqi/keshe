package mainJF;

import java.awt.EventQueue;
//����Աע�����
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

	private static JFg03 jf001 = null;//�����Ӵ���Ϊ˽��
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	//��̬����������ֻ����һ������synchronized��֤�̰߳���
	public static synchronized JFg03 getInstance() {
		if (jf001 == null) {
			jf001 = new JFg03 ();
		}
		return jf001;
}

	private JFg03() {
		setClosable(true);
		setTitle("����Աע��");
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
		getContentPane().add(passwordField_1);//ȷ�������
		
		JLabel lblNewLabel_2 = new JLabel("ע����֤��");
		lblNewLabel_2.setBounds(40, 149, 63, 54);
		getContentPane().add(lblNewLabel_2);//ע����֤��
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(98, 158, 157, 37);
		getContentPane().add(textField_1);//ע���������
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(278, 9, 146, 37);
		getContentPane().add(lblNewLabel_3);//�˺�������ʾ��
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(278, 57, 146, 37);
		getContentPane().add(lblNewLabel_3_1);//����������ʾ��
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setBounds(278, 111, 146, 37);
		getContentPane().add(lblNewLabel_3_2);//ȷ������������ʾ��
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setBounds(278, 158, 146, 37);
		getContentPane().add(lblNewLabel_3_3);//ע����֤��������ʾ��
		
		
		JButton btnNewButton = new JButton("ע��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s="123";
				Check check=new Check();
				check.checkInputZh(textField, lblNewLabel_3);
				check.checkInputMm(passwordField, lblNewLabel_3_1);
				check.checkInputMm(passwordField_1, lblNewLabel_3_2);
				//check.checkInputzcm(textField_1, lblNewLabel_3_3);//�ж�ע������
				int shuchu=panduan(textField.getText());
				while(textField_1.getText()==s) {
					JOptionPane.showMessageDialog(null, "��֤�����");
					break;
				}
				while(textField_1.getText()!=s) {
					if(shuchu==0)
						{JOptionPane.showMessageDialog(null, "���˺��ѱ�ע��");
						break;}
					if(shuchu==1) {
						addZH(textField.getText(),textField.getText());//�߽����ݼ����ı��ĵ�
						JOptionPane.showMessageDialog(null, "ע��ɹ�");
						break;
					}
					
				}
				
			}
		});//ע�ᰴť�¼�
		btnNewButton.setBounds(114, 205, 93, 37);
		getContentPane().add(btnNewButton);
		
	}
	
	public static void addZH(String zh,String xm) {//����zhΪ�˺�
		File f=new File("f:/eclipse/guanli.txt");
		  try(FileReader fr=new FileReader(f);
		      FileWriter fw=new FileWriter(f,true);){
		    fw.write(zh+"\t");
		    fw.write(xm+"\t");
		    fw.write(0+"\r");
		 
		  }catch(Exception e1) {e1.printStackTrace();}
		  
		}//��������ı��ĵ�

	public static int panduan(String zh) {//����zhΪ�˺�
		File f=new File("f:/eclipse/guanli.txt");
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


