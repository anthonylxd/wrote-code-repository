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
	return "�˻���Ϣ [�û�֤����=" + id + ", �˺�=" + accentId + ", ����=" + name + ", ���=" + balance + "]";
}


}
