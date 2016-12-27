package cc.openhome.class2;

// 使用 ClientEvent封装了 Client的相关信息
public class ClientEvent {
	private Client client;
	public ClientEvent(Client client) {
		// TODO Auto-generated constructor stub
		this.client = client;
	}
	
	public String getName() {
		return client.name;
	}
	
	public String getIp() {
		return client.ip;
	}
}
