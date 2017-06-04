package cc.openhome;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		exp1();
		exp2();
	}
	/* ********************7.2 接口语法细节******************** */
	public static void exp2() {
		/* 这节主要讲：
		 * 
		 * 接口的默认语法，接口中定义常数的运用，匿名内部类的撰写等...
		 * */
		MyClass2.exp1(); // 7.2.1 接口的默认
		MyClass2.exp2(); // 7.2.2 匿名内部类
		MyClass2.exp3(); // 7.2.3 使用enum枚举常数
	}
	
	/* ********************7.1 何谓接口******************** */
	public static void exp1() {
		/* 上一章谈过继承，但是一些书说过，别“滥用继承”，或者“优先考虑接口而不是继承”
		 * 
		 * 滥用继承是什么？ 接口代表什么？
		 * 
		 * 注意接口类似于 OC的协议
		 * */
		
		MyClass.exp1(); // 7.1.1 接口定义行为
		MyClass.exp2(); // 7.1.2 行为的多态
		MyClass.exp3(); // 7.1.3 解决需求变化
	}

}
