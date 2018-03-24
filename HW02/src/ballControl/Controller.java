package ballControl;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.text.View;

import ballModel.Ball;
import ballModel.IModel2ViewAdapter;
import ballModel.Model;
import view.MainFrame;
import view.IView2ModelAdapter;

public class Controller {
	private Model myModel;
    private MainFrame myMainFrame;

    public Controller() {
//        myModel = new Model( new IModel2ViewAdapter() {
//            public void request2View() {
//                myView.handleModelRequest();  // myView is in scope!
//            }
//        });
//
//        myView = new View( new IView2ModelAdapter() {
//            public void request2Model() {
//                myModel.handleViewRequest(); // myModel is in scope!
//            }
//        });
    	
    		//View
	    	myMainFrame = new MainFrame(new IView2ModelAdapter() {
	    		
			public void request2Model_makeBall(String s, Rectangle bounds) {
				myModel.handleViewRequest_makeBall(s, bounds); // myModel is in scope!
			}	
			
			public void request2Model_clearAll() {
				myModel.handleViewRequest_clearAll();
			}
			
//			@Override
//			public void request2Model_makeBall() {
//				// TODO Auto-generated method stub
//				
//			}
		});
	    	
	    	myModel = new Model( new IModel2ViewAdapter() {
	    		public void request2View_update(LinkedList<Ball> ballList) {
	    			myMainFrame.handleModelRequest(ballList);
	    		}
	    		public void update(){
	    			
	    		}
//	            public void request2View() {
//	            	myView.handleModelRequest();  // myView is in scope!
//	            	}
	    	});
    }
    
    public void start() {
    		myMainFrame.start();
    		myModel.start();
    }
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					new Controller().start();
					//frame.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Controller myController = new Controller();
	}
}