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
public class JFgly {//管理员操作界面

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
		frame.setTitle("欢迎您管理员");
		frame.setBounds(100, 100, 467, 336);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);// 窗体居中
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//使用会导致关闭该窗口使所有窗口关闭
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTable05 fr=new frmTable05();
				fr.setLocationRelativeTo(null);// 窗体居中
				fr.setVisible(true);// 窗体可见
				fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setIcon(new ImageIcon(JFgly.class.getResource("/icon/01.png")));
		btnNewButton.setBounds(167, 66, 93, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("销户");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFglyxh xh=new JFglyxh();//创建销户窗体
				xh.setVisible(true);//可见
				xh.setLocationRelativeTo(null);//居中
				xh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(JFgly.class.getResource("/icon/f8.png")));
		btnNewButton_2.setBounds(167, 150, 93, 40);
		frame.getContentPane().add(btnNewButton_2);
	}

}
