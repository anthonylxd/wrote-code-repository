package com.weatherobserverbyjava;

import java.util.Observable;
import java.util.Observer;

//具体的观察者对象
public class ConcreteObserver implements Observer {
	//观察者名称的变量
	private String observerName;
	
	@Override
	public void update(Observable arg0, Object arg1) {
		//推方式
		System.out.println(observerName+"收到推送消息"+arg1);
		
		System.out.println(observerName+"主动到目标对象寻找消息"+((ConcreteWeatherSubject)arg0).getContent());

	}

	public String getObserverName() {
		return observerName;
	}
	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	
	
}
