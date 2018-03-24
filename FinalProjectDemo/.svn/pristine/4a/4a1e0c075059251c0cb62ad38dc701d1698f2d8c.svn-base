package lm44_xw47.model;

import java.awt.Color;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import javax.swing.Timer;

import org.junit.experimental.theories.Theories;

import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.MarkerLayer;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.BasicShapeAttributes;
import gov.nasa.worldwind.render.GlobeAnnotation;
import gov.nasa.worldwind.render.Material;
import gov.nasa.worldwind.render.Path;
import gov.nasa.worldwind.render.ShapeAttributes;
import gov.nasa.worldwind.render.markers.BasicMarker;
import gov.nasa.worldwind.render.markers.BasicMarkerAttributes;
import gov.nasa.worldwind.render.markers.BasicMarkerShape;
import gov.nasa.worldwind.render.markers.Marker;
import gov.nasa.worldwind.render.markers.MarkerAttributes;
import gov.nasa.worldwind.terrain.BasicElevationModel;
import gov.nasa.worldwind.util.WWUtil;
import gov.nasa.worldwindx.examples.util.BalloonController;
import map.MapLayer;

/**
 * Following defines model for the map.
 * 
 * @author Lu Ma
 * @author Xiaojun Wu
 */
public class MapModel {
	/**
	 * The adapter this model used to communicate with view.
	 */
	IMapModel2MapViewAdapter _adpt;

	/**
	 * The layer of map of this model.
	 */
	MapLayer _layer = new MapLayer();
	RenderableLayer _renderLayer = new RenderableLayer();
	final MarkerLayer _markerLayer = new MarkerLayer();
	
	/**
	 * player info
	 */
	ArrayList<Player> playerList = new ArrayList<>();
	Player mePlayer = new Player("Player 1", Player.NORTH);
	Player otherPlayer = new Player("Player 2", Player.SOUTH);
	
	/**
	 * ball info
	 */
	Ball ball = new Ball();

	
	/**
	 * timer to update annotations on map
	 */
	private int _timeSlice = 50; // update every 50 milliseconds
	private Timer _timer = new Timer(_timeSlice, 
			(e) -> {
				//players update
				for (Player player : playerList) {
					if(player.moving) {
						player.moveTowardDest();
						player.pickUpBall(ball); // player will try to pick up a ball on the ground. Flying ball won't be picked up.
					}
					
					if (ball.ballState == Ball.FLY) {
						
						if(player.hit(ball)) {
							//if hit by the ball
							_layer.removeAnnotation(player.playerAnnotation);//no longer displayed on layer
							//playerList.remove(player);
						}
					}
				}
				
				
				//ball update
				if(ball.ballState == Ball.FLY) {
					ball.moveTowardDest();
				}else if(ball.ballState == Ball.CARRIED){
					ball.followCarrier();
				}
				
				this._layer.firePropertyChange(gov.nasa.worldwind.avlist.AVKey.LAYER, null, this);
				
			}
	);
	
	/**
	 * Constructor.
	 * 
	 * @param adpt The adapter this model used to communicate with view.
	 */
	public MapModel(IMapModel2MapViewAdapter adpt) {
		_adpt = adpt;
	}

	/**
	 * click shows the position of the mouse clicked place.
	 * 
	 * @param p The position of the mouse clicked place.
	 */
	public void click(Position p) {
		System.out.println("Mouse clicked at: " + p + " altitude = " + p.getAltitude());
		if(mePlayer.team) {
			//north team
			if (p.latitude.degrees > 0) {
				//move
				mePlayer.setDestination(p);
			} else {
				//shoot if carrying the ball
				if(mePlayer.carrying) {
					mePlayer.shoot(p);
				}
			}
		} else {
			//south team
			if (p.latitude.degrees < 0) {
				//move
				mePlayer.setDestination(p);
			} else {
				//shoot if carrying the ball
				if(mePlayer.carrying) {
					mePlayer.shoot(p);
				}
			}
		}
		
		this._layer.firePropertyChange(gov.nasa.worldwind.avlist.AVKey.LAYER, null, this);
	}

	/**
	 * Start the map model.
	 */
	public void start() {
		Position willy = Position.fromDegrees(0, 200, 150);
		Position epcot = Position.fromDegrees(28.374454, -81.549363, 1000);
		Position nyc = Position.fromDegrees(40.748974, -73.990288, 10000);

		_adpt.addPlace(new Place("Greenwich", Position.fromDegrees(51.477222, 0.0, 1000)));
		_adpt.addPlace(new Place("Louvre", Position.fromDegrees(48.860930, 2.336461, 1000)));
		_adpt.addPlace(new Place("London Eye", Position.fromDegrees(51.503367, -0.119968, 1000)));
		_adpt.addPlace(new Place("Acropolis", Position.fromDegrees(37.971458, 23.726647, 800)));
		_adpt.addPlace(new Place("Colosseum", Position.fromDegrees(41.890306, 12.492354, 500)));
		_adpt.addPlace(new Place("Taj Mahal", Position.fromDegrees(27.174932, 78.042144, 1000)));
		_adpt.addPlace(new Place("Pyramids", Position.fromDegrees(29.976788, 31.134001, 1500)));
		_adpt.addPlace(new Place("Statue of Liberty", Position.fromDegrees(40.68925, -74.044493, 500)));
		_adpt.addPlace(new Place("NYC", nyc));
		_adpt.addPlace(new Place("Luxor", Position.fromDegrees(36.095568, -115.176033, 1500)));
		_adpt.addPlace(new Place("Grand Canyon", Position.fromDegrees(36.108091, -113.214912, 90000)));
		_adpt.addPlace(new Place("Golden Gate", Position.fromDegrees(37.82035, -122.4778804, 5000)));
		_adpt.addPlace(new Place("Epcot Center", epcot));
		_adpt.addPlace(new Place("Willy", willy));
		_adpt.addPlace(new Place("Rice", Position.fromDegrees(29.71724, -95.40150, 1000)));

		_layer.addToggleAnnotation("Willy", "Willy Selected!", willy);
		_layer.addToggleAnnotation("Epcot Center", "Epcot Selected!", epcot, 5000, 1000000);
		_layer.addAnnotation(new GlobeAnnotation("NYC", nyc));
		
		
		// Create and set an attribute bundle.
        ShapeAttributes pathAttrs = new BasicShapeAttributes();
        pathAttrs.setOutlineMaterial(new Material(Color.green));
        pathAttrs.setOutlineWidth(2d);

        // Create a path, set some of its properties and set its attributes.
        ArrayList<Position> pathPositions = new ArrayList<Position>();
        pathPositions.add(Position.fromDegrees(0, -179, 1e4));
        pathPositions.add(Position.fromDegrees(0, -120, 1e4));
        pathPositions.add(Position.fromDegrees(0, -60, 1e4));
        pathPositions.add(Position.fromDegrees(0, 0, 1e4));
        pathPositions.add(Position.fromDegrees(0, 60, 1e4));
        pathPositions.add(Position.fromDegrees(0, 120, 1e4));
        pathPositions.add(Position.fromDegrees(0, 179, 1e4));
        Path path = new Path(pathPositions);
        path.setAttributes(pathAttrs);
        path.setVisible(true);
        path.setAltitudeMode(WorldWind.RELATIVE_TO_GROUND);
        path.setPathType(AVKey.GREAT_CIRCLE);
        _renderLayer.addRenderable(path);
		
        //add player annotations to the layer
		playerList.add(mePlayer);//default player
		playerList.add(otherPlayer);
		
		for (Player player : playerList) {
			_layer.addAnnotation(player.playerAnnotation);
		}
		
		//marker layer
	    _markerLayer.setOverrideMarkerElevation(true);
	    _markerLayer.setKeepSeparated(false);
	    _markerLayer.setElevation(1000d);
	    _markerLayer.setMarkers(ball.markers);
         
         
         
		_adpt.show(_layer);
		_adpt.show(_renderLayer);
		_adpt.show(_markerLayer);
		_timer.start();
	}
	
	
}

class Player {
	String playerName = "Player";
	GlobeAnnotation playerAnnotation = new GlobeAnnotation(playerName, Position.fromDegrees(1, 1, 0));
	Position destination = Position.fromDegrees(45, 90, 0);
	Boolean team = NORTH; // true means north team
	Boolean moving = false; //whether the player is moving
	Boolean carrying = false;
	Ball myBall = null;
	
	static Boolean NORTH = true;
	static Boolean SOUTH = false;
	
	
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public Player(String name, Boolean team) {
		Position birthPlace;
		this.playerName = name;
		this.team = team;
		if(team) {
			birthPlace = Position.fromDegrees(45, 90, 0);
		} else {
			birthPlace = Position.fromDegrees(-45, 90, 0);
		}
		playerAnnotation = new GlobeAnnotation(name, birthPlace);
		
	}
	
	@Override
	public String toString() {
		return playerName;
	}
	
	//set destination and start moving
	public void setDestination(Position dest) {
		destination = dest;
		moving = true;
	}
	
	public Position getPosition() {
		return this.playerAnnotation.getPosition();
	}
	public void pickUpBall(Ball ball) {
		Position current = this.playerAnnotation.getPosition();
		double cur_lo = current.longitude.degrees;
		double cur_la = current.latitude.degrees;
		Position ballPosition = ball.ballMarker.getPosition();
		double dest_lo = ballPosition.longitude.degrees;
		double dest_la = ballPosition.latitude.degrees;
		double hypotenuse = Math.sqrt(Math.pow((dest_lo - cur_lo), 2) + Math.pow((dest_la - cur_la), 2));
		if (hypotenuse < 10 && ball.ballState == Ball.STOP) {
			ball.carrier = this;
			ball.ballState = Ball.CARRIED;
			myBall = ball;
			carrying = true;
		}
	}
	
	public Boolean hit(Ball ball) {
		Position current = this.playerAnnotation.getPosition();
		double cur_lo = current.longitude.degrees;
		double cur_la = current.latitude.degrees;
		Position ballPosition = ball.ballMarker.getPosition();
		double dest_lo = ballPosition.longitude.degrees;
		double dest_la = ballPosition.latitude.degrees;
		double hypotenuse = Math.sqrt(Math.pow((dest_lo - cur_lo), 2) + Math.pow((dest_la - cur_la), 2));
		
		return hypotenuse < 7 && ball.ballState == Ball.FLY && team != ball.carrier.team; // whether hit by a flying ball from opponent
		
	}
	
	public void shoot(Position position) {
		myBall.destination = position;
		myBall.ballState = Ball.FLY;
		carrying = false;
	}
	
	public void moveTowardDest() {
		Position current = this.playerAnnotation.getPosition();
		double cur_lo = current.longitude.degrees;
		double cur_la = current.latitude.degrees;
		
		double dest_lo = this.destination.longitude.degrees;
		double dest_la = this.destination.latitude.degrees;
		
		
		//take the short path, for example, move from longitude -179 to longitude 179, you can just move 2 degrees instead of 2 * 179 degrees
		if(Math.abs(dest_lo - cur_lo) > 180) {
			if (dest_lo < cur_lo) {
				dest_lo += 360;
			}else {
				cur_lo += 360;
			}
		}
		
		//move only when hypotenuse > 1, otherwise don't move
		double hypotenuse = Math.sqrt(Math.pow((dest_lo - cur_lo), 2) + Math.pow((dest_la - cur_la), 2));
		if(hypotenuse > 1) {
			double delta_lo = (dest_lo - cur_lo)/hypotenuse *2;
			double delta_la = (dest_la - cur_la)/hypotenuse *2;
			System.out.println(delta_la);
			current = current.add(Position.fromDegrees(delta_la, delta_lo, 0)); //move forward a bit
			this.playerAnnotation.moveTo(current);
		} else {
			moving = false;
		}
	}
}

class Ball {
	
	Marker ballMarker = new BasicMarker(Position.fromDegrees(0, 180, 4000), markerAttrs[10]);
	Position destination = Position.fromDegrees(0, 180, 0);
	ArrayList<Marker> markers = new ArrayList<Marker>();
	int ballState = 0; // 0 static; 1 carried; 2 flying
	static int FLY = 2;
	static int CARRIED = 1;
	static int STOP = 0;
	Player carrier = null;
	
	/**
	 * marker attributes
	 */
	private static final MarkerAttributes[] markerAttrs = new BasicMarkerAttributes[]
            {
                new BasicMarkerAttributes(Material.BLACK, BasicMarkerShape.SPHERE, 1d, 10, 5),
                new BasicMarkerAttributes(Material.MAGENTA, BasicMarkerShape.CUBE, 1d, 10, 5),
                new BasicMarkerAttributes(Material.YELLOW, BasicMarkerShape.CONE, 1d, 10, 5),
                new BasicMarkerAttributes(Material.LIGHT_GRAY, BasicMarkerShape.CYLINDER, 1d, 10, 5),
                new BasicMarkerAttributes(Material.GRAY, BasicMarkerShape.HEADING_ARROW, 1d, 10, 5),
                new BasicMarkerAttributes(Material.WHITE, BasicMarkerShape.HEADING_LINE, 1d, 10, 5),
                new BasicMarkerAttributes(Material.RED, BasicMarkerShape.ORIENTED_CONE_LINE, 0.7),
                new BasicMarkerAttributes(Material.YELLOW, BasicMarkerShape.ORIENTED_CYLINDER_LINE, 0.9),
                new BasicMarkerAttributes(Material.CYAN, BasicMarkerShape.ORIENTED_SPHERE_LINE, 0.7),
                new BasicMarkerAttributes(Material.GREEN, BasicMarkerShape.ORIENTED_CONE, 1d),
                new BasicMarkerAttributes(Material.PINK, BasicMarkerShape.ORIENTED_SPHERE, 0.8, 20,20),
                new BasicMarkerAttributes(Material.BLUE, BasicMarkerShape.ORIENTED_CYLINDER, 0.6),
                new BasicMarkerAttributes(Material.RED, BasicMarkerShape.ORIENTED_CUBE, 1d)
            };
	
	
	
	public Ball() {
		markers.add(ballMarker);
	}
	
	public Position getPosition() {
		return this.ballMarker.getPosition();
	}
	
	//move one step toward destination
	public void moveTowardDest() {
		moveOneStepToward(destination);
	}
	
	//when carried by player, use this method to follow the player
	public void followCarrier() {
		ballMarker.setPosition(carrier.playerAnnotation.getPosition());
	}
	
	public void moveOneStepToward (Position position) {
		Position current = this.ballMarker.getPosition();
		double cur_lo = current.longitude.degrees;
		double cur_la = current.latitude.degrees;
		
		double dest_lo = position.longitude.degrees;
		double dest_la = position.latitude.degrees;
		
		
		//make sure the ball takes the short path, for example, when moving from longitude -179 to longitude 179, you can just move 2 degrees instead of 2 * 179 degrees
		if(Math.abs(dest_lo - cur_lo) > 180) {
			if (dest_lo < cur_lo) {
				dest_lo += 360;
			}else {
				cur_lo += 360;
			}
		}
		
		double hypotenuse = Math.sqrt(Math.pow((dest_lo - cur_lo), 2) + Math.pow((dest_la - cur_la), 2));
		
		//move only when hypotenuse > 1, otherwise don't move
		if(hypotenuse > 1) {
			double delta_lo = (dest_lo - cur_lo)/hypotenuse *2;
			double delta_la = (dest_la - cur_la)/hypotenuse *2;
			System.out.println(delta_la);
			current = current.add(Position.fromDegrees(delta_la, delta_lo, 0)); //move forward a bit
			this.ballMarker.setPosition(current);
		} else {
			this.ballState = Ball.STOP;
		}
	}
    
}
