package cc.openhome.class1;
// 类若要操作接口，就必须使用implements 关键字。
public abstract class MyFish implements Swimmer {
	protected String name;

	
	public MyFish(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	/* 操作接口中的方法
	 * 
	 * 有两种处理方式：
	 * 1.直接实现接口中的方法
	 * 2.再度将该方法标示为 abstract
	 * 
	 * 本类中，可能会有各种鱼继承 MyFish，所以采用第二种方式
	 * */
	
//	@Override
//	public void swim() {
//		// TODO Auto-generated method stub
//		System.out.printf("%s游泳", this.name);
//	}
	
	@Override
	public abstract void swim();
}
