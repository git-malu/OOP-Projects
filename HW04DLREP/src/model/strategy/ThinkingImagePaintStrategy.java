package model.strategy;

/**
 * Paint strategy that paints a Thinking Emoji as its image
 * 
 * @author daiwei.ldw
 * */
public class ThinkingImagePaintStrategy extends UprightImagePaintStrategy {
	/**
	 * File path for the image
	 * */
	private static String fileName = "../image/thinking.png";

	/**
	 * Constructor that loads the Thinking Emoji image
	 * */
	public ThinkingImagePaintStrategy() {
		super(fileName, 1);
	}

	/**
	 * Present the meaningful content on the GUI
	 * */
	public String toString() {
		return "ThinkingImage";
	}
}
