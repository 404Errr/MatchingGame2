package graphics;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import data.Data;
import input.Input;
import input.buttons.Button;
import input.buttons.ChoiceButton;
import input.buttons.NextButton;

@SuppressWarnings("serial")
public class Window extends JFrame implements Data {
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
		buttons.add(new NextButton(10, 10, 120, 60));
		for (int i = 0;i<CHOICE_COUNT;i++) {
			buttons.add(new ChoiceButton(10+180*i, 80, 160, 60));
		}
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
