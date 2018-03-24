package client.clientView;

public interface IModelAdapter<TDropListItem> {
	public String connectTo(String s);
	
	public void quit();
	
	public void sendMsgToRemoteHost(String s);
	
	public String runTask(TDropListItem item, String s);
	
    public TDropListItem addTask(String s);

    public TDropListItem combineTasks(TDropListItem item1, TDropListItem item2);
    
    

}
