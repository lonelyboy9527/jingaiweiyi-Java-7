package cc.openhome.class1;

// 普通的船，在浅海航行
public class MyBoat implements Swimmer {
	protected String name;
	
	public MyBoat(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.printf("船在水面 %s 航行\n", name);
	}
	

}
