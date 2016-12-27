package cc.openhome.class1;

// 因为 MyHuman也要会游泳，
public class MyHuman implements Swimmer {
	
	private String name;
	
	public MyHuman(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	/* 操作接口的swim()方法
	 * 
	 * 
	 * */
	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.printf("人类 %s 游泳\n", name);
	}

}
