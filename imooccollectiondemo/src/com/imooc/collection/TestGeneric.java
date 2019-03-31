package com.imooc.collection;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
/**
 * 带有泛型————Course，的list类型属性
 * @param args
 */
	public List<Course> courses;
	
	public TestGeneric() {
		this.courses = new ArrayList<Course>();
		
	}
	
	/**
	 * 测试增加
	 * @param args
	 */
	public void testAdd() {
		Course cr1 = new Course("1","大学语文");
		courses.add(cr1);
		//泛型集合中，不能添加泛型规定的类型以及其子类型以外的对象，否则会报错
		//courses.add("能否添加企图哎的东西呢")；
		Course cr2 = new Course("2","dadadxe");
		courses.add(cr2);
	}
	
	public void testForEach() {
		for(Course cr:courses) {
			System.out.println(cr.id+cr.name);
		}
	}
	/**
	 * 测试泛型集合可以添加泛型的子类型的对象实例
	 * @param args
	 */
	public void testChild() {
		ChildCourse ccr = new ChildCourse();
		ccr.id = "3";
		ccr.name = "我是子类型的对象实例";
		courses.add(ccr);
	}
	/**
	 * 泛型基本类型的演示
	 * @param args
	 */
	public void testBasicType() {
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		System.out.println("基本类型必须使用包装类作为泛型"+list.get(0));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGeneric test = new TestGeneric();
		test.testAdd();
		test.testChild();
		test.testBasicType();
		test.testForEach();
	}

}

/**
 * 泛型集合中的限定类型不能使用基本数据类型
 * 可以通过使用包装类限定允许存入的基本数据类型
 * 总结就是如果想使用如int，long，bollean这些类型需使用包装类限定Integer，Long，Boolean
*/