package cc.openhome.class2;

// 一个类操作两个接口，这两个接口有一个相同的方法
public class Service implements Some, Other {

	// 如果，要执行相同的行为，剋一将execute()提取出来，写一个父类的接口
	// 如果，要执行不同的行为，名字需要不一样。
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("execute()");
	}

	@Override
	public void doSome() {
		// TODO Auto-generated method stub
		System.out.println("doSome()");
	}
	
	@Override
	public void doOther() {
		// TODO Auto-generated method stub
		System.out.println("doOther()");
	}

}
