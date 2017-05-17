package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import data.Data;
import game.Game;
import input.buttons.Button;

@SuppressWarnings("serial")
public class Renderer extends JPanel implements Data {
	@Override
	public void paint(Graphics g0) {
		Graphics2D g = (Graphics2D) g0;
		super.paintComponent(g);
		if (Game.getCorrectItem()!=null) drawImage(g, Game.getCorrectItem().getImage());
		drawButtons(g);
	}

	private void drawButtons(Graphics2D g) {
		for (Button button:Game.getWindow().getButtons()) {
			g.fillRect(button.getX(), button.getY(), button.getWidth(), button.getHeight());
		}
	}
	
//	private void drawScore() {
//		g.setFont(new Font("Helvetica", Font.BOLD, UI_PADDING));
//		g.setColor(Color.BLACK);
//		g.drawString("SCORE: "+Game.getPlayerScore(), UI_PADDING, UI_PADDING*2);
//	}
//
//	private void drawChoiceButtons() {
//		ArrayList<Button> buttons = Buttons.getButtons();
//		g.setFont(new Font("Helvetica", Font.BOLD, UI_BUTTON_HEIGHT/2));
//		for (int i = 0;i<buttons.size();i++) {
//			Button b = buttons.get(i);
//			if (b.isHovered()) {
//				g.setColor(COLOR_UI_BUTTON_HOVERED);
//			}
//			else {
//				g.setColor(COLOR_UI_BUTTON);
//			}
//			g.fill3DRect(b.getBounds().x, b.getBounds().y, b.getBounds().width, b.getBounds().height, !b.isPressed());
//			if (Game.getCurrentItemSet()!=null) {
//				g.setColor(Color.BLACK);
//				if (SHOW_CORRECT) {
//					if (Game.getCurrentItemSet().getChoices().get(i)==Game.getCurrentItemSet().getCorrectItem()) {
//						g.setColor(Color.ORANGE);
//					}
//				}
//				g.drawString(Game.getCurrentItemSet().getChoices().get(i).getName(), b.getBounds().x+UI_BUTTON_HEIGHT/4, b.getBounds().y+UI_BUTTON_HEIGHT*11/16);
//			}
//		}
//	}
//
	private void drawImage(Graphics2D g, BufferedImage image) {
		g.drawImage(image, IMAGE_X, IMAGE_Y, IMAGE_SIZE, IMAGE_SIZE*(image.getHeight()/image.getWidth()), null);
	}
}