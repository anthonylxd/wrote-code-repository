package com.factory;

import java.util.Map;

/*
 * 发型工厂
 */
public class HairFactory {
	/*
	 * 根据类型来创建对象
	 */
	public HairInterface getHair(String key) {
		if("left".equals(key)){
			return new LeftHair();
		}else if("right".equals(key)){
			return new RightHair();
		}
		return null;
	}
	
	//根据类的名称来生产对象
	public HairInterface getHairClass(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		HairInterface hair = (HairInterface) Class.forName(className).newInstance();
		return hair;
	}
	
	//根据类的名称来生产对象
		public HairInterface getHairClassKey(String key) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
			Map<String, String> map =new PropertiesReader().getProperties();
			HairInterface hair = (HairInterface) Class.forName(map.get(key)).newInstance();
			return hair;
		}
	
}
