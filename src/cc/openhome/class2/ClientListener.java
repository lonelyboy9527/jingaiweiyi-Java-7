package cc.openhome.class2;

public interface ClientListener {
	void clientAdded(ClientEvent event); 	// 新增Client 会调用这个方法
	void clientRemoved(ClientEvent event);	// 移除Client 会调用这个方法
}
