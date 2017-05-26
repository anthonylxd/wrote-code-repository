package com.weatherobserver;
/*
 * 具体的观察者对象，实现更新的方法，使自身的状态和目标的状态保持一致
 */
public class ConcreteObserver implements Observer {
	
	//观察者的名字，是谁收到讯息
	private String observerName;
	//天气内容的情况，从目标处获得
	private String weatherContent;
	//获得目标类的状态同步到观察者的状态中
	private String remindThing;
	
	
	//获取目标类的状态同步到观察者的状态
	@Override
	public void update(WeatherSubject Weathersubject) {
		weatherContent = ((ConcreteWeatherSubject)Weathersubject).getWeatherContent();
		System.out.println(observerName+"收到了"+weatherContent+","+remindThing);
		
	}
	
	

	public String getObserverName() {
		return observerName;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
	}

	public String getRemindThing() {
		return remindThing;
	}

	public void setRemindThing(String remindThing) {
		this.remindThing = remindThing;
	}
	
}
