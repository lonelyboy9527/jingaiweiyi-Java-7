package cc.openhome.class2;

public class MyGame {
	
	public static void play(MyAction action) { // 声明为 MyAction类型
		switch (action) {
		case STOP: // 列举MyAction.STOP实例
			System.out.println("播放停止动画");
			break;
		case RIGHT:
			System.out.println("播放向右动画");
			break;
		case LEFT:
			System.out.println("播放向左动画");
			break;
		case UP:
			System.out.println("播放向上动画");
			break;
		case DOWN:
			System.out.println("播放向下动画");
			break;
		default:
			break;
		}
	}
}
