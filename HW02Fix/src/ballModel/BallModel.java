package ballModel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.Timer;

/**
 * MVC model for the system
 */
public class BallModel {
	private int _timeSlice = 50; // update every 50 milliseconds
	// The model adapter is initialized to a no-op to insure that system always has well-defined behavior
	private IModel2ViewAdapter _model2ViewAdpt = IModel2ViewAdapter.NULL_OBJECT;
	//The timer "ticks" by calling this method every _timeslice milliseconds
	private Timer _timer = new Timer(_timeSlice, (e) -> _model2ViewAdpt.update());
	private Dispatcher myDispatcher = new Dispatcher(); //centralize and distribute
	private static Rectangle bounds; //the bounds of the canvas
	private Point startLoc = new Point(10, 20); //start location of the ball
	private int startRadius = 10; //start radius of the ball
	private Point startVel = new Point(10, 10); //start velocity of the ball
	private Color startColor = Color.BLACK; //start color of the ball
	private Randomizer random = new Randomizer(); //set up a randomizer to random location, radius, velocity and color

	/**
	 * Constructor is supplied with an instance of the view adapter.
	 * @param model2ViewAdpt
	 */
	public BallModel(IModel2ViewAdapter model2ViewAdpt) {
		_model2ViewAdpt = model2ViewAdpt;
	}

	/**
	 * get the bounds from the view 
	 * @param bounds
	 */
	public void getBounds(Rectangle bounds) {
		BallModel.bounds = bounds;
	}

	/**
	 * let the ABall class know the bounds of the canvas
	 * @return bounds
	 */
	public static Rectangle returnBounds() {
		return bounds;
	}

	/**
	 * The following method returns an instance of an ABall, given a fully qualified class name (package.classname) of a subclass of ABall.
	 * The method assumes that there is only one constructor for the supplied class that has the same *number* of
	 * input parameters as specified in the args array and that it conforms to a specific
	 * signature, i.e. specific order and types of input parameters in the args array.
	 * @param classname A string that is the fully qualified class name of the desired object
	 * @param startLoc
	 * @param startRadius
	 * @param startVel
	 * @param startColor
	 * @return An instance of the supplied class.
	 */
	private ABall loadBall(String classname, Point startLoc, int startRadius, Point startVel, Color startColor) {
		try {
			Object[] args = new Object[] { startLoc, startRadius, startVel, startColor };
			java.lang.reflect.Constructor<?> cs[] = Class.forName(classname).getConstructors();
			java.lang.reflect.Constructor<?> c = null;
			for (int i = 0; i < cs.length; i++) {
				if (args.length == (cs[i]).getParameterTypes().length) {
					c = cs[i];
					break;
				}
			}
			return (ABall) c.newInstance(args); // Call the constructor.   Will throw a null ptr exception if no constructor with the right number of input parameters was found.
		} catch (Exception ex) {
			System.err.println("Class " + classname + " failed to load. \nException = \n" + ex);
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * add the balls with the given type name, randomize the initial location, radius, velocity and color
	 * add the balls into dispatcher, so right now it can be notified
	 * @param temp
	 */
	public void make_ball(String typename) {
		int radius = random.randomInt(10, 50);
		startLoc = random.randomLoc(returnBounds(), radius);
		startRadius = radius;
		startVel = random.randomVel();
		startColor = random.randomColor();
		typename = "ballModel." + typename;
		ABall a = loadBall(typename, startLoc, startRadius, startVel, startColor);
		myDispatcher.addObserver(a);
	}

	/**
	 * clean all observers from dispatcher, so it could clean the canvas
	 */
	public void clean() {
		myDispatcher.deleteObservers();
	}

	/**
	 * start the model and make the timer start
	 */
	public void start() {
		_timer.start();
	}

	/**
	 * notify all observers to update
	 * @param g
	 */
	public void update(Graphics g) {
		myDispatcher.notifyAll(g);
	}

}
