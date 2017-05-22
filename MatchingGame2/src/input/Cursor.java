package input;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import game.Game;
import input.buttons.Button;

public class Cursor {
	private int x, y;
	private boolean mouse1, mouse3;
	
	public void click(MouseEvent e, boolean down) {
		if (e.getButton()==MouseEvent.BUTTON1) {
			if (!down) {
				for (Button button:Game.getWindow().getButtons()) {
					if (button.contains(this)) button.click();
				}				
			}
		}
	}

	public void updateMouse(MouseEvent e) {
		e = SwingUtilities.convertMouseEvent(Game.getWindow(), e, Game.getWindow().getRenderer());
		x = e.getX();//set position
		y = e.getY();
		
		for (Button button:Game.getWindow().getButtons()) {
			if (button.contains(this)) button.setHovered(true);
			else button.setHovered(false);
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean mouse1Down() {
		return mouse1;
	}

	public boolean mouse3Down() {
		return mouse3;
	}

	@Override
	public String toString() {
		return x+", "+y;
	}
	
	
}



