package book.manage.entity;

import book.manage.Util.SqlUtil;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.Scanner;

@Data
@Log
public class Borrow {
    int id;
    Student student;
    Book book;

    // 添加图书的借阅信息逻辑
    public static void addBorrow(Scanner scanner){
        System.out.println("请输入图书编号: ");
        String a = scanner.nextLine();
        int bid = Integer.parseInt(a);

        System.out.println("请输入学生学号: ");
        String b = scanner.nextLine();
        int sid = Integer.parseInt(b);

        SqlUtil.doSqlWork(mapper -> {
            int i = mapper.addBorrow(sid, bid);
            if (i > 0) {
                System.out.println("图书借阅信息录入成功");
                log.info("新添加了一条图书借阅信息: " + " 学生id: " +  sid + " 图书id: " + bid);
            } else System.out.println("图书借阅信息录入失败 请重试");
        });
    }

    // 查询图书借阅信息
    public static void showBorrow(){
        SqlUtil.doSqlWork(mapper -> {
            mapper.getBorrowList().forEach(borrow ->{
                System.out.println(borrow.getStudent().getName() + " 借阅读了-> " + borrow.getBook().getTitle());
            });
        });
    }

}
