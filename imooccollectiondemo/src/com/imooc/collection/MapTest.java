package com.imooc.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {
	/**
	 * 哟过来橙装学生类型对象
	 * @param args
	 */
	public Map<String,Student> students;
	/**
	 * 在构造器中初始化students属性
	 * @param args
	 */
	public MapTest() {
		this.students = new HashMap<String,Student>();
	}
	/**
	 * 测试添加：输入学生id，判断是否被占用
	 * 若未被占用，则输入姓名，创建学生对象，并且
	 * 添加到students中
	 * 
	 * @param args
	 */
	public void testPut() {
		Scanner console = new Scanner(System.in);
		int i=0;
		while(i<3) {
			System.out.println("请输入学生id:");
			String id = console.next();
			//判断该id是否被占用
			Student st = students.get(id);
			if(st==null) {
				//提示输入学生姓名
				System.out.println("请输入学生姓名：");
				String name = console.next();
				//创建新的学生对象
				Student newStudent = new Student(id,name);
				//通过students的put方法，添加id-学生映射
				students.put(id,newStudent);
				System.out.println("成功添加学生："+students.get(id).name);
				i++;
			}
			else {
				System.out.println("该学生id已被占用！");
				continue;
			}
		}
	}
	/**
	 * 测试Map的keySet方法
	 * @param args
	 */
	public void testKeySet() {
		//通过keyset方法，返回map中的所有“键“的set几乎
		Set<String> keySet = students.keySet();
		//取得students的容量
		System.out.println("总共有："+students.size()+"个学生");
		
		//便利keyset，取得每一个键，在调用get方法取得每个键对应的value
		for(String stuid:keySet) {
			Student st = students.get(stuid);
			if(st!=null) {
				System.out.println("学生："+st.name);
			}
		}
	}
	/**
	 * 测试删除Map中的映射
	 * @param args
	 */
	public void testRemove() {
		while(true) {
			//提示输入带删除的学生的id
			System.out.println("请输入要删除的学生id!");
			//从键盘获取需要删除的学生的id
			Scanner console = new Scanner(System.in);
			String id = console.next();
			Student st = students.get(id);
			//判断该id是否有对应的学生对象
			if(st==null) {
				//无对应学生对象,提示输入的id并不存在
				System.out.println("该id不存在");
				continue;
			}
			else {
				students.remove(id);
				System.out.println("成功删除学生："+st.name);
				break;
			}
		}
		
	}
	/*
	 *通过entrySet方法来遍历Map
	 */
	public void testEntrySet() {
		Set<Entry<String,Student>> entrySet=students.entrySet();
		for(Entry<String,Student>entry:entrySet) {
			System.out.println("取得键"+entry.getKey());
			System.out.println("对应值为:"+entry.getValue().name);
		}
	}
	/**
	 * 利用put方法秀娥该Map中的已有映射
	 * @param args
	 */
	public void testModify() {
		//提示输入要修改的学生id
		System.out.println("请输入要修改的学生的id:");
		//创建一个Scanner对象，去获取从键盘上输入的学生id字符串
		Scanner console = new Scanner(System.in);
		while(true) {
			//取得从键盘输入的学生id
			String stuid = console.next();
			//从students中查找该学生id对应的学生对象
			Student student = students.get(stuid);
			if(student==null) {
				System.out.println("该id不存在!请重新输入！");
				continue;
			}
			//提示当前对应的学生对象的姓名
			System.out.println("当前该学生id，对应的学生为："+student.name);
			//提示输入新的学生姓名，来修改已有的映射
			System.out.println("请输入新的学生姓名:");
			String newname = console.next();
			Student newStudent = new Student(stuid,newname);
			students.put(stuid,newStudent);
			System.out.println("修改成功");
			break;
		}
	}
	/**
	 * 测试Map中，是否包含某个Key值或者某个Value值
	 * @param args
	 */
	public void testContainsKeyOrValue() {
		//提示输入学生id
		System.out.println("请输入要查询的学生id:");
		Scanner console = new Scanner(System.in);
		String id = console.next();
		//在map中用containsKey()方法，来判断是否包含某个Key值
		System.out.println("您输入的学生id为："+id+"在学生英标中是否存在："+students.containsKey(id));
		if(students.containsKey(id)) System.out.println("对应的学生为："+students.get(id).name);
		//提示输入学生姓名进行查询
		System.out.println("请输入要查询的学生姓名：");
		String name = console.next();
		//用containsValue方法，来判断是否包含某个Value值
		if(students.containsValue(new Student(null,name)))
			System.out.println("在学生映射表中，确实包含学生："+name);
		else System.out.println("在学生映射表中不存在该学生");
	}
	
	public static void main(String[] args) {
		MapTest mt = new MapTest();
		mt.testPut();
		mt.testKeySet();
//		mt.testRemove();
//		mt.testEntrySet();
//		mt.testModify();
//		mt.testEntrySet();
		mt.testContainsKeyOrValue();
	}
}
