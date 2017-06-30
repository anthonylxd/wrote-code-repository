package com.offer;
/*
 * 替换空格
 * 请实现一个函数，
 * 将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */
public class replaceSpace {
	public String replaceSpace(StringBuffer str) {
    	while(true) {
    		if(str.indexOf(" ") == -1){
    			System.out.println(str);
    			return str.toString();
    		}
    	str.replace(str.indexOf(" "), str.indexOf(" ")+1, "%20");  		
    	}
    }
	public static void main(String[] args) {
		replaceSpace replaceSpace = new replaceSpace();
		StringBuffer str = new StringBuffer("We Are Happy");
		replaceSpace.replaceSpace(str);
	}
}
