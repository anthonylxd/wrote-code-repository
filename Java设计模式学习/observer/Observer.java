package com.observer;
/*
 * 这是一个观察者接口，定义一个更新的接口给那些在目标发生改变的时候被通知的对象
 */
public interface Observer {
	//更新
	public void update(Subject subject);
}
