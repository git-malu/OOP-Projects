package common;

/**
 * This adapter is for the externally-sourced commands to interact with the local system.
 */
public interface ICmd2ModelAdapter<S> {
	/**
	 * Append some message to the model, allowing the model to process the message by itself. Typically the model just appends to the view.
	 * @param text The message
	 * @param name The name of the person sending the text
	 */
	void appendMsg(java.lang.String text, java.lang.String name);
	
	/**
	 * Give the GUI a factory that creates a scrollable component component to add. 
	 * Some components that are added are considered by the system to be just fancy displays of message contents and in such, 
	 * just like text messages, are desired to be placed on some sort of scrolling display.
	 * @param fac The factory to create the desired component
	 * @param label The identifying label for the scrollable component on the GUI
	 */
	void buildNonScrollableComponent(IComponentFactory fac, java.lang.String label);
	
	/**
	 * Give the GUI a factory that creates a non-scrollable component component to add. 
	 * Some components that are added are actually static modifications of the local GUI to present additional user interaction capabilities. 
	 * It would be undesireable for these components to scroll off the screen as other messages arrive; they should have a fixed location on the local GUI.
	 * @param fac The factory to create the desired component
	 * @param label The identifying label for the non-scrollable component on the GUI
	 */
	void buildScrollableComponent(IComponentFactory fac, java.lang.String label);
	
	/**
	 * Get the value associated with the given key from the local data storage(IMixedDataDictionary)
	 * @param key The key to use
	 * @return The value associated with the key or null if there is no entry for the key.
	 */
	<T> T get(provided.mixedData.MixedDataKey<T> key);
	
	/**
	 * Put a value into the local data storage(IMixedDataDictionary), associated with the given key, 
	 * replacing any value already in the dictionary that is already associated with the key.
	 * @param key The key to use to find the value
	 * @param value The value to associate with the key
	 * @return The previous value associated with the key or null if there was none.
	 */
	<T> T put(provided.mixedData.MixedDataKey<T> key, T value);
	
	/**
	 * Send a data packet to a target recipient.
	 * @param target The target recipient
	 * @param id The class id, i.e. message type
	 * @param data The data
	 */
	<T> void sendTo(S target, java.lang.Class<T> id, T data);
}
