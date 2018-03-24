package view;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface IView2ModelAdapter {

	public void request2Model_makeBall(String s, Rectangle bounds);
	public void request2Model_clearAll();
	
	public static final IView2ModelAdapter NULL_OBJECT = new IView2ModelAdapter () {
		
		public void request2Model_makeBall(String s, Rectangle bounds) {
			;
		}
		
		public void request2Model_clearAll() {
			;
		}
		
	};
}
