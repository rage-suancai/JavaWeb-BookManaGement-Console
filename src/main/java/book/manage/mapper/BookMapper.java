package book.manage.mapper;

import book.manage.entity.Book;
import book.manage.entity.Borrow;
import book.manage.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {

    @Insert("")
    int addStudent(Student student);
    @Insert("")
    int addBook(Book book);
    @Insert("")
    int addBorrow(@Param("sid") int sid, @Param("bid") int bid);

    @Select("")
    List<Book> getBookList();
    @Select("")
    List<Student> getStudentList();
    @Results({
            @Result(column = "", property = "", id = true),
            @Result(column = "", property = "", one = @One(select = "")),
            @Result(column = "", property = "", one = @One(select = ""))
    })
    @Select("")
    List<Borrow> getBorrowList();
    @Select("")
    Student getStudentBySid(int sid);
    @Select("")
    Book getBookByBid(int bid);

}
