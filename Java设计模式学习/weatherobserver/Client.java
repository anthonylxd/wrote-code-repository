package com.weatherobserver;

public class Client {

	public static void main(String[] args) {
		//1 创建目标
		ConcreteWeatherSubject ws = new ConcreteWeatherSubject();
		//2 创建观察者
		ConcreteObserver o1 = new ConcreteObserver();
		o1.setObserverName("girlfriend");
		o1.setRemindThing("date");
		ConcreteObserver o2 = new ConcreteObserver();
		o2.setObserverName("mother");
		o2.setRemindThing("shop");
		//3 注册观察者
		ws.attach(o1);
		ws.attach(o2);
		//4 目标发布天气
		ws.setWeatherContent("天气晴朗");
		ws.notifyObserver();
	}

}
