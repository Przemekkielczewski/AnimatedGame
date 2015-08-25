package pl.przemek.AnimatedGame;

import pl.przemek.Controller.Controller;
import pl.przemek.Model.Model;
import pl.przemek.View.MainFrame;

public class AnimatedGame {

	public static void main(String[] args) {

		MainFrame mainFrame = new MainFrame();
		Model model = new Model();

		Controller controller = new Controller(mainFrame, model);
		mainFrame.setVisible(true);
	}

}
