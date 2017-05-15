package input;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import main.MatchingMain;

public class Cursor {
	private int x, y;

	public void click(MouseEvent e, boolean down) {
		//TODO
	}

	public void updateMouse(MouseEvent e) {
		e = SwingUtilities.convertMouseEvent(MatchingMain.getWindow(), e, MatchingMain.getWindow().getRenderer());
		x = e.getX();//set position
		y = e.getY();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return x+", "+y;
	}
	
	
}



