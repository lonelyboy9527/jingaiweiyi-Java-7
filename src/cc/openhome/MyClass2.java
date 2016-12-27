package cc.openhome;


import cc.openhome.class2.Action;
import cc.openhome.class2.Client;
import cc.openhome.class2.ClientEvent;
import cc.openhome.class2.ClientListener;
import cc.openhome.class2.ClientQueue;
import cc.openhome.class2.Game;
import cc.openhome.class2.MyAction;
import cc.openhome.class2.MyGame;
import cc.openhome.class2.Service;
import cc.openhome.class2.Some;

public class MyClass2 {
	// 接口的默认
	public static void exp1() {
		/* 在Java中，使用 interface 定义抽象的行为， 方法要声明为 public abstract，并且不能有操作
		 * 
		 * 1.接口中的方法一定是公开且抽象的，且不能有操作。(可以省略 public abstract)
		 *  (如果省略，注意其他类实现接口时，需要 public（否则只有 包权限）)
		 * 
		 * 2.在接口中，可以定义常数
		 * 	枚举常数：Java中经常见到接口中定义这类常数，称为枚举常数，这让程序撰写清晰一些。
		 * 	注意在 interface中，只能定义 public static final 的枚举常数
		 * 
		 * 3.类可以操作两个以上的接口，如果有两个接口都定义了某方法，而操作两个接口的类会怎样？
		 * 
		 * */
		
		// 2.枚举常数
		Game.play(Action.DOWN);
		Game.play(Action.UP);
		
		/* 3.类操作有相同方法的接口
		 * 
		 * 在设计上，考虑一下，Some 和Other定义的 execute() 是否表示不同的行为?
		 * 如果表示不同的行为，那么Some 和Other定义的execute()就要在名称上有不同。
		 * 
		 * 如果表示相同的行为：那么可以定义一个父接口，在当中定义 execute()方法
		 * 如果表示不同的行为：则要不同的名称。
		 * 
		 * */ 
		Service service = new Service();
		service.execute(); // 有相同行为，最好重新写一个父类接口
		service.doOther();
		service.doSome();
	}
	
	// 匿名内部类
	public static void exp2() {
		/* 在撰写Java程序时，经常会有临时继承某个 类或者操作某个接口并建立实例的需求。
		 * 
		 * 由于这类子类或者接口类只使用一次，不需要为这些类定义名称，可以使用匿名内部类来解决这个问题。
		 * 
		 * 1.语法 
		 * new 父类() | 接口() {
		 * 	 //类本体操作
		 * };
		 * */
		/* 1.语法
		 * (1)类的例子: 继承 Object重新定义 toString()方法为例
		 * */ 
		Object object = new Object() {
			@Override
			public String toString() {
				return "匿名内部类";
			}
		};
		/* (2)接口的例子
		 * 
		 * */
		Some some = new Some() {
			
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
		};
		/* 2.举个接口应用的例子：
		 * 
		 * (1).假设打算开发多人联机程序，对每个客户端，都会建立Client对象封装相关信息
		 * (2).程序中建立的 Client对象，都会加入ClientQueue集中管理
		 * (3).若程序中的其他部分希望在ClientQueue的Client加入或移除时可以收到通知，以便做一些处理（例如日志记录），那么可以将Client加入或移除的信息包装为ClientEvent
		 * (4).可以定义一个ClientListener接口，如果有对象Client加入ClientQueue ,可以调用这个接口
		 * (5).如何在 ClientQueue中新增或移除Client时予以通知呢？直接看 ClientQueue
		 * 
		 * 
		 * 例子如下:
		 * */
		ClientQueue queue = new ClientQueue();
		/* 通过创建 匿名接口，赋值给ClientQueue中list
		 * 
		 * 匿名接口中的方法调用，是根据ClientQueue中操作add或者 remove时，再调用
		 * 有点类似OC的Block
		 * */ 
		queue.addClientListener(new ClientListener() {
			
			@Override
			public void clientRemoved(ClientEvent event) {
				// TODO Auto-generated method stub
				System.out.printf("%s 从 %s 脱机\n", event.getName(), event.getIp());
			}
			
			@Override
			public void clientAdded(ClientEvent event) {
				// TODO Auto-generated method stub
				System.out.printf("%s 从 %s 联机\n", event.getName(), event.getIp());
			}
		});
		
		Client c1 = new Client("127.0.0.1", "Caterpillar");
		Client c2 = new Client("192.168.0.2", "Justin");
		queue.add(c1);
		queue.add(c2);
		queue.remove(c1);
		queue.remove(c2);
		
		/* 匿名内部类中存取局部变量，则该变量必须是final，否则会发生编译错误。
		 * 
		 * 例子
		 *
		 * 必须声明 x 为final才可以通过编译
		 * 为什么？
		 * 
		 * 一句话：匿名内部类 只能访问外部类的静态变量或静态方法。
		 * 底层机制：局部变量的生命周期往往比对象短，像是方法调用后返回对象，局部变量生命周期就结束了，
		 * 此时在通过对象尝试存取局部变量会发生错误，
		 * Java做法是采用传值。
		 * */ 
		final int[] x = {10, 20}; // 局部变量
		Object object2 = new Object() {
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "example" + x[0];
			}
		};
		System.out.println(object2.toString());
		
		/* 注意
		 * 
		 * · 匿名内部类不能有构造方法。  （因为匿名内部类是没有类名的）
		 * · 匿名内部类不能定义任何静态成员、方法和类。
		 * · 匿名内部类不能是抽象类。（因为在创建匿名内部类的时候，会立即创建匿名内部类的对象。从而也可知匿名内部类必须实现它的抽象父类或者接口里包含的所有抽象方法）
		 * · 匿名内部类不能是public,protected,private,static。  
		 * · 只能创建匿名内部类的一个实例。
		 * · 一个匿名内部类一定是在new的后面，用其隐含实现一个接口或实现一个类。  
		 * · 因匿名内部类为局部内部类，所以局部内部类的所有限制都对其生效。
		 * · 内部类只能访问外部类的静态变量或静态方法。
		 * 
		 * */ 
	}
	
	// 使用 enum 枚举常数
	public static void exp3() {
		/* 在上例子中，Game类的play方法，有对于枚举常数的应用方式
		 * 
		 * 但是，却可以传入任意的一个int型数据。
		 * 从JDK5之后新增了 enum语法，可用于定义枚举常数。
		 * */
		
		// play中声明为 MyAction类型，所以只接受MyAction实例。
		MyGame.play(MyAction.RIGHT);
		MyGame.play(MyAction.UP);
	}
}
