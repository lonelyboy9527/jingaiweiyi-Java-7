package cc.openhome.class1;

// 会游泳 也会飞的鱼
/* 继承Fish类，操作Flyer 和Swimmer 接口*/

public class MyFlyingFish extends Fish implements Flyer, Swimmer {

	public MyFlyingFish(String name) {
		super("");
		this.name = name;
	}
	
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.printf("小飞鱼 %s 在飞\n", name);
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.printf("小飞鱼 %s 在游泳\n", name);
	}

}
