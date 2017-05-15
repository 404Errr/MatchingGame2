package graphics;

import java.awt.GridLayout;

import javax.swing.JFrame;

import input.Input;

@SuppressWarnings("serial")
public class Window extends JFrame {
	private static Input input;
	private static Renderer renderer;

	public Window() {
		renderer = new Renderer();
		input = new Input();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout());
		setExtendedState(MAXIMIZED_BOTH);//maximize window
		addKeyListener(input);
		addMouseMotionListener(input);
		addMouseListener(input);
		addMouseWheelListener(input);
		add(renderer);
		setVisible(true);
	}

	public static Renderer getRenderer() {
		return renderer;
	}
	
	
}
