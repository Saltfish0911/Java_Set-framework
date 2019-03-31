package com.imooc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionTest {

	/**
	 * 1.通过Collections。sort()方法，对Integer泛型的List进行排序;
	 * @param args
	 */
	/**
	 * 1.通过Collections。sort()方法，对Integer泛型的List进行排序;
	 * 创建一个Integer泛型的List，插入是个100以内的不重复随机整数
	 * 调用Collections。sort()方法对其进行排序
	 */
	public void testSort() {
		List<Integer> integerlist = new ArrayList<Integer>();
		//插入十个100以内的不重复随机整数
		Random random = new Random();
		Integer k;
		
		for(int i=0;i<10;i++)
		{
			do {
				k=random.nextInt(100);
			}while(integerlist.contains(k));
			integerlist.add(k);
			System.out.println("成功添加整数："+k);
		}
		System.out.println("--------排序前--------");
		for(Integer integer : integerlist) {
			System.out.println("元素"+integer);
		}
		Collections.sort(integerlist);
		System.out.println("-------排序后-------");
		for(Integer integer:integerlist) {
			System.out.println("元素："+integer);
		}
	}
	
	/**
	 * 2.对String泛型的List进行排序
	 * 创建String泛型的List，添加三个乱序的String元素
	 * 调用sort方法，再次输出排序后的顺序
	 * @param args
	 */
	public void testSort2() {
		List<String> stringlist=new ArrayList<String>();
		stringlist.add("microsoft");
		stringlist.add("google");
		stringlist.add("apple");
		System.out.println("-----排序前-----");
		for(String string:stringlist) {
			System.out.println("元素:"+string);
		}
		Collections.sort(stringlist);
		System.out.println("-----排序后-----");
		for(String string:stringlist) {
			System.out.println("元素"+string);
		}
		
	}
	public void terstSort3() {
		List<Student> studentlist = new ArrayList<Student>();
		Random random = new Random();
		
		studentlist.add(new Student(random.nextInt(1000)+"","Mike"));
		studentlist.add(new Student(random.nextInt(1000)+"","Andy"));
		studentlist.add(new Student(random.nextInt(1000)+"","Nana"));
		studentlist.add(new Student(10000+"","feizhai"));
		System.out.println("-----排序前-----");
		for(Student student:studentlist) {
			System.out.println("学生："+student.id+student.name);
		}
		Collections.sort(studentlist);
		System.out.println("-----排序后-----");
		for(Student student:studentlist) {
			System.out.println("学生:"+student.id+student.name);
		}
		Collections.sort(studentlist,new StudentComparator());
		System.out.println("-----按照姓名排序后-----");
		for(Student student:studentlist) {
			System.out.println("学生:"+student.id+student.name);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionTest ct = new CollectionTest();
		//ct.testSort();
		ct.terstSort3();
	}

}
