package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest {
	public List<Course> coursesToSelect;
	private Scanner console;
	public Student student;
	
	public SetTest() {
		coursesToSelect=new ArrayList<Course>();
		console = new Scanner(System.in);
	}
	public void testAdd() {
		//创建一个课程对象，并同过调用add方法 ，添加到备选课程list中
		Course cr1=new Course("1","数据结构");
		coursesToSelect.add(cr1);
		//Course temp = (Course)coursesToSelect.get(0);
//		System.out.println("添加了课程"+temp.id+temp.name);
		
		Course cr2=new Course("2","c语言");
		coursesToSelect.add(cr2);
		//Course temp2=(Course)coursesToSelect.get(1);
//		System.out.println("添加了课程"+temp2.id+temp2.name);
		
//		coursesToSelect.add(cr1);
//		Course temp0 = (Course)coursesToSelect.get(2);
//		System.out.println("添加了课程"+temp0.id+temp0.name);
		
		/*会造成数组下表越界异常
		 * Course cr3=new Course("3","dsad");
		coursesToSelect.add(4,cr3);
		*/
		Course[] course = {new Course("3","离散数学"),new Course("4","高等数学")};
		coursesToSelect.addAll(Arrays.asList(course));
		//Course temp3 = (Course) coursesToSelect.get(3);
		//Course temp4 = (Course) coursesToSelect.get(4);
//		System.out.println("添加了两门课程"+temp3.id+temp3.name+temp4.id+temp4.name);
		
		Course[] course2= {new Course("5","计算机原理"),new Course("6","大学物理")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
		//Course temp5 = (Course) coursesToSelect.get(2);
		//Course temp6 = (Course) coursesToSelect.get(3);
//		System.out.println("又添加了两门课程"+temp5.id+temp5.name+temp6.id+temp6.name);
	}
	
	public void testForEach() {
		System.out.println("通过ForEach访问");
		System.out.println("有如下课程待选");
		for(Object obj:coursesToSelect) {
			Course cr = (Course)obj;
			System.out.println("课程"+cr.id+":"+cr.name);
		}
	}
	
	public void testForEachForSet(Student student) {
		//输出结果为三说明set中不能有重复的元素  第79，80行
		System.out.println("共选了"+student.courses.size());
		for(Course cr:student.courses) {
			System.out.println("选择了课程:"+cr.id+cr.name);
		}
	}
	/**
	 * 测试list的contains方法
	 * @param args
	 */
	public void testListContains() {
		Course course = coursesToSelect.get(0);
		//打印输出courseToSelect是否包含course对象
		System.out.println("取得课程"+course.name);
		System.out.println("备选课程中是否包含课程："+course.name+","+coursesToSelect.contains(course));
		//提示输入课程名称
		System.out.println("请输入课程名称:");
		String name = console.next();
		Course course2 = new Course();
		course2.name = name;
		System.out.println("新创建课程："+course2.name);
		System.out.println("备选课程中是否包含课程"+course2.name+","+coursesToSelect.contains(course2));
		//通过indexOf方法来取得某元素的索引位置
		//找不到返回-1
		if(coursesToSelect.contains(course2))
			System.out.println("课程："+course2.name+"的索引位置为"+coursesToSelect.indexOf(course2));
		
	}
	//创建学生对象并进行选课
	public void createStudentAndSelectCourses() {
		student = new Student("1","小明");
		System.out.println("欢迎学生"+student.name+"选课!");
		//创建一个Scanner对象，用来接收从键盘输入的课程id
		Scanner console = new Scanner(System.in);
		
		
		for(int i=0;i<3;i++)
		{
			System.out.println("请输入课程id");
			String courseid=console.next();
			for(Course cr:coursesToSelect) {
				if(cr.id.equals(courseid)) {
					student.courses.add(cr);
					//下面的添加没有意义，set不能添加重复元素
					//student.courses.add(cr);
					//还能添加空元素,但是不能添加重复元素
					//student.courses.add(null);
					
					
				}
			}
		}
	}
	/**
	 * 测试set的contains方法
	 */
	public void testSetContains() {
		//提示输入课程名称
		System.out.println("请输入学生已选课程名称：");
		String name =console.next();
		//创建一个新的课程对象，id和名称，与course对象完全一样
		Course course2 = new Course();
		course2.name = name;
		System.out.println("新创建课程："+course2.name);
		System.out.println("备选课程中是否包含课程:"+course2.name+","+student.courses.contains(course2));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetTest test = new SetTest();
		test.testAdd();
		test.testListContains();
		test.testForEach();
		
//		test.createStudentAndSelectCourses();
//		test.testSetContains();
//		Student student = new Student("1","小明");
//		System.out.println("欢迎学生"+student.name+"选课!");
//		//创建一个Scanner对象，用来接收从键盘输入的课程id
//		Scanner console = new Scanner(System.in);
//		
//		
//		for(int i=0;i<3;i++)
//		{
//			System.out.println("请输入课程id");
//			String courseid=console.next();
//			for(Course cr:test.coursesToSelect) {
//				if(cr.id.equals(courseid)) {
//					student.courses.add(cr);
//					//下面的添加没有意义，set不能添加重复元素
//					//student.courses.add(cr);
//					//还能添加空元素,但是不能添加重复元素
//					//student.courses.add(null);
//					
//					
//				}
//			}
//		}
//		
//		test.testForEachForSet(student);
		
		
	}

}
/**
 * contains() :检验是否包含某个-对象-
*/