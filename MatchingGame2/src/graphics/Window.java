package graphics;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import input.Input;
import input.buttons.Button;
import input.buttons.NextButton;

@SuppressWarnings("serial")
public class Window extends JFrame {
	private Input input;
	private Renderer renderer;
	private List<Button> buttons;
	
	public Window() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);//maximize window
		input = new Input();
		addKeyListener(input);
		addMouseMotionListener(input);
		addMouseListener(input);
		addMouseWheelListener(input);
		initButtons();
		renderer = new Renderer();
		add(renderer);
		setVisible(true);
	}

	public void initButtons() {
		buttons = new ArrayList<>();
		buttons.add(new NextButton(10, 10, 40, 40));
	}
	
	public Renderer getRenderer() {
		return renderer;
	}

	public List<Button> getButtons() {
		return buttons;
	}

	public Input getInput() {
		return input;
	}
	
	
}
