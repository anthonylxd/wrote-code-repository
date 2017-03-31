package com.project;

import java.util.ArrayList;
import java.util.Scanner;
import com.entity.Accent;

public class Project {
	static Scanner sc = new Scanner(System.in);
	ArrayList<Accent> accents = new ArrayList<Accent>();
	int accentId = 1001;
	//��ʼ�˵�
	public void nav() {
		System.out.println(" ");
		System.out.println("��ʼ�˵�");
		System.out.println("0 ����");
		System.out.println("1 ����");
		System.out.println("2 �˳�");
		System.out.println("������ѡ��");
		int order = sc.nextInt();
		if(order == 0) {
			openAccount();
		}
		if(order == 1) {
			login();
		}
		if(order == 2) {
			exit();
			return;
		}
		if(order > 1) {		
			nav();
		}
	}
	//��¼
	private void login() {
		System.out.println("�����˺�");
		int id = sc.nextInt();
//		System.out.println("��������");
//		String password = sc.next();
		for(int i = 0; i<accents.size();i++){
		Accent accent = accents.get(i);
		if(accent.accentId ==id) {
//			if(accent.password.equals(password)) {
		if(accent.status == 1) {
			System.out.println("�˻�״̬�쳣");
			nav();
			return;
		}
			displayNav(accents.get(i));	
//			}else{
//				System.err.println("�������");
//				nav();
//			}
		}
		}
		System.err.println("�˺Ų�����");
		nav();
	}
	//����
	public void openAccount() {
		System.out.println("����");	
		Accent accent = new Accent();
		System.out.println("����֤������(��λ)");	
		accent.id = sc.nextInt();
		if(accent.id > 9999 || accent.id <1000) {
			System.out.println("����");
			System.out.println("�����¿���");
			System.out.println("֤���ű�׼Ϊ��λ");
			openAccount();
			return;
		}
		System.out.println("�����û���");
		accent.name = sc.next();
		System.out.println("��������(��λ)");
		accent.password = sc.next();
		if(accent.password.length() != 6 ){
			System.out.println("����");
			System.out.println("�����׼Ϊ��λ");
			openAccount();
			return;
		}		
		System.out.println("���뿪��������100Ԫ��");
		accent.balance = sc.nextFloat();
		if(accent.balance < 100) {
			System.out.println("�������¿���");
			System.out.println("������������100Ԫ");
			openAccount();
			return;
		}
		accent.history.add("����"+accent.balance+" ���"+accent.balance);
		accent.accentId = accentId;
		accentId++;
		accent.status = 0;
		System.out.println("�����ɹ�");
		System.out.println(accent.toString());
		accents.add(accent);
		
		nav();
	}
	//�û��˵�
	public void displayNav(Accent accent) {
		System.out.println(" ");
		System.out.println("��� "+accent.name);
		System.out.println("�û��˵�");
		System.out.println("0 ���");
		System.out.println("1 ȡ��");
		System.out.println("2 ��ѯ���");
		System.out.println("3 ��������");
		System.out.println("4 ����");
		System.out.println("5 ��ѯ��ʷ");	
		System.out.println("6 �˳�");
		System.out.println("������ѡ��");
		int order = sc.nextInt();

		switch (order) {
		case 0:
			deposit(accent);
			break;
		case 1:
			withdraw(accent);
			break;
		case 2:
			queryBalance(accent);
			break;
		case 3:
			queryInfo(accent);
			break;
		case 4:
			destroy(accent);
			break;
		case 5:
			queryHistory(accent);
			break;
		case 6:
			nav();
			break;	
		default:
			nav();
			break;
		}
	}
	//��ѯ���
	private void queryBalance(Accent accent) {
		System.out.println(" ");
		System.out.println("��ѯ���");
		System.out.println(accent.name+" "+"���˻����"+accent.balance);
		displayNav(accent);
	}
	//��ѯ��ʷ
	private void queryHistory(Accent accent) {
		System.out.println(" ");
		System.out.println("��ѯ��ʷ");
		System.out.println(accent.history.toString());
		System.out.println(" ");
		displayNav(accent);
	}
	//��ѯ��������
	private void queryInfo(Accent accent) {
		System.out.println(" ");
		System.out.println("��������");
		System.out.println(accent.toString());
		System.out.println(" ");
		displayNav(accent);
	}
	//ȡ��
	private void withdraw(Accent accent) {
		System.out.println(" ");
		System.out.println("ȡ��");
		System.out.println("����ȡ����");
		int num = sc.nextInt();
		if(num < 0) {
			System.err.println("���벻�����Ǹ���");
			withdraw(accent);
			return;
		}
		boolean result = check(accent);
		for(int i = 0; i < 3; i++) {
		if(i == 2) {
			System.out.println("����������������˻��ѱ�����");
			accent.status = 1;
			nav();
			return;
		}
		if(!result) {
			System.out.println("�������");
			result = check(accent);
		}else{
		if(num > accent.balance) {
			System.out.println("����");
			withdraw(accent);
			return;
		}
		accent.balance = accent.balance - num;
		accent.history.add("ȡ��"+num+" �˻����"+accent.balance);
		System.out.println("ȡ��ɹ�");
		displayNav(accent);	
		return;
		}
		}	
	}
	//���
	private void deposit(Accent accent) {
		System.out.println(" ");
		System.out.println("���");
		System.out.println("��������");
		int num = sc.nextInt();
//		if(num%100 > 0) {
//			System.err.println("������100������");
//			deposit(accent);
//			return;
//		}
		if(num < 0) {
			System.out.println("���벻�����Ǹ���");
			deposit(accent);
			return;
		}
		accent.balance = accent.balance + num;
		//accent.history.add(num);
		accent.history.add("���"+num+" �˻����"+accent.balance);
		System.out.println("���ɹ�");	
		displayNav(accent);
	}
	//����
	public void destroy(Accent accent) {
		if(accent.balance > 0) {
			System.out.println("�˻���������������");
			displayNav(accent);
			return;
		}
		boolean result = check(accent);
		if(!result) {
			System.out.println("�������");
			displayNav(accent);
			return;
		}
		accents.remove(accent);
		System.out.println("�����ɹ�");
		nav();
	}
	
	//��֤
	public boolean check(Accent accent) {
		System.out.println("��������");
		String password = sc.next();
		for(int i = 0; i<accents.size();i++){
			if(accent.password.equals(password)) {
			return true;	
			}else{
			return false;	
			}	
		}
		return false;
	}
	
	//�˳�
	public void exit() {
		System.out.println("�ټ�");
	}
	
	public static void main(String[] args) {
		Project project = new Project();
		project.nav();
	}
}
