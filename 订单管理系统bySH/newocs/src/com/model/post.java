package com.model;

import java.util.Date;

public class post {
private String title;
private String author;
private String date;
private String agentname;
private String customername;
private int zan;
private String pay;
private String send;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}

public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getZan() {
	return zan;
}
public void setZan(int zan) {
	this.zan = zan;
}
public String getAgentname() {
	return agentname;
}
public void setAgentname(String agentname) {
	this.agentname = agentname;
}
public String getCustomername() {
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
}
public String getPay() {
	return pay;
}
public void setPay(String pay) {
	this.pay = pay;
}
public String getSend() {
	return send;
}
public void setSend(String send) {
	this.send = send;
}


}
