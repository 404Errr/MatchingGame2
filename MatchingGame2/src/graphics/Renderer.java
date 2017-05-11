//package graphics;
//
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//
//import javax.swing.JPanel;
//
//import data.Data;
//import game.Game;
//
//@SuppressWarnings("serial")
//public class Renderer extends JPanel implements Data {
//	private Graphics2D g;
//	
//	@Override
//	public void paint(Graphics g0) {
//		g = (Graphics2D) g0;
//		super.paintComponent(g);
//		
//		if (Game.getCorrectItem()!=null) drawImage(Game.getCorrectItem().getImage());
//	}
//
////	private void drawScore() {
////		g.setFont(new Font("Helvetica", Font.BOLD, UI_PADDING));
////		g.setColor(Color.BLACK);
////		g.drawString("SCORE: "+Game.getPlayerScore(), UI_PADDING, UI_PADDING*2);
////	}
////
////	private void drawChoiceButtons() {
////		ArrayList<Button> buttons = Buttons.getButtons();
////		g.setFont(new Font("Helvetica", Font.BOLD, UI_BUTTON_HEIGHT/2));
////		for (int i = 0;i<buttons.size();i++) {
////			Button b = buttons.get(i);
////			if (b.isHovered()) {
////				g.setColor(COLOR_UI_BUTTON_HOVERED);
////			}
////			else {
////				g.setColor(COLOR_UI_BUTTON);
////			}
////			g.fill3DRect(b.getBounds().x, b.getBounds().y, b.getBounds().width, b.getBounds().height, !b.isPressed());
////			if (Game.getCurrentItemSet()!=null) {
////				g.setColor(Color.BLACK);
////				if (SHOW_CORRECT) {
////					if (Game.getCurrentItemSet().getChoices().get(i)==Game.getCurrentItemSet().getCorrectItem()) {
////						g.setColor(Color.ORANGE);
////					}
////				}
////				g.drawString(Game.getCurrentItemSet().getChoices().get(i).getName(), b.getBounds().x+UI_BUTTON_HEIGHT/4, b.getBounds().y+UI_BUTTON_HEIGHT*11/16);
////			}
////		}
////	}
////
//	private void drawImage(BufferedImage image) {
//			g.drawImage(image, Window.getFrame().getWidth()/2-IMAGE_SIZE/2, 20, IMAGE_SIZE*(image.getWidth()/image.getHeight()), IMAGE_SIZE, null);
//	}
//}