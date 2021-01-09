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
		// 当前系统的风格
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
					//window.frmXx.setResizable(false);//主窗口是否可以小化
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
		frmXx.setIconImage(Toolkit.getDefaultToolkit().getImage(Frame01.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-more-details@2x.png")));//主窗口小图标
		frmXx.setTitle("XX银行欢迎您");//主窗口名称：欢迎语
		frmXx.setBounds(100, 100, 735, 545);
		frmXx.setExtendedState(JFrame.MAXIMIZED_BOTH);//窗口最大化
		frmXx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("source/icon"+File.separator+"001.jpg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};

		frmXx.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frmXx.setJMenuBar(menuBar);//主菜单框
		
		JMenu mnNewMenu = new JMenu("用户登录");
		menuBar.add(mnNewMenu);//用户登录菜单
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("登录");//用户登录按钮
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayJInternalFrame(JF001.getInstance());//创建子窗口并调用防止重复方法
				
			}
		});
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmNewMenuItem_3.setIcon(new ImageIcon(Frame01.class.getResource("/icon/f8.png")));
		mnNewMenu.add(mntmNewMenuItem_3);//用户登录
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("注册");//用户注册按钮
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayJInternalFrame(JF002.getInstance());//创建子窗口并调用防止重复方法
			}
		});
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mntmNewMenuItem_2.setIcon(new ImageIcon(Frame01.class.getResource("/icon/f5.png")));
		mnNewMenu.add(mntmNewMenuItem_2);//用户注册
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("修改密码");//用户修改密码按钮
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayJInternalFrame(JF003.getInstance());//创建子窗口并调用防止重复方法
			}
		});
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mntmNewMenuItem_1.setIcon(new ImageIcon(Frame01.class.getResource("/icon/f3.png")));
		mnNewMenu.add(mntmNewMenuItem_1);//用户修改密码
		
		JMenu mnNewMenu_1 = new JMenu("管理员登录");
		menuBar.add(mnNewMenu_1);//管理员登录菜单
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("登录");//管理员登录按钮
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayJInternalFrame(JFg01.getInstance());//创建子窗口并调用防止重复方法
				
			}
		});
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmNewMenuItem_4.setIcon(new ImageIcon(Frame01.class.getResource("/icon/f5.png")));
		mnNewMenu_1.add(mntmNewMenuItem_4);//管理员登录
		
//		JMenuItem mntmNewMenuItem = new JMenuItem("修改密码");//管理员修改密码按钮
//		mntmNewMenuItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				displayJInternalFrame(JFg02.getInstance());//创建子窗口并调用防止重复方法
//			}
//		});
//		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
//		mntmNewMenuItem.setIcon(new ImageIcon(Frame01.class.getResource("/icon/f8.png")));
//		mnNewMenu_1.add(mntmNewMenuItem);//管理员修改密码
		
		JMenu mnNewMenu_2 = new JMenu("管理员注册");
		menuBar.add(mnNewMenu_2);//管理员注册菜单
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("注册");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayJInternalFrame(JFg03.getInstance());//创建子窗口并调用防止重复方法
				
			}
		});
		mntmNewMenuItem_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mntmNewMenuItem_5.setIcon(new ImageIcon(Frame01.class.getResource("/icon/f3.png")));
		mnNewMenu_2.add(mntmNewMenuItem_5);//管理员注册

	}
	public void displayJInternalFrame(JInternalFrame jif) {//子窗体不重复出现方法
		JInternalFrame jifl[]=desktopPane.getAllFrames();
		//判断顶层面板中是否已经存在需要调用的子窗体
		if(jifl.length>0) 	return;//防止同时出现两个不同窗体
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
