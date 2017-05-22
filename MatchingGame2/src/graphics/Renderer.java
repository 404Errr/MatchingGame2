package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import data.Data;
import game.Game;
import input.buttons.Button;
import input.buttons.ChoiceButton;
import input.buttons.NextButton;

@SuppressWarnings("serial")
public class Renderer extends JPanel implements Data {
	private BufferedImage image;
	
	@Override
	public void paint(Graphics g0) {
		Graphics2D g = (Graphics2D) g0;
		super.paintComponent(g);
		g.setFont(new Font("Helvetica", Font.BOLD, 20));
		if (image!=null) drawImage(g, image/*Game.getCorrectItem().getImage()*/);
		drawButtons(g);
	}

	private void drawButtons(Graphics2D g) {//TEMPORARY
		for (Button button:Game.getWindow().getButtons()) {
			if (button instanceof ChoiceButton) {
				int rW = ((ChoiceButton) button).getRightWrong();
				if (SHOW_CORRECT==TRUE&&((ChoiceButton) button).getItem()==Game.getCorrectItem()) g.setColor(Color.CYAN);
				if (rW==WRONG) g.setColor(Color.RED);
				if (rW==RIGHT) g.setColor(Color.GREEN);
			}
			g.drawRect(button.getX(), button.getY(), button.getWidth(), button.getHeight());
			g.setColor(Color.BLACK);
			if (button instanceof NextButton) {
				g.drawString("next", button.getX()+5, button.getY()+button.getHeight()*2/3);
			}
			if (button instanceof ChoiceButton&&((ChoiceButton) button).getItem()!=null) {
				g.drawString(((ChoiceButton) button).getItem().getName(), button.getX()+5, button.getY()+button.getHeight()*2/3);
			}
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
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}



	private static boolean TRUE = true;//ignore this
}