package book.manage.entity;

import book.manage.Util.SqlUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.util.Scanner;

@Data
@NoArgsConstructor
@Log
public class Book {
    int bid;
    String title;
    String desc;
    double price;

    public Book(String title, String desc, double price) {
        this.title = title;
        this.desc = desc;
        this.price = price;
    }

    // 录入图书信息逻辑
    public static void addBook(Scanner scanner){
        System.out.println("请输入图书名称: ");
        String title = scanner.nextLine();

        System.out.println("请输入图书介绍: ");
        String desc = scanner.nextLine();

        System.out.println("请输入图书定价: ");
        String price = scanner.nextLine();
        double p = Double.parseDouble(price);

        Book book = new Book(title, desc, p);
        SqlUtil.doSqlWork(mapper -> {
            int i = mapper.addBook(book);
            if (i > 0) {
                System.out.println("图书信息录入成功");
                log.info("新添加了一条图书消息: " + book);
            } else System.out.println("图书信息录入失败 请重试");
        });
    }

    // 查询图书信息逻辑
    public static void showBook(){
        SqlUtil.doSqlWork(mapper -> {
            mapper.getBookList().forEach( book -> {
                System.out.println(book.getBid() + "." + book.getTitle() + " " + book.getDesc() + " " + book.getPrice() + "$");
            });
        });
    }
}
