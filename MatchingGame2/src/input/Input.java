package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import game.Game;

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
		switch (e.getKeyCode()) {
		case KeyEvent.VK_SPACE://next
			Game.next(false);
			break;
		case KeyEvent.VK_R://reset
			Game.resetPersistence();
			Game.next(true);
			break;
		case KeyEvent.VK_1:
			Game.pick(Game.getCurrentItemOptions().get(0));
			break;
		case KeyEvent.VK_2:
			Game.pick(Game.getCurrentItemOptions().get(1));
			break;
		case KeyEvent.VK_3:
			Game.pick(Game.getCurrentItemOptions().get(2));
			break;
		case KeyEvent.VK_4:
			Game.pick(Game.getCurrentItemOptions().get(3));
			break;
		case KeyEvent.VK_5:
			Game.pick(Game.getCurrentItemOptions().get(4));
			break;
		case KeyEvent.VK_6:
			Game.pick(Game.getCurrentItemOptions().get(5));
			break;
		case KeyEvent.VK_7:
			Game.pick(Game.getCurrentItemOptions().get(6));
			break;
		case KeyEvent.VK_8:
			Game.pick(Game.getCurrentItemOptions().get(7));
			break;
		case KeyEvent.VK_9:
			Game.pick(Game.getCurrentItemOptions().get(8));
			break;
		}
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
