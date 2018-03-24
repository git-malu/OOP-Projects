package controller;

import java.awt.EventQueue;

import model.Model;
import view.*;

/**
 * The Controller, following the practice of previous homework.
 * @author caixy
 */
public class Controller {

	/**
	 * The view
	 */
	View view;

	/**
	 * The model
	 */
	Model model;

	/**
	 * Constructor that initialize the view and model
	 */
	public Controller() {
		view = new View(new IView2ModelAdapter() {
			@Override
			public String loadFile(String fileName) {
				return model.loadFile(fileName);
			}

			@Override
			public void playMusic(int instrument) {
				model.playMusic(instrument);
			}

			@Override
			public String parseFile() {
				return model.parse();
			}
		});
		/**
		 * In this application, no adapter is needed
		 */
		model = new Model();
	}

	/**
	 * start the program
	 */
	private void start() {
		view.start();
		model.start();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller controller = new Controller();
					controller.start();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Controller fails to start.");
				}
			}
		});
	}
}
