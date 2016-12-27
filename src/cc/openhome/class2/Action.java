package cc.openhome.class2;

public interface Action {
	//注意在 interface中，只能定义 public static final 的枚举常数 (不写，默认就是)
	
	// 即一定要 写 = ;
	public static final int STOP = 0;
	public static final int RIGHT = 1;
	public static final int LEFT = 2;
	public static final int UP = 3;
	public static final int DOWN = 4;
	
}
