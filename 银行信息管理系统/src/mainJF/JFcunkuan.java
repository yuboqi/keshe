package mainJF;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import connection.DatabaseConnection;
import Dao.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
public class JFcunkuan extends JFrame {//�û�����

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFcunkuan frame = new JFcunkuan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFcunkuan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("����Ҫ�������Ϊ��");
		lblNewLabel.setBounds(109, 23, 195, 36);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(109, 69, 146, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(262, 69, 146, 34);
		contentPane.add(lblNewLabel_1);//��ʾ��
		
		JLabel lblNewLabel_2 = new JLabel("�˺�");
		lblNewLabel_2.setBounds(109, 113, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(109, 140, 146, 34);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("���");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Check check=new Check();
				while(check.checkInputCk(textField, lblNewLabel_1)) {
					check.checkInputCk(textField, lblNewLabel_1);
					DatabaseConnection dbcs=new DatabaseConnection();//�������ݿ���
					Connection conn=dbcs.getConnection();//��ȡ���ݿ��
					String sql = "select ye from scj where zh=?"; //sql���
					String sql2 = "update scj set ye=? where zh=?"; 
					try {
						PreparedStatement pstmt = conn.prepareStatement(sql);
						PreparedStatement pstmt2 = conn.prepareStatement(sql2);
						pstmt.setString(1,textField_1.getText());
						ResultSet rs=pstmt.executeQuery();
						rs.next();
						pstmt2.setInt(1, Integer.valueOf(rs.getString("ye"))+Integer.valueOf(textField.getText()));//�������˴�������
						pstmt2.setString(2, textField_1.getText());
						int rs2=pstmt2.executeUpdate();
						if(rs2!=0) {
							JOptionPane.showMessageDialog(null, "���ɹ�");
						}
											
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					break;
				}//�������Ϊ�������Ҳ�Ϊ��ʱ���ܴ��ɹ�
				
				
			}
		});
		btnNewButton.setBounds(119, 189, 93, 40);
		contentPane.add(btnNewButton);
		

		

	}
}
