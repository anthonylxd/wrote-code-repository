package com.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	private List<Item> items = new ArrayList<Item>();
	
	//点菜
	public void addItem(Item item){
		items.add(item);
	}
	//价格总计
	public float getCost() {
		float cost = 0.0f;
		for(Item item : items){
			cost += item.price();
		}
		return cost;
	}
	//显示菜单
	public void showItems(){
		for(Item item : items){
			System.out.print("Item:"+item.name());
			System.out.print(",Packing:"+item.packing().Pack());
			System.out.println(",Price:"+item.price());
		}
	}
	
	
}
