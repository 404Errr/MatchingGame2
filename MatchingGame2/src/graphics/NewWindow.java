package graphics;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.JApplet;

import data.Data;
import game.Game;
import input.Input;

@SuppressWarnings("serial")
public class NewWindow extends Applet implements Data {
	private static Input input;
	
	public void start() {
		input = new Input();
		System.out.println("started");
		addKeyListener(input);
		addMouseListener(input);
		addMouseMotionListener(input);
		addMouseWheelListener(input);
		setLayout(new GridLayout());
	}
	
	public void paint(Graphics g0) {
		Graphics2D g = (Graphics2D) g0;
//		super.paintComponent(g);
		System.out.println("paint");
		if (Game.getCorrectItem()!=null) drawImage(g, Game.getCorrectItem().getImage());
	}
	
	
	private void drawImage(Graphics2D g, BufferedImage image) {
		g.drawImage(image, Window.getFrame().getWidth()/2-IMAGE_SIZE/2, 20, IMAGE_SIZE*(image.getWidth()/image.getHeight()), IMAGE_SIZE, null);
	}
	
	
}
