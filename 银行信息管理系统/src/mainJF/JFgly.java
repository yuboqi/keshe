package mainJF;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author 22476
 *
 */
public class JFgly {//����Ա��������

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFgly window = new JFgly();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JFgly() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("��ӭ������Ա");
		frame.setBounds(100, 100, 467, 336);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);// �������
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ʹ�ûᵼ�¹رոô���ʹ���д��ڹر�
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("��ѯ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTable05 fr=new frmTable05();
				fr.setLocationRelativeTo(null);// �������
				fr.setVisible(true);// ����ɼ�
				fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setIcon(new ImageIcon(JFgly.class.getResource("/icon/01.png")));
		btnNewButton.setBounds(167, 66, 93, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("����");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFglyxh xh=new JFglyxh();//������������
				xh.setVisible(true);//�ɼ�
				xh.setLocationRelativeTo(null);//����
				xh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(JFgly.class.getResource("/icon/f8.png")));
		btnNewButton_2.setBounds(167, 150, 93, 40);
		frame.getContentPane().add(btnNewButton_2);
	}

}
