package lm44_xw47.model;

import common.IUserCmd2ModelAdapter;
import gov.nasa.worldwind.layers.MarkerLayer;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.Renderable;
import map.MapLayer;

/**
 * Following defines the adapter that map model uses to communicate with map view.
 * 
 * @author Lu Ma
 * @author Xiaojun Wu
 */
public interface IMapModel2MapViewAdapter {
	/**
	 * Add a place to select list.
	 * 
	 * @param p The palce being added to select list.
	 */
	public void addPlace(Place p);

	/**
	 * Show the given layer.
	 * 
	 * @param layer The layer being shown.
	 */
	public void show(MapLayer layer);
	public void show(RenderableLayer renderableLayer);
	public void show(MarkerLayer markerLayer);

	/**
	 * Hide the given layer.
	 * 
	 * @param layer The layer being hiden.
	 */
	public void hide(MapLayer layer);
	
}
