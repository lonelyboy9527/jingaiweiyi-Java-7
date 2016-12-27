package cc.openhome.class1;

// 有一个海上飞机具有 游泳和飞行的能力，实现两个接口中的方法

/*
 *  在  Java中，类可操作两个以上的接口。
 * 也就是拥有多种行为
 * */
public class MySeaplane implements Swimmer ,Flyer {

	private String name;
	public MySeaplane(String name) {
		this.name = name; 
	}
	
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.printf("海上飞机 %s 在飞\n", name);
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.printf("海上飞机 %s 航行海面\n", name);

	}

}
