package mainJF;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.print.attribute.standard.Destination;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author 22476
 *
 */
public class Frame01 {

	private JFrame frmXx;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// ��ǰϵͳ�ķ��
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame01 window = new Frame01();
					window.frmXx.setVisible(true);
					//window.frmXx.setResizable(false);//�������Ƿ����С��
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmXx = new JFrame();
		frmXx.setIconImage(Toolkit.getDefaultToolkit().getImage(Frame01.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-more-details@2x.png")));//������Сͼ��
		frmXx.setTitle("XX���л�ӭ��");//���������ƣ���ӭ��
		frmXx.setBounds(100, 100, 735, 545);
		frmXx.setExtendedState(JFrame.MAXIMIZED_BOTH);//�������
		frmXx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("source/icon"+File.separator+"001.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};

		frmXx.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frmXx.setJMenuBar(menuBar);//���˵���
		
		JMenu mnNewMenu = new JMenu("�û���¼");
		menuBar.add(mnNewMenu);//�û���¼�˵�
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("��¼");//�û���¼��ť
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayJInternalFrame(JF001.getInstance());//�����Ӵ��ڲ����÷�ֹ�ظ�����
				
			}
		});
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmNewMenuItem_3.setIcon(new ImageIcon(Frame01.class.getResource("/icon/f8.png")));
		mnNewMenu.add(mntmNewMenuItem_3);//�û���¼
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("ע��");//�û�ע�ᰴť
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayJInternalFrame(JF002.getInstance());//�����Ӵ��ڲ����÷�ֹ�ظ�����
			}
		});
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mntmNewMenuItem_2.setIcon(new ImageIcon(Frame01.class.getResource("/icon/f5.png")));
		mnNewMenu.add(mntmNewMenuItem_2);//�û�ע��
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("�޸�����");//�û��޸����밴ť
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayJInternalFrame(JF003.getInstance());//�����Ӵ��ڲ����÷�ֹ�ظ�����
			}
		});
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mntmNewMenuItem_1.setIcon(new ImageIcon(Frame01.class.getResource("/icon/f3.png")));
		mnNewMenu.add(mntmNewMenuItem_1);//�û��޸�����
		
		JMenu mnNewMenu_1 = new JMenu("����Ա��¼");
		menuBar.add(mnNewMenu_1);//����Ա��¼�˵�
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("��¼");//����Ա��¼��ť
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayJInternalFrame(JFg01.getInstance());//�����Ӵ��ڲ����÷�ֹ�ظ�����
				
			}
		});
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmNewMenuItem_4.setIcon(new ImageIcon(Frame01.class.getResource("/icon/f5.png")));
		mnNewMenu_1.add(mntmNewMenuItem_4);//����Ա��¼
		
//		JMenuItem mntmNewMenuItem = new JMenuItem("�޸�����");//����Ա�޸����밴ť
//		mntmNewMenuItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				displayJInternalFrame(JFg02.getInstance());//�����Ӵ��ڲ����÷�ֹ�ظ�����
//			}
//		});
//		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
//		mntmNewMenuItem.setIcon(new ImageIcon(Frame01.class.getResource("/icon/f8.png")));
//		mnNewMenu_1.add(mntmNewMenuItem);//����Ա�޸�����
		
		JMenu mnNewMenu_2 = new JMenu("����Աע��");
		menuBar.add(mnNewMenu_2);//����Աע��˵�
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("ע��");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayJInternalFrame(JFg03.getInstance());//�����Ӵ��ڲ����÷�ֹ�ظ�����
				
			}
		});
		mntmNewMenuItem_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mntmNewMenuItem_5.setIcon(new ImageIcon(Frame01.class.getResource("/icon/f3.png")));
		mnNewMenu_2.add(mntmNewMenuItem_5);//����Աע��

	}
	public void displayJInternalFrame(JInternalFrame jif) {//�Ӵ��岻�ظ����ַ���
		JInternalFrame jifl[]=desktopPane.getAllFrames();
		//�ж϶���������Ƿ��Ѿ�������Ҫ���õ��Ӵ���
		if(jifl.length>0) 	return;//��ֹͬʱ����������ͬ����
		desktopPane.add(jif);
		jif.setVisible(true);
		UiUtil.setFrameCenter(jif);
		try {
			jif.setSelected(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}
	}
	



}
