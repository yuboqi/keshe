package mainJF;

import java.awt.EventQueue;
//����Ա��¼����
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

	private static JFg01 jf001 = null;//�����Ӵ���Ϊ˽��
	//��̬����������ֻ����һ������synchronized��֤�̰߳���
	public static synchronized JFg01 getInstance() {
		if (jf001 == null) {
			jf001 = new JFg01 ();
		}
		return jf001;
}

	private JFg01() {
		setClosable(true);
		setTitle("���봰��");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);//���봰��
		
		JLabel lblNewLabel = new JLabel("����Ա�˺�");
		lblNewLabel.setBounds(40, 21, 63, 54);
		getContentPane().add(lblNewLabel);//�˺�
		
		textField = new JTextField();
		textField.setBounds(98, 30, 157, 37);
		getContentPane().add(textField);
		textField.setColumns(10);//�˺������
		
		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setBounds(40, 88, 63, 54);
		getContentPane().add(lblNewLabel_1);//����
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 97, 157, 38);
		getContentPane().add(passwordField);//���������
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(278, 30, 146, 37);
		getContentPane().add(lblNewLabel_2);//�˺�������ʾ��
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(278, 98, 146, 37);
		getContentPane().add(lblNewLabel_2_1);//������ʾ��
		
		
		JButton btnNewButton = new JButton("��¼");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Check check=new Check();
				check.checkInputZh(textField, lblNewLabel_2);
				check.checkInputMm(passwordField, lblNewLabel_2_1);
				int shuchu=panduan(textField.getText());//�ж��Ƿ��иĹ���Ա
				while(!check.checkInputZh(textField, lblNewLabel_2)||!check.checkInputMm(passwordField, lblNewLabel_2_1)) {
					JOptionPane.showMessageDialog(null, "�������˺Ż�����");
					break;	
				}
				while(check.checkInputZh(textField, lblNewLabel_2)&&check.checkInputMm(passwordField, lblNewLabel_2_1)) {
					if(shuchu==0) {
						jf001.dispose();//�����¼�Զ��ظý���
						JFgly jg=new JFgly();
						break;
					}
					else {
						JOptionPane.showMessageDialog(null, "δ�ҵ����û�");
						break;
					}
				}			
			}
		});//��¼��ť�¼�
		btnNewButton.setBounds(116, 175, 93, 37);
		getContentPane().add(btnNewButton);
		
	}
	
	
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
