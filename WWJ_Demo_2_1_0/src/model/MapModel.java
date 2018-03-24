package model;

import java.util.ArrayList;

import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.MarkerLayer;
import gov.nasa.worldwind.render.Annotation;
import gov.nasa.worldwind.render.GlobeAnnotation;
import gov.nasa.worldwind.render.Material;
import gov.nasa.worldwind.render.markers.BasicMarker;
import gov.nasa.worldwind.render.markers.BasicMarkerAttributes;
import gov.nasa.worldwind.render.markers.BasicMarkerShape;
import gov.nasa.worldwind.render.markers.Marker;
import gov.nasa.worldwind.render.markers.MarkerAttributes;
import map.MapLayer;
import sun.net.www.content.audio.x_aiff;

public class MapModel {
	IModel2ViewAdapter _adpt;
	MapLayer           _layer = new MapLayer();
	MarkerLayer _markerLayer = new MarkerLayer();
	//test
	Marker marker = new BasicMarker(Position.fromDegrees(0, 180, 0), attrs[2]);
	Position nyc   = Position.fromDegrees(40.748974, -73.990288, 10000);
	GlobeAnnotation nycAnn = new GlobeAnnotation("NYC", nyc);
	
	// all the attributes of markers
	private static final MarkerAttributes[] attrs = new BasicMarkerAttributes[]
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
                new BasicMarkerAttributes(Material.PINK, BasicMarkerShape.ORIENTED_SPHERE, 0.8),
                new BasicMarkerAttributes(Material.BLUE, BasicMarkerShape.ORIENTED_CYLINDER, 0.6),
                new BasicMarkerAttributes(Material.RED, BasicMarkerShape.ORIENTED_CUBE, 1d)
            };
	
	
	public MapModel(IModel2ViewAdapter adpt) {
		_adpt = adpt;
	}
	
	public void click(Position p) {
		System.out.println("Mouse clicked at: " + p+" altitude = "+p.getAltitude());
		//marker.setPosition(position);
		nycAnn.moveTo(p);
		
	}
	
	public void start() {
		Position willy = Position.fromDegrees(29.718550, -95.399068, 150);
		Position epcot = Position.fromDegrees(28.374454, -81.549363, 1000);
		Position nyc   = Position.fromDegrees(40.748974, -73.990288, 10000);
		
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
		_layer.addToggleAnnotation("Epcot Center", "Epcot Selected!", epcot, 0, 1000000);
		_layer.addAnnotation(nycAnn);
		
		//test
		
		ArrayList<Marker> markers = new ArrayList<Marker>();
		markers.add(marker);
		_markerLayer.setMarkers(markers);
		
		_adpt.show(_markerLayer);
		
		
		
		
		_adpt.show(_layer);
		
	}
}
