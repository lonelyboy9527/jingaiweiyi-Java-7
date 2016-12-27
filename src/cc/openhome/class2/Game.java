package cc.openhome.class2;

public class Game {
	public static void play(int action) {
		switch (action) {
		case Action.STOP:
			System.out.println("播放停止动画");
			break;
		case Action.RIGHT:
			System.out.println("播放向右动画");
			break;
		case Action.LEFT:
			System.out.println("播放向左动画");
			break;
		case Action.UP:
			System.out.println("播放向上动画");
			break;
		case Action.DOWN:
			System.out.println("播放向下动画");
			break;
		default:
			break;
		}
	}
}
