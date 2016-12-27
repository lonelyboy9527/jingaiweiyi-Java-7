package cc.openhome.class1;

public abstract class Fish {
	protected String name;
	public Fish(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public String getName() {
		return name;
	}
	// 定义一个游泳的方法。（由于实际上每种鱼游泳方式不同，定义成抽象方法）
	public abstract void swim();
}
