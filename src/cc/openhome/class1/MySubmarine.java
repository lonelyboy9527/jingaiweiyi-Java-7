package cc.openhome.class1;

// 潜水艇，继承小船，实现深海航行接口
public class MySubmarine extends MyBoat implements Diver {

	public MySubmarine(String name) {
		// TODO Auto-generated constructor stub
		super("");
		this.name = name;
	}
	@Override
	public void dive() {
		// TODO Auto-generated method stub
		System.out.printf("潜水艇 %s 潜行\n", name);
	}

}
