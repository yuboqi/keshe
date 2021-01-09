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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
/**
 * 
 * @author 22476
 *
 */
public class JFglyxh extends JFrame {//��������

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFglyxh frame = new JFglyxh();
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
	public JFglyxh() {
		setTitle("����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�û��˺ţ�");
		lblNewLabel.setBounds(30, 45, 88, 42);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(109, 45, 303, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("�û����룺");
		lblNewLabel_1.setBounds(30, 142, 88, 42);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(112, 143, 300, 42);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("ȷ������");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseConnection dbcs=new DatabaseConnection();//�������ݿ���
				Connection conn=dbcs.getConnection();//��ȡ���ݿ��
				String sql = "delete from scj where zh=?"; //sql���
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, textField.getText());
					int rs=pstmt.executeUpdate();
					if(rs==0) {
						JOptionPane.showMessageDialog(null, "�����ɹ�");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton.setBounds(170, 232, 93, 42);
		contentPane.add(btnNewButton);
	}
}
