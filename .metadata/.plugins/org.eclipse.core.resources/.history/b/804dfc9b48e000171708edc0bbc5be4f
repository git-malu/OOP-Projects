package lm44_xw47.chatRoom.model;

import common.IChatRoom;
import common.IUser;
import lm44_xw47.clientMap.ClientMapView;
import lm44_xw47.clientMap.IClientMapCtrl2MainViewAdapter;
import lm44_xw47.model.Place;

/**
 * Following defines the adapter that commands uses to communicate with lobby model and view..
 * 
 * @author Xiaojun Wu
 * @author Lu Ma
 */
public interface ICmd2LobbyAdapter extends IClientMapCtrl2MainViewAdapter {
	/**
	 * Add a user to the user drop list.
	 * 
	 * @param user The user being added the user drop list.
	 */
	public void addUser(IUser user);
	
	/**
	 * Add a team to the team drop list.
	 * 
	 * @param team The team being added the team drop list.
	 */
	public void addTeam(IChatRoom team);
	
	/**
	 * Remove a user from the user drop list.
	 * 
	 * @param user The user being removed from the user drop list.
	 */
	public void removeUser(IUser user);
	
	/**
	 * Remove a team from the team drop list.
	 * 
	 * @param team The team being removed from the team drop list.
	 */
	public void removeTeam(IChatRoom team);
	
	/**
	 * Add the map view to the lobby view.
	 * 
	 * @param mapView The map view being added to the lobby view.
	 */
	public void addMapView(ClientMapView<Place> mapView);
	
	/**
	 * Null implementation of this interface.
	 */
	public static final ICmd2LobbyAdapter NULL_OBJECT = new ICmd2LobbyAdapter() {
		/**
		 * No-op.
		 */
		@Override
		public void addUser(IUser user) {
		}

		/**
		 * No-op.
		 */
		@Override
		public void addTeam(IChatRoom team) {
		}

		/**
		 * No-op.
		 */
		@Override
		public void removeUser(IUser user) {
		}

		/**
		 * No-op.
		 */
		@Override
		public void removeTeam(IChatRoom team) {
		}
		
		/**
		 * 
		 */
		public void addMapView(ClientMapView<Place> mapView) {
		}

		
		/**
		 * No-op.
		 */
		@Override
		public void addMapView2MainView(ClientMapView<Place> mapView) {
		}
		
	};
}
