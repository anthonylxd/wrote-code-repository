package com.observer;

import java.util.ArrayList;
import java.util.List;

/*
 * 目标对象，知道观察它的观察者，并提供注册（添加）和删除观察者的接口
 */
public class Subject {
	//用来保存注册的观察者对象
	private List<Observer> observers = new ArrayList<Observer>();
	//集合添加观察者
	public void attach(Observer observer) {
		observers.add(observer);
	}
	//删除集合中的指定观察者
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	//通知所有注册的观察者对象
	protected void notifyObserver() {
		for(Observer observer:observers){
			observer.update(this);
		}
	}
	
}
