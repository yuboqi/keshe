package mainJF;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import connection.DatabaseConnection;
import Dao.DatabaseConnection;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
/**
 * 
 * @author 22476
 *
 */
public class JF004 extends JFrame {//�û���������

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JF004 frame = new JF004();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);//����
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JF004() {
		setTitle("�û���������");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��ֹ�رոô��ڵ��������ڹر�
		setBounds(100, 100, 532, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(102, 22, 159, 51);
		contentPane.add(textField);
		textField.setColumns(10);//�˺������
		
		JLabel lblNewLabel = new JLabel("�˺�");
		lblNewLabel.setBounds(24, 31, 54, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("��ת���˺�");
		lblNewLabel_1.setBounds(26, 121, 83, 33);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(102, 112, 159, 51);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("ת�˽��");
		lblNewLabel_2.setBounds(24, 208, 54, 33);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(102, 195, 159, 51);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("ȡ����");
		lblNewLabel_2_1.setBounds(24, 272, 54, 33);
		contentPane.add(lblNewLabel_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(102, 268, 159, 51);
		contentPane.add(textField_3);	
	
		
		JButton btnNewButton = new JButton("���");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFcunkuan ck=new JFcunkuan();
				ck.setVisible(true);//�ɼ�
				ck.setLocationRelativeTo(null);//����
				ck.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setIcon(new ImageIcon(JF004.class.getResource("/icon/f3.png")));
		btnNewButton.setBounds(351, 180, 93, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ȡ��");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseConnection dbcs=new DatabaseConnection();//�������ݿ���
				Connection conn=dbcs.getConnection();//��ȡ���ݿ��
				String sql = "select ye from scj where zh=?"; //sql���
				String sql2 = "update scj set ye=? where zh=?"; //sql���
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					PreparedStatement pstmt2 = conn.prepareStatement(sql2);
					pstmt.setString(1,textField.getText());
					ResultSet rs=pstmt.executeQuery();
					rs.next();
					pstmt2.setInt(1,Integer.valueOf(rs.getString("ye"))-Integer.valueOf(textField_3.getText()));//��������ȡ�������
					pstmt2.setString(2, textField.getText());
					int rs2=pstmt2.executeUpdate();
					if(rs2!=0) {
						JOptionPane.showMessageDialog(null, "ȡ��ɹ�");
					}
										
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(JF004.class.getResource("/icon/f8.png")));
		btnNewButton_1.setBounds(351, 268, 93, 51);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ת��");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseConnection dbcs=new DatabaseConnection();//�������ݿ���
				Connection conn=dbcs.getConnection();//��ȡ���ݿ��
				String sql = "select ye from scj where zh=?"; //sql���
				String sql2 = "update scj set ye=? where zh=?"; //sql���
				String sql3 = "update scj set ye=? where zh=?"; //sql���
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);//��ѯ
					PreparedStatement pstmt2 = conn.prepareStatement(sql2);//ת���˸���
					PreparedStatement pstmt3 = conn.prepareStatement(sql3);//��ת�˸���
					PreparedStatement pstmt4 = conn.prepareStatement(sql);//��ѯ
					pstmt.setString(1, textField.getText());//�����˺�
					pstmt4.setString(1, textField_1.getText());//���屻ת�����˺�
					ResultSet rs=pstmt.executeQuery();//��ѯת�����˺�
					ResultSet rs4=pstmt4.executeQuery();//��ѯ��ת�����˺�
					rs4.next();
					rs.next();
					pstmt2.setInt(1,Integer.valueOf(rs.getString("ye"))-Integer.valueOf(textField_2.getText()));//���¶���ת���������Ϣ
					pstmt3.setInt(1,Integer.valueOf(rs4.getString("ye"))+Integer.valueOf(textField_2.getText()));//���¶��屻ת���������Ϣ
					pstmt2.setString(2,  textField.getText());//����ת�����˺�
					pstmt3.setString(2,textField_1.getText());//���屻ת�����˺�
					int rs2=pstmt2.executeUpdate();
					int rs3=pstmt3.executeUpdate();
					if(rs2!=0&&rs3!=0) {
						JOptionPane.showMessageDialog(null, "ת�˳ɹ�");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(JF004.class.getResource("/icon/f8.png")));
		btnNewButton_2.setBounds(351, 97, 93, 51);
		contentPane.add(btnNewButton_2);
	
		JButton btnNewButton_3 = new JButton("��ѯ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseConnection dbcs=new DatabaseConnection();//�������ݿ���
				Connection conn=dbcs.getConnection();//��ȡ���ݿ��
				String sql = "select ye from scj where zh=?"; //sql���
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, textField.getText());
					ResultSet rs = pstmt.executeQuery();//��ѯ�����
					rs.next();
					JOptionPane.showMessageDialog(null, "�������Ϊ��"+rs.getString("ye"));//��������
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(JF004.class.getResource("/icon/f5.png")));
		btnNewButton_3.setBounds(351, 22, 93, 51);
		contentPane.add(btnNewButton_3);
		

	}

}
