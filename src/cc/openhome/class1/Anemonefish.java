package cc.openhome.class1;

// 小丑鱼继承鱼
public class Anemonefish extends Fish {
	
	// 因为父类存在有参构造函数，默认构造函数JVM就不会自动创建了（除非手动创建），需要手动先调用父类的构造函数
	public Anemonefish(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	// Anemonefish继承了Fish，并且操作了swim方法。
	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.printf("%s游泳\n", name);
	}

}
