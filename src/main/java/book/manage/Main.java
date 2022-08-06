package book.manage;

import book.manage.entity.Book;
import book.manage.entity.Borrow;
import book.manage.entity.Student;
import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.LogManager;

/**
 * 实战 基于Mybatis JUL Lombok Maven的图书管理系统(带单元测试)(控制台)
 * 项目需求:
 *      > 在线录入学生信息 书籍信息 借阅信息
 *      > 查询书籍信息列表 查询学生信息列表 查询借阅信息列表
 *      > 完整的日志系统
 */
@Log
public class Main {

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)) {
            LogManager manager = LogManager.getLogManager();
            manager.readConfiguration(Resources.getResourceAsStream("logging.properties"));

            while (true){
                System.out.println("===============图书管理系统1.0===============");
                System.out.println("==================录入功能==================");
                System.out.println("1. 录入学生信息                            ||");
                System.out.println("2. 录入图书信息                            ||");
                System.out.println("3. 添加借阅信息                            ||");
                System.out.println("==================查询功能==================");
                System.out.println("4. 查询学生信息                            ||");
                System.out.println("5. 查询图书信息                            ||");
                System.out.println("6. 查询借阅信息                            ||");
                System.out.print("输入你想要执行的操作(输入数字0退出): ");

                int input;
                try {
                    input = scanner.nextInt();
                } catch (Exception e) {
                    return;
                }
                scanner.nextLine();
                switch (input){
                    case 1:
                        Student.addStudent(scanner);
                        break;
                    case 2:
                        Book.addBook(scanner);
                        break;
                    case 3:
                        Borrow.addBorrow(scanner);
                        break;
                    case 4:
                        Student.showStudent();
                        System.out.println();
                        System.out.println();
                        break;
                    case 5:
                        Book.showBook();
                        System.out.println();
                        System.out.println();
                        break;
                    case 6:
                        System.out.println("信息如下: ");
                        Borrow.showBorrow();
                        System.out.println();
                        System.out.println();
                        break;
                    case 0:
                        return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
