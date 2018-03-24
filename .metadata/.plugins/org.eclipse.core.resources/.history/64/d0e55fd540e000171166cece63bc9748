package lm44_xw47.view;

import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.globes.Earth;
import gov.nasa.worldwind.layers.MarkerLayer;
import gov.nasa.worldwind.layers.RenderableLayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import map.IRightClickAction;
import map.MapLayer;
import map.MapPanel;

/**
 * Following defines the class for the map view.
 * 
 * @author Lu Ma
 * @author Xiaojun Wu
 *
 * @param <CBType> Type
 */
public class MapView<CBType> extends JPanel {
	/**
	 * An auto generated id for serialization.
	 */
	private static final long serialVersionUID = -1046744381305932964L;

	/**
	 * The panel uses to hold control components.
	 */
	private JPanel _ctrlPanel;

	/**
	 * The panel for the map.
	 */
	private MapPanel _mapPanel;

	/**
	 * A combo box for slectable places.
	 */
	private JComboBox<CBType> _places;

	/**
	 * A text filed used to enter latitude.
	 */
	private JTextField _latField;

	/**
	 * A button used to go to place with specified latitude and longitude.
	 */
	private JButton _goLatLong;

	/**
	 * A text filed used to enter longitude.
	 */
	private JTextField _longField;

	/**
	 * A button used to go to a selected place.
	 */
	private JButton _gotoBtn;

	/**
	 * An adapter this map view uses to communicate with model.
	 */
	private IMapView2MapModelAdapter<CBType> _adpt;
	//private IRightClickAction  _rightClick;

	/**
	 * Constructor.
	 * 
	 * @param adpt The adpater this view used to communicate with model.
	 * @param rightClick The action defines right click action.
	 */
	public MapView(IMapView2MapModelAdapter<CBType> adpt, IRightClickAction rightClick) {
		super();
		_adpt = adpt;
		//_rightClick = rightClick;
		initGUI(rightClick);
	}

	/**
	 * Initializes the map GUI.
	 * 
	 * @param rightClick  The action defines right click action.
	 */
	private void initGUI(IRightClickAction rightClick) {
		try {
			setLayout(new BorderLayout(0, 0));
			//setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

			_ctrlPanel = new JPanel();
			FlowLayout jPanel1Layout = new FlowLayout();
			_ctrlPanel.setLayout(jPanel1Layout);
			add(_ctrlPanel, BorderLayout.SOUTH);
			//_ctrlPanel.setPreferredSize(new java.awt.Dimension(390, 43));
			_ctrlPanel.setBackground(new java.awt.Color(128, 255, 128));

			_latField = new JTextField();
			_ctrlPanel.add(_latField);
			_latField.setText("latitude");
			//_latField.setPreferredSize(new java.awt.Dimension(88, 22));

			_longField = new JTextField();
			_ctrlPanel.add(_longField);
			_longField.setText("longitude");

			_goLatLong = new JButton();
			_ctrlPanel.add(_goLatLong);
			_goLatLong.setText("Go!");
			_goLatLong.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					_adpt.goLatLong(_latField.getText(), _longField.getText());
					_mapPanel.repaint();
				}
			});

			_places = new JComboBox<CBType>();
			_ctrlPanel.add(_places);

			_gotoBtn = new JButton();
			_ctrlPanel.add(_gotoBtn);
			_gotoBtn.setText("Go!");
			_gotoBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					_adpt.goPlace(_places.getItemAt(_places.getSelectedIndex()));
					_mapPanel.repaint();
				}
			});

			_mapPanel = new MapPanel(Earth.class);
			add(_mapPanel, BorderLayout.CENTER);

			//_mapPanel.setPreferredSize(new java.awt.Dimension(600, 400));
			_mapPanel.addRightClickAction(rightClick);

			//pack();
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

	/**
	 * Start the map GUI.
	 */
	public void start() {
		_mapPanel.start();
		//setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Set the position by given position.
	 * 
	 * @param pos The positon being set.
	 */
	public void setPosition(Position pos) {
		_mapPanel.setPosition(pos, true);
	}

	/**
	 * Add the given layer to map panel.
	 * 
	 * @param layer The layer being added to map panel.
	 */
	public void addMapLayer(MapLayer layer) {
		_mapPanel.addLayer(layer);
	}
	
	/**
	 * add a renderable layer to the map panel
	 * @param layer
	 */
	public void addRenderableLayer(RenderableLayer layer) {
		_mapPanel.addLayer(layer);
	}
	
	public void addMarkerLayer(MarkerLayer layer) {
		_mapPanel.addLayer(layer);
	}

	/**
	 * Remove the given layer from map panel.
	 * 
	 * @param layer The layer being removed from map panel.
	 */
	public void removeMapLayer(MapLayer layer) {
		_mapPanel.removeLayer(layer);
	}

	/**
	 * Add the given place to select list.
	 * 
	 * @param p The place being added to select list.
	 */
	public void addPlace(CBType p) {
		_places.insertItemAt(p, 0);
		_places.setSelectedIndex(0);
	}
	
}
