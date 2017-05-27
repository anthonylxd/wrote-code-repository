package com.weatherobserverbyjava;
//测试类
public class Client {

	public static void main(String[] args) {
		//创建天气作为一个目标，也可以说是被观察者
		ConcreteWeatherSubject subject = new ConcreteWeatherSubject();
		//创建观察者
		ConcreteObserver girl = new ConcreteObserver();
		girl.setObserverName("girlfriend");
		ConcreteObserver mom = new ConcreteObserver();
		mom.setObserverName("mother");
		
		//注册观察者
		subject.addObserver(girl);
		subject.addObserver(mom);
		
		//目标更新天气情况
		subject.setContent("天气晴，气温21度");
		
	}

}
