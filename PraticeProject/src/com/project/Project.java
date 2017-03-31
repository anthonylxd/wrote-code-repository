package com.project;

import java.util.ArrayList;
import java.util.Scanner;
import com.entity.Accent;

public class Project {
	static Scanner sc = new Scanner(System.in);
	ArrayList<Accent> accents = new ArrayList<Accent>();
	int accentId = 1001;
	//初始菜单
	public void nav() {
		System.out.println(" ");
		System.out.println("初始菜单");
		System.out.println("0 开户");
		System.out.println("1 操作");
		System.out.println("2 退出");
		System.out.println("请输入选择");
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
	//登录
	private void login() {
		System.out.println("输入账号");
		int id = sc.nextInt();
//		System.out.println("输入密码");
//		String password = sc.next();
		for(int i = 0; i<accents.size();i++){
		Accent accent = accents.get(i);
		if(accent.accentId ==id) {
//			if(accent.password.equals(password)) {
		if(accent.status == 1) {
			System.out.println("账户状态异常");
			nav();
			return;
		}
			displayNav(accents.get(i));	
//			}else{
//				System.err.println("密码错误");
//				nav();
//			}
		}
		}
		System.err.println("账号不存在");
		nav();
	}
	//开户
	public void openAccount() {
		System.out.println("开户");	
		Accent accent = new Accent();
		System.out.println("输入证件号码(四位)");	
		accent.id = sc.nextInt();
		if(accent.id > 9999 || accent.id <1000) {
			System.out.println("出错");
			System.out.println("请重新开户");
			System.out.println("证件号标准为四位");
			openAccount();
			return;
		}
		System.out.println("输入用户名");
		accent.name = sc.next();
		System.out.println("输入密码(六位)");
		accent.password = sc.next();
		if(accent.password.length() != 6 ){
			System.out.println("出错");
			System.out.println("密码标准为六位");
			openAccount();
			return;
		}		
		System.out.println("输入开户金额（大于100元）");
		accent.balance = sc.nextFloat();
		if(accent.balance < 100) {
			System.out.println("出错，重新开户");
			System.out.println("开户金额需大于100元");
			openAccount();
			return;
		}
		accent.history.add("存入"+accent.balance+" 余额"+accent.balance);
		accent.accentId = accentId;
		accentId++;
		accent.status = 0;
		System.out.println("开户成功");
		System.out.println(accent.toString());
		accents.add(accent);
		
		nav();
	}
	//用户菜单
	public void displayNav(Accent accent) {
		System.out.println(" ");
		System.out.println("你好 "+accent.name);
		System.out.println("用户菜单");
		System.out.println("0 存款");
		System.out.println("1 取款");
		System.out.println("2 查询余额");
		System.out.println("3 个人资料");
		System.out.println("4 销户");
		System.out.println("5 查询历史");	
		System.out.println("6 退出");
		System.out.println("请输入选择");
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
	//查询余额
	private void queryBalance(Accent accent) {
		System.out.println(" ");
		System.out.println("查询结果");
		System.out.println(accent.name+" "+"的账户余额"+accent.balance);
		displayNav(accent);
	}
	//查询历史
	private void queryHistory(Accent accent) {
		System.out.println(" ");
		System.out.println("查询历史");
		System.out.println(accent.history.toString());
		System.out.println(" ");
		displayNav(accent);
	}
	//查询个人资料
	private void queryInfo(Accent accent) {
		System.out.println(" ");
		System.out.println("个人资料");
		System.out.println(accent.toString());
		System.out.println(" ");
		displayNav(accent);
	}
	//取款
	private void withdraw(Accent accent) {
		System.out.println(" ");
		System.out.println("取款");
		System.out.println("输入取款金额");
		int num = sc.nextInt();
		if(num < 0) {
			System.err.println("输入不可以是负数");
			withdraw(accent);
			return;
		}
		boolean result = check(accent);
		for(int i = 0; i < 3; i++) {
		if(i == 2) {
			System.out.println("密码三次输入错误账户已被锁定");
			accent.status = 1;
			nav();
			return;
		}
		if(!result) {
			System.out.println("密码错误");
			result = check(accent);
		}else{
		if(num > accent.balance) {
			System.out.println("余额不足");
			withdraw(accent);
			return;
		}
		accent.balance = accent.balance - num;
		accent.history.add("取款"+num+" 账户余额"+accent.balance);
		System.out.println("取款成功");
		displayNav(accent);	
		return;
		}
		}	
	}
	//存款
	private void deposit(Accent accent) {
		System.out.println(" ");
		System.out.println("存款");
		System.out.println("输入存款金额");
		int num = sc.nextInt();
//		if(num%100 > 0) {
//			System.err.println("请输入100的整数");
//			deposit(accent);
//			return;
//		}
		if(num < 0) {
			System.out.println("输入不可以是负数");
			deposit(accent);
			return;
		}
		accent.balance = accent.balance + num;
		//accent.history.add(num);
		accent.history.add("存款"+num+" 账户余额"+accent.balance);
		System.out.println("存款成功");	
		displayNav(accent);
	}
	//销户
	public void destroy(Accent accent) {
		if(accent.balance > 0) {
			System.out.println("账户还有余额，不能销户");
			displayNav(accent);
			return;
		}
		boolean result = check(accent);
		if(!result) {
			System.out.println("密码错误");
			displayNav(accent);
			return;
		}
		accents.remove(accent);
		System.out.println("销户成功");
		nav();
	}
	
	//验证
	public boolean check(Accent accent) {
		System.out.println("输入密码");
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
	
	//退出
	public void exit() {
		System.out.println("再见");
	}
	
	public static void main(String[] args) {
		Project project = new Project();
		project.nav();
	}
}
