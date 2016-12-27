package cc.openhome;

import com.sun.org.apache.xpath.internal.operations.Mult;

import apple.laf.JRSUIConstants.Animating;
import cc.openhome.class1.Anemonefish;
import cc.openhome.class1.MyAnemonefish;
import cc.openhome.class1.MyBoat;
import cc.openhome.class1.MyFlyingFish;
import cc.openhome.class1.MyHuman;
import cc.openhome.class1.MySeaplane;
import cc.openhome.class1.MySubmarine;
import cc.openhome.class1.Swimmer;

public class MyClass {
	// 接口定义行为
	public static void exp1() {
		/* 例子：
		 * 
		 * 老板想开发一款海洋乐园游戏，当中所有的东西都会游泳，
		 * 
		 * 1.假如用继承，也许我们会写如下的代码：
		 * 	第一个想到的是鱼，那么定义一个fish的类，定义一个 游泳的抽象方法swim()
		 *  定义了一个小丑鱼Anemonefish，继承自Fish类，实现了swim()方法。
		 *  也许最后还定义了鲨鱼Shark，继承自Fish类，实现了swim()方法...
		 *  
		 *  老板说话了，为什么都是鱼？人也会游泳啊，怎么没有写于是再定义 Human类继承自Fish类，实现了swim()方法。
		 *  但是，这时候，就会很奇怪：
		 *  继承是一种 “is-a”的关系，那Human是一种 Fish吗？
		 *  这种程序上可以编译，可以执行，但是逻辑上或者设计上有不合理的地方。
		 * */
		//1.使用继承，逻辑上会有很多不合理的地方
		Anemonefish fAnemonefish = new Anemonefish("小丑鱼");
		fAnemonefish.swim();
		
		/*  2.记得吗？Java中只能继承一个父类，所以更强化了“是一种”关系的限制性。
		 *  
		 *  需求是“所有东西都会游泳”，代表了“游泳”这个行为可以被所有东西拥有，而不是“某种东西”特有
		 *  对于这种“定义行为”，在Java中可以使用 interface关键字定义
		 *  
		 *  例子：定义一个 Swimmer接口
		 *  接口只用于定义行为，所以 Swimmer中的 swim()方法不能操作，定义为abstract，而且一定是public
		 *  */
		System.out.println("操作接口:");
		MyAnemonefish myAnemonefish = new MyAnemonefish("新的小丑鱼");
		myAnemonefish.swim();
		
		MyHuman myHuman = new MyHuman("小明");
		myHuman.swim();
		/* 继承：以Java的语义来说，继承会有一种 “是一种” 的关系。
		 * 操作接口：则表示 “拥有行为”，但不会有“是一种”的关系。
		 * 
		 * 
		 * */
	}
	
	// 行为的多态
	public static void exp2() {
		/* 通过多态，判读对象是否拥有了某种行为
		 * 
		 * 例子:
		 * 下面的代码判断方式是：
		 * 
		 * “右边是不是拥有左边的行为” 或者 “右边对象是不是操作了左边接口”
		 * 
		 * */ 
		Swimmer swimmer = new MyHuman("小华");
		Swimmer swimmer2 = new MyAnemonefish("小丑鱼");
		
		/* 考虑一个需求：
		 * 
		 * 写个static的swim() 方法，让会游泳的都游起来
		 * 在不会使用接口多态语法时，写出来代码，需要各个对应多个方法
		 * 如果“种类”很多怎么办，多了水母、海蛇、虫等种类等...
		 * 
		 * 只要如下：通过接口多态实现
		 * */
		doSwim(swimmer);
		doSwim(swimmer2);
		
	}
	// 通过接口多态 实现
	public static void doSwim(Swimmer swimmer) {
		swimmer.swim();
	}
	// 解决需求变化
	public static void exp3() {
		/* 相信常听人说：写程序要有弹性，要有可维护性。
		 * 
		 * 什么叫弹性？什么叫可维护？
		 *  如果增加新的需求，原有的程序无须修改，只需针对新的需求撰写程序，那就是有弹性、具可维护性的程序。
		 *  
		 *  例如：上个需求，老板要将海上乐园变成海空乐园， 还需要有会飞的东西，有的东西会游也会飞。
		 *  	那么现在我们只需要增加一个  Flyer接口：
		 *  海上飞机 操作 Flyer 和 Swimmer接口
		 *  小飞鱼 继承 Fish 操作 Flyer 和 Swimmer接口
		 * */
		 MySeaplane mySeaplane = new MySeaplane("花花公子号");
		 mySeaplane.fly();
		 mySeaplane.swim();
		 
		 MyFlyingFish myFlyingFish = new MyFlyingFish("么么哒");
		 myFlyingFish.fly();
		 myFlyingFish.swim();
		 /* 目前来说，我们只是增加代码来满足需求，但没有修改旧有代码，程序拥有某种程度的弹性与可维护性。
		  * 
		  * 但是，我们也不用为了保有程序弹性而过度设计，而有些事先的设计也有可能因为需求不断增加，而超出了原本预留的弹性。
		  * 
		  * 例如：不是所有人都会游泳啊，有的飞机只能天上飞，不能停在海上。
		  * 	那么，因为并非“所有人都会游泳”，所以不再让 MyHuman 操作Swimmer。重新写一个 游泳选手的类，继承MyHuman，并操作 Swimmer
		  * 	“有的飞机只能天上飞，不能停在海上”，因此，写一个父类AirPlane, 实现Flyer接口，而MySeaplane类继承AirPlane，并且实现  Swimmer接口，一些其他的不能游泳的飞机继承AirPlane即可
		  * ...
		  * 
		  * 上面一连串的修改，都是为了调整程序架构，因此程序架构很重要。
		  * */
		 
		 /* 需求：将 游泳分为 浅海游泳 和 深海潜行
		  * 
		  * 在Java中，接口可以继承自另外一个接口，也就是继承接口的行为，再在子接口中额外定义行为。
		  * 
		  * 例子：假设一般的船可以在浅海航行。
		  * */
		 MyBoat myBoat = new MyBoat("桂林号");
		 myBoat.swim();

		 MySubmarine mySubmarine = new MySubmarine("潜水蛟龙号");
		 mySubmarine.dive();
		 
		 /* 需求是永无止境的，好的架构在修改时，其实也不会全部的程序代码被牵动，这就是设计的重要性
		  * 
		  * 但是也是会有需求边界的
		  * */
		 
	}
}
//+++++++++++++行为的多态+++++++++++++