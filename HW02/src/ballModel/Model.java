package ballModel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Random;

import javax.swing.Timer;

public class Model {
	LinkedList<Ball> ballList = new LinkedList<Ball>();
	private int _timeSlice = 50;  // update every 50 milliseconds
	Dispatcher dispatcher = new Dispatcher();
	Randomizer random = Randomizer.getInstance();
	//model to view adapter
	IModel2ViewAdapter _model2ViewAdpt = IModel2ViewAdapter.NULL_OBJECT; //need for empty obj
	Random rand = new Random(); 
	
	private Timer _timer = new Timer(_timeSlice, new ActionListener() {
		/**
		 * The timer "ticks" by calling this method every _timeslice milliseconds
		 */
		public void actionPerformed (ActionEvent e) {
			
			dispatcher.notifyAll(rand.nextInt(70));
			
			_model2ViewAdpt.request2View_update(ballList);
		}
	});
	
	//constructor
	public Model(IModel2ViewAdapter adapter){
		_model2ViewAdpt = adapter;
		
	}
	
	public void start(){
		ballList.add(new NullBall());
		_timer.start();
		
	}
	
	//class loader
	private Ball loadBall(String classname, double[] startLoc,double startRadius,double[] startVel,Color startColor) {
		try {
			Object[] args = new Object[]{startLoc, startRadius, startVel, startColor};
			java.lang.reflect.Constructor<?> cs[] = Class.forName(classname).getConstructors();
			java.lang.reflect.Constructor<?> c = null;
			for(int i=0;i < cs.length; i++) {
				if(args.length == (cs[i]).getParameterTypes().length) {
					c = cs[i];
			        break;
			    }
			}
		return (Ball) c.newInstance(args);
		}
		catch(Exception ex) {
			System.err.println("Class " + classname+" failed to load. \nException = \n"+ ex);
			ex.printStackTrace();
			return null;
		}
	}
	
	public void handleViewRequest_makeBall(String s, Rectangle bounds){
		
		if(s.equals("color") ){
			s = "ballModel.ColorBall";
		}else if(s.equals("radius")){
			s = "ballModel.RadiusBall";
		}else if(s.equals("spin")){
			s = "ballModel.SpinBall";
		}
		double[] loc= random.randomLoc(bounds);
		double r = random.randomDouble(10, 30);
		
		if((loc[0]+6*r)>bounds.width) {		
			loc[0] = loc[0] - 6*r;

		}
		if((loc[1]+6*r)>bounds.height) {
			loc[1] = loc[1] - 6*r;
		}
		
		
		Ball newLoadBall = loadBall(s, 
				loc,
				r,
				random.randomVel(),
				random.randomColor());
		//startLoc = ;
//		startRadius = ;
//		startVel = ;
//		startColor = ;
//		ABall a = loadBall(temp, startLoc, startRadius, startVel, startColor);
		ballList.add(newLoadBall);
		dispatcher.addObserver(newLoadBall);
			
	}
	
	public void handleViewRequest_clearAll() {
		ballList.clear();
	}
}

//class ListOfBalls {
//	ListOfBalls next;
//	Ball ball;
//}


