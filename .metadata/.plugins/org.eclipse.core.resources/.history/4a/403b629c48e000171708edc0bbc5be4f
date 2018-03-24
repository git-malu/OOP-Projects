package lm44_xw47.controller;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.SwingUtilities;

import common.DataPacketUser;
import common.IChatRoom;
import common.IComponentFactory;
import common.IReceiver;
import common.IUser;
import common.IUserCmd2ModelAdapter;
import common.IUserMessageType;
import lm44_xw47.chatRoom.controller.ChatRoomController;
import lm44_xw47.model.ILocalUserCmd2ModelAdapter;
import lm44_xw47.model.IMainModel2ViewAdapter;
import lm44_xw47.model.MainModel;
import lm44_xw47.model.Receiver;
import lm44_xw47.view.IMainView2ControllerAdapter;
import lm44_xw47.view.IMainView2ModelAdapter;
import lm44_xw47.view.MainViewFrame;
import provided.mixedData.MixedDataDictionary;
import provided.mixedData.MixedDataKey;

/**
 * Main controller
 * Following defines the main controller for this application.
 * 
 * @author Lu Ma
 * @author Xiaojun Wu
 */
public class MainController {
	/**
	 * The main model for this application.
	 */
	private MainModel _mainModel;

	/**
	 * The main frame for this application
	 */
	private MainViewFrame<IUser> mainFrame;

	/**
	 * The controller for the map MVC.
	 */
	private MapController _miniController;
	
	/**
	 * The blocking queue used to handle multithread tasks.
	 */
	private BlockingQueue<Runnable> bq = new LinkedBlockingQueue<Runnable>(5); // May want larger or different type of blocking queue

	/**
	 * Constructor.
	 */
	public MainController() {
		// the main view
		mainFrame = new MainViewFrame<IUser>(new IMainView2ControllerAdapter() {

			@Override
			public void makeMap() {
				makeMapMVC();
			}

			@Override
			public void startMap() {
				MainController.this.startMap();
			}

			@Override
			public void runJob(Runnable runnable) {
				MainController.this.runJob(runnable);
			}

		}, new IMainView2ModelAdapter<IUser>() {

			@Override
			public IUser connect(String ip) {
				return _mainModel.connect(ip);
			}

		});

		//main model
		_mainModel = new MainModel(new IMainModel2ViewAdapter() {

			@Override
			public void appendLog(String str) {
				mainFrame.appendLog(str);
			}

			@Override
			public IUserCmd2ModelAdapter createUserCmd2ModelAdapter() {
				return new ILocalUserCmd2ModelAdapter() {
					private MixedDataDictionary dict = new MixedDataDictionary();
					
					@Override
					public String getName() {
						// TODO Auto-generated method stub
						return _mainModel.getUsername();
					}

					@Override
					public void appendMsg(String text, String name) {
						mainFrame.appendLog(name + ": " + text);
					}

					@Override
					public void buildScrollableComponent(IComponentFactory fac, String label) {
						mainFrame.addMiniView(fac.makeComponent(), label);
					}

					@Override
					public void buildNonScrollableComponent(IComponentFactory fac, String label) {
						mainFrame.addMiniView(fac.makeComponent(), label);
					}

					@Override
					public <T> T put(MixedDataKey<T> key, T value) {
						return dict.put(key, value);
					}

					@Override
					public <T> T get(MixedDataKey<T> key) {
						return dict.get(key);
					}

					@Override
					public <T extends IUserMessageType> void sendTo(IUser target, Class<T> id, T data) {
						try {
							target.receive(new DataPacketUser<T>(id, data, _mainModel.getUser()));
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}

					@Override
					public IReceiver joinTeam(IChatRoom team) {
						IReceiver[] receivers = _mainModel.joinChatRoom(team);
						new ChatRoomController(team, receivers[1], mainFrame, (Receiver) receivers[0]);
						return receivers[1];
					}
					
				};
			}

		});
		
		

	}

	//inner class; miniController
//	private class MapController {
//		private MapModel _mapModel; //miniModel
//		private MapView<Place> _mapView; //miniView
//
//		//constructor
//		public MapController() {
//			_mapView = new MapView<Place>(new IMapView2MapModelAdapter<Place>() {
//				public void goPlace(Place p) {
//					_mapView.setPosition(p.getPosition());
//				}
//
//				public void goLatLong(String latitude, String longitude) {
//					try {
//						_mapView.setPosition(Position.fromDegrees(Double.parseDouble(latitude),
//								Double.parseDouble(longitude), 4000));
//					} catch (Exception e) {
//						System.out.println("Improper latitude, longitude: " + latitude + ", " + longitude);
//					}
//				}
//			}, new IRightClickAction() {
//				public void apply(Position p) {
//					_mapModel.click(p);
//				}
//			});
//
//			_mapModel = new MapModel(new IMapModel2MapViewAdapter() {
//				public void addPlace(Place p) {
//					_mapView.addPlace(p);
//				}
//
//				public void show(MapLayer layer) {
//					_mapView.addMapLayer(layer);
//				}
//
//				public void hide(MapLayer layer) {
//					_mapView.removeMapLayer(layer);
//				}
//			});
//		}
//
//		//miniController start
//		public void start() {
//			// here needs toMainView adapter to add the miniView to mainView
//			_mapView.start();
//			_mapModel.start();
//			mainFrame.addMiniView(_mapView);
//		}
//	}

	/**
	 * Make map MVC.
	 */
	public void makeMapMVC() {
		/*
		_miniController = new MapController( new IMapCtrl2MainViewAdapter() {
			
			@Override
			public void addMapView2MainView(MapView<Place> mapView) {
				mainFrame.addMiniView(mapView, "Map panel");
			}
		});
		*/
		
	}

	/**
	 * Start map MVC.
	 */
	public void startMap() {
		_miniController.start();
	}

	/**
	 * Start the controller.
	 */
	public void start() {
		mainFrame.start();//main view
		_mainModel.start();//main model

	}

	/**
	 * Run the given Runnable job on the main thread.
	 * 
	 * @param r The Runnable job to run
	 */
	public void runJob(Runnable r) {
		try {
			bq.put(r); // Put job into the queue, blocking if out of space
		} catch (InterruptedException e) {
			System.out.println("runJob(): Exception putting job into blocking queue = " + e);
			e.printStackTrace();
		}
	}

	/**
	 * Start the application.
	 * 
	 * @param args The arguments passes from the command-line
	 */
	public static void main(String[] args) {

		final MainController[] c = new MainController[1]; // One-element array trick to get around the "final"

		try {
			SwingUtilities.invokeAndWait(new Runnable() { // Must use invokeAndWait, not invokeLater so that controller will be a valid instance when the job processing loop starts below.
				public void run() {
					c[0] = new MainController(); // Controller, incl. GUI, is constructed on GUI thread
					c[0].start(); // Always show the GUI on the GUI thread.

				}
			});
		} catch (InvocationTargetException | InterruptedException e1) {
			System.err.println("main(): Exception in instantiating controller = " + e1);
			e1.printStackTrace();
		}

		// Go into infinite loop, waiting for Runnable jobs to perform on the main thread.
		while (true) {
			try {
				System.out.println("Waiting for main thread jobs..");
				Runnable r = c[0].bq.take(); // Pull the next available job out of the queue, otherwise block
				System.out.println("Found and now running job: " + r);
				r.run(); // Run the job.
			} catch (InterruptedException e) {
				System.err.println("Exception in blocking queue: " + e);
				e.printStackTrace();
			}
		}
	}

}