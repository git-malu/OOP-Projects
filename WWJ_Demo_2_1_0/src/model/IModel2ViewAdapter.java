package model;

import gov.nasa.worldwind.layers.MarkerLayer;
import map.MapLayer;

public interface IModel2ViewAdapter {
	public void addPlace(Place p);
	public void show(MapLayer layer);
	public void show(MarkerLayer markerLayer);
	public void hide(MapLayer layer);
}
