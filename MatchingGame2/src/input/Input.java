package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Input implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener {
	private Cursor cursor;
	
	public Input() {
		cursor = new Cursor();
	}
	
	public Cursor getCursor() {
		return cursor;
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		if (e.getKeyCode()==KeyEvent.VK_N) Game.refillChoices();//temporary
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		cursor.updateMouse(e);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		cursor.updateMouse(e);
		cursor.click(e, true);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		cursor.updateMouse(e);
		cursor.click(e, false);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {}
}
