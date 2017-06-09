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
	private BufferedImage image;//current image to display
	
	@Override
	public void paint(Graphics g0) {
		Graphics2D g = (Graphics2D) g0;
		super.paintComponent(g);
		g.setFont(new Font("Helvetica", Font.BOLD, 20));
		if (image!=null) drawImage(g, image/*Game.getCorrectItem().getImage()*/);
		drawButtons(g);
	}

	private void drawButtons(Graphics2D g) {
		for (Button button:Game.getWindow().getButtons()) {
			if (button instanceof ChoiceButton) {
				int rightWrong = ((ChoiceButton) button).getRightWrong();
				if (SHOW_CORRECT==TRUE&&((ChoiceButton) button).getItem()==Game.getCorrectItem()) g.setColor(Color.CYAN);
				if (rightWrong==WRONG) g.setColor(Color.RED);
				if (rightWrong==RIGHT) g.setColor(Color.GREEN);
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
	
	private void drawImage(Graphics2D g, BufferedImage image) {//draws image
		g.drawImage(image, IMAGE_X, IMAGE_Y, IMAGE_SIZE, IMAGE_SIZE*(image.getHeight()/image.getWidth()), null);
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}

	private static boolean TRUE = true;//ignore this
}