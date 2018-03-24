package model.strategy;

import java.awt.Graphics;
import model.Ball;

public interface IPaintStrategy {
	void init(Ball host);
	void paint(Graphics g, Ball host);
	static public IPaintStrategy null_paint = new IPaintStrategy() {
		
		@Override
		public void paint(Graphics g, Ball host) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void init(Ball host) {
			// TODO Auto-generated method stub
			
		}
	};
}
