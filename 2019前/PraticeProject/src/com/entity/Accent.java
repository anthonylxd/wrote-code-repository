package com.entity;

import java.util.ArrayList;

public class Accent {
public int id;
public int accentId;
public String name;
public float balance;
public String password;
public ArrayList history = new ArrayList();
public int status;

public String toString() {
	return "账户信息 [用户证件号=" + id + ", 账号=" + accentId + ", 姓名=" + name + ", 余额=" + balance + "]";
}


}
