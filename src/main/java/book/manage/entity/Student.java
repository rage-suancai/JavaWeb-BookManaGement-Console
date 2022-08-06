package book.manage.entity;

import book.manage.Util.SqlUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.util.Scanner;

@Data
@NoArgsConstructor
@Log
public class Student {
    int sid;
    String name;
    String sex;
    int grade;

    public Student(String name, String sex, int grade) {
        this.name = name;
        this.sex = sex;
        this.grade = grade;
    }

    // 录入学生信息逻辑
    public static void addStudent(Scanner scanner){
        System.out.println("请输入学生名称: ");
        String name = scanner.nextLine();

        System.out.println("请输入学生性别(男/女): ");
        String sex = scanner.nextLine();

        System.out.println("请输入学生年级");
        String grade = scanner.nextLine();
        int g = Integer.parseInt(grade);

        Student student = new Student(name, sex, g);
        SqlUtil.doSqlWork(mapper -> {
            int i = mapper.addStudent(student);
            if (i > 0) {
                System.out.println("学生信息录入成功");
                log.info("新添加了一条学生消息: " + student);
            } else System.out.println("学生信息录入失败 请重试");
        });
    }

    // 查询学生信息逻辑
    public static void showStudent(){
        SqlUtil.doSqlWork(mapper -> {
            mapper.getStudentList().forEach(student -> {
                System.out.println(student.getSid() + "." + student.getName() + " [" + student.getSex() + "] " + student.getGrade() + "级");
            });
        });
    }
}
