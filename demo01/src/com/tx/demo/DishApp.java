package com.tx.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 点菜的主程序
 */
public class DishApp {

    //提前准备一些菜品,可以展示给用户,用户也可以点菜
    //定义集合(表示小饭店拥有的菜品),泛型
    static List<Dish> dishlist = new ArrayList<>();

    //吃饭的用户已点的菜品
    static List<Dish> personDish = new ArrayList<>();

    public static void main(String[] args) {

        //先初始化菜品
        initDish();
        //小饭店就会做5个菜

        //创建扫描器对象,获取到控制台输入的内容
        Scanner s = new Scanner(System.in);
        //写死循环
        while (true) {
            //给用户展示主菜单
            showMenu();
            int num = s.nextInt();
            switch (num) {
                case 1:
                    while (true) {
                        //把饭店菜单展示给用户就ok
                        showDishMenu();
                        //获取用户输入的内容
                        int id = s.nextInt();
                        //判断
                        if (id ==0){
                            break;
                        }
                        //从饭店的集合中获取菜的对象
                        Dish dish = dishlist.get(id - 1);
                        System.out.println("亲,您点了"+dish.name+"菜");
                        //用户点一个,存储一个
                        personDish.add(dish);

                    }
                case 2:
                    //展示用户已经点的菜品
                    showPersionDish();
                    break;
                case 3:
                    //买单
                    buy();
                    return;
            }
        }
    }

    /*
        展示主菜单
     */
    public static void showMenu() {
        System.out.println("----主菜单----");
        System.out.println("菜单\t\t\t 1");
        System.out.println("已点菜品\t\t 2");
        System.out.println("买单\t\t\t 3");
        System.out.println("----根据编号选择服务----");
    }

    /*
    展示饭店菜单
     */
    public static void showDishMenu() {
        System.out.println("----请您点菜----");
        //遍历集合
        for (int i = 0; i < dishlist.size(); i++) {
            //从集合中使用 i 获取每一个菜品的对象
            Dish dish = dishlist.get(i);
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price + "\t");
        }
        System.out.println("----输入序号点菜,按0返回上一级----");
    }

    /*
    客户已点
     */
    public static void showPersionDish() {
        System.out.println("----您已经点的菜品----");
        //遍历已点的集合
        for (Dish dish : personDish) {
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price + "\t");
        }

    }

    /*
    买单
     */
    public static void buy() {
        System.out.println("----请稍等,正在结算----");
        //定义总金额
        double total = 0f;
        for (Dish dish : personDish) {
            //单价的累加
            total +=dish.price;
        }
        System.out.println("亲,您本次共消费了:"+total+"元");
    }

    /*
    初始化菜品
     */
    public static void initDish() {
        Dish dish = new Dish(1, "鱼香肉丝", 27.0);
        dishlist.add(dish);
        Dish dish2 = new Dish(2, "炖王八", 59.0);
        dishlist.add(dish2);

        //存放菜品
        dishlist.add(new Dish(3, "家常凉菜", 21.0));
        dishlist.add(new Dish(4, "地三线", 24.0));
        dishlist.add(new Dish(5, "炖白菜", 22.0));

    }
}
