package mainJF;

import java.awt.EventQueue;
//�û���¼����
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


	private static JF001 jf001 = null;//�����Ӵ���Ϊ˽��
	//��̬����������ֻ����һ������synchronized��֤�̰߳���
	public static synchronized JF001 getInstance() {
		if (jf001 == null) {
			jf001 = new JF001 ();
		}
		return jf001;
}

	private JF001() {
		setClosable(true);
		setTitle("���봰��");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);//���봰��
		
		JLabel lblNewLabel = new JLabel("�˺�");
		lblNewLabel.setBounds(40, 21, 63, 54);
		getContentPane().add(lblNewLabel);//�˺�
		
		textField = new JTextField();
		textField.setBounds(98, 30, 157, 37);
		getContentPane().add(textField);
		textField.setColumns(10);//�˺������
		

		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(260, 30, 164, 37);
		getContentPane().add(lblNewLabel_3);//�˺�������ʾ��
		
		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setBounds(40, 88, 63, 54);
		getContentPane().add(lblNewLabel_1);//����
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 97, 157, 38);
		getContentPane().add(passwordField);//���������
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(265, 97, 159, 35);
		getContentPane().add(lblNewLabel_2);//����������ʾ��
		
		
		JButton btnNewButton = new JButton("��¼");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				check.checkInputZh(textField, lblNewLabel_3);//����check���෽���ж��˺��Ƿ�Ϊ��
				check.checkInputMm(passwordField, lblNewLabel_2);//����Check�෽���ж������Ƿ�Ϊ��
				int shuchu=panduan(textField.getText());
				while(!check.checkInputZh(textField, lblNewLabel_3)||!check.checkInputMm(passwordField, lblNewLabel_2)) {//���ж��˺������Ϊ��ʱ��ֱֹ�ӽ���
					JOptionPane.showMessageDialog(null, "�������˺Ż�����");
					break;
				}
				while(check.checkInputZh(textField, lblNewLabel_3)&&check.checkInputMm(passwordField, lblNewLabel_2)) {
					
					if(shuchu==0) {//������и��˺��������ܽ����´���
						jf001.dispose();//�Զ��ر�
						JF004 jf=new JF004();
						jf.setVisible(true);
						jf.setLocationRelativeTo(null);
						break;
					}

					else {//δ���и��˺����������
						JOptionPane.showMessageDialog(null, "�˺Ż��������");
						break;
					}
				}
			

			}

		});//��¼��ť�¼�
		btnNewButton.setBounds(116, 175, 93, 37);
		getContentPane().add(btnNewButton);

	}
	
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
