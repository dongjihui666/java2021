package com.tx.demo03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 学生管理系统主程序
 */
public class StuMain {
    public static void main(String[] args) {
        System.out.println("----欢迎您使用学生管理系统----");

        //成绩学生对象
        Student student = new Student();
        //扫描器对象,可以在控制台上完成用户数据的获取
        Scanner s = new Scanner(System.in);
        System.out.println("亲,请您输入学号");
        //通过扫描器对象获取到客户输入的内容
        int id = s.nextInt();
        //可以给学生对象的属性赋值的
        student.id = id;

        System.out.println("请,请您输入姓名");
        String name = s.next();
        student.username = name;

        System.out.println("请,请您输入性别");
        String sex = s.next();
        student.sex = sex;

        System.out.println("请,请您输入数学成绩");
        int math = s.nextInt();
        student.math = math;

        System.out.println("请,请您输入英语成绩");
        int english = s.nextInt();
        student.english = english;

        //把学生的数据,写入到txt文档中
        wirteStudent(student);
    }

    /**
     * 调用该方法,把student数据写如到txt文档中
     *
     * @param student
     */
    public static void wirteStudent(Student student) {
        //使用IO流的知识
        //创建文件对象
        File file = new File("stu.txt");

        BufferedWriter bw = null;
        //创建输入流
        try {
            bw = new BufferedWriter(new FileWriter(file));
            //写入内容
            bw.write("学号\t姓名\t性别\t数学\t英语");

            //再继续写入,先来一个换行
            bw.newLine();
            //写入学生的数据
            bw.write(student.id+"\t");
            bw.write(student.username+"\t");
            bw.write(student.sex+"\t");
            bw.write(student.math+"\t");
            bw.write(student.english+"\t");

            //刷新
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
