package mainJF;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class UiUtil {
	//�����Ӵ��������ʾ
	public static void setFrameCenter(JInternalFrame jif) {
		Toolkit tk=Toolkit.getDefaultToolkit();//��ȡĬ�Ϲ��߰���
		Dimension d=tk.getScreenSize();//��ȡ��Ļ�ߴ�
		int swidth=d.width;//��ȡ��Ļ���
		int sheight=d.height;//��ȡ��Ļ�߶�
		int x=(swidth-jif.getWidth())/2;//(��Ļ���-�Ӵ�����)/2
		int y=(sheight-jif.getHeight())/2;//(��Ļ�߶�-�Ӵ���߶�)/2
		//�����Ӵ���λ�ã��߶�-70��70�������⡢�˵����͹������ĸ߶�
		jif.setLocation(x, y-65);
	}
	
}
