package cc.openhome.class2;

// Java SE API 提供了 ArrayList，可以对对象进行收集
import java.util.ArrayList;

public class ClientQueue {
	private ArrayList clients = new ArrayList(); 	// 收集联机的Client
	private ArrayList listeners = new ArrayList(); 	// 收集对 CLientQueue有兴趣的ClientListener
	
	// 注册 ClientListener
	public void addClientListener(ClientListener listener) {
		listeners.add(listener);
	}
	// 新增 Client
	public void add(Client client) {
		clients.add(client);
		// 通知信息包装为 ClientEvent
		ClientEvent event = new ClientEvent(client);
		// 遍历 ClientListener接口
		for (int i = 0; i < listeners.size(); i++) {
			ClientListener listener = (ClientListener)listeners.get(i);
			// 发出增加的通知，逐一取出 ClientListener接口通知
			listener.clientAdded(event); // 类似于OC协议的使用，给代理传值
		}
	}
	public void remove(Client client) {
		clients.remove(client);
		// 通知信息包装为 ClientEvent
		ClientEvent event = new ClientEvent(client);
		for (int i = 0; i < listeners.size(); i++) {
			ClientListener listener = (ClientListener)listeners.get(i);
				// 发出移除的通知，逐一取出 ClientListener通知
				listener.clientRemoved(event);
		}
	}
}
