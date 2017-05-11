//package graphics;
//
//import java.awt.GridLayout;
//
//import javax.swing.JFrame;
//
//import input.Input;
//
//@SuppressWarnings("serial")
//public class Window {
//	private static JFrame frame;
//	private static Input input;
//	private static Renderer renderer;
//
//	public static void init() {
//		renderer = new Renderer();
//		input = new Input();
//		frame = new JFrame();
//		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		frame.setLayout(new GridLayout());
//		frame.setExtendedState(MAXIMIZED_BOTH);//maximize window
//		frame.addKeyListener(input);
//		frame.addMouseMotionListener(input);
//		frame.addMouseListener(input);
//		frame.addMouseWheelListener(input);
//		frame.add(renderer);
//		frame.setVisible(true);
//	}
//
//	public static JFrame getFrame() {
//		return frame;
//	}
//
//	public static Renderer getRenderer() {
//		return renderer;
//	}
//	
//	
//}
