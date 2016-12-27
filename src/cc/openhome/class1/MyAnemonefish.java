package cc.openhome.class1;


public class MyAnemonefish extends MyFish {
	
	public MyAnemonefish(String name) {
		super(name);
		this.name = name;
	}
	
	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.printf("鱼 %s 游泳\n", name);
	}

}
