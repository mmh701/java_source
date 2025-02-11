package pack4extends;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex23FrameInterface extends Frame implements WindowListener, MouseListener{
	public Ex23FrameInterface() {
		super.setTitle("이벤트 처리 창");
		
		setSize(400, 300);
		setLocation(200,200);
		setVisible(true);
		
		// 윈도우 관련 이벤트 처리를 하려면 윈도우 리스너를 Frame에 장착
		super.addWindowListener(this);
		// 마우스 관련 이벤트 처리를 하려면 마우스 리스너를 Frame에 장착
		addMouseListener(this);
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("윈도우 종료 처리 메소드");
		System.exit(0); // 응용 프로그램의 강제 종료
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
	}
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}
	// 마우스 이벤트 관련
	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("mouseClicked 메소드 수행");
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		setBackground(new Color(r, g, b));
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	
	public static void main(String[] args) {
		//Ex23FrameInterface frameInterface = new Ex23FrameInterface();
		new Ex23FrameInterface();
		
	}
}
