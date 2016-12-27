package cc.openhome.class2;

/* 使用enum定义枚举
 * 
 * 实际上，enum定义了特殊的类，继承java.lang.Enum，不过这是由编译程序处理。
 * 直接撰写程序继承Enum类会被编译程序拒绝。
 * */ 
public enum MyAction {
	STOP, RIGHT, LEFT, UP, DOWN;
}
