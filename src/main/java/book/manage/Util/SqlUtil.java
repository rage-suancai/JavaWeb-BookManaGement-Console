package book.manage.Util;

import book.manage.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.function.Consumer;

public class SqlUtil {

    private SqlUtil(){}

    private static SqlSessionFactory factory;
    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-coning.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doSqlWork(Consumer<BookMapper> consumer) {
        try (SqlSession session = factory.openSession(true)) {
            BookMapper Mapper = session.getMapper(BookMapper.class);
            consumer.accept(Mapper);
        }
    }
}
