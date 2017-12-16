package booksystem.dao;

import booksystem.model.Book;
import booksystem.utils.JDBCUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public List<Book> getBooks() {
        String sql = "select id,name,author,number,description from books";
        JDBCUtils jbcUtils = new JDBCUtils();
        ResultSet rs = jbcUtils.searchQuery(sql);
        List<Book> books = new ArrayList<Book>();
        try {
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setNumber(rs.getInt("number"));
                book.setDescription(rs.getString("description"));
                books.add(book);
            }
            rs.close();
        }catch (SQLException e) {
            System.out.print(e);
        }
        return books;
    }

    public Integer deleteBookByName(String name) {
        String sql = "delete from books where name = \"" + name +"\"";
        JDBCUtils jdbcUtils = new JDBCUtils();
        Integer influenceRow =  jdbcUtils.editOrUpdate(sql);
        jdbcUtils.close();
        return influenceRow;
    }

    // TODO:
    public Boolean deleteBook(Integer id) {
        return false;
    }

    public boolean addBook(Book book) {
        String sql = "insert into books (name,author,number,description) values (" +
                     "\"" + book.getName() +"\"," +
                     "\"" + book.getAuthor() +
                     "\", " + book.getNumber() + "," +
                     "\" " + book.getDescription() +"\")";
        JDBCUtils jdbcUtils = new JDBCUtils();
        Integer influenceRow = jdbcUtils.editOrUpdate(sql);
        jdbcUtils.close();

        return influenceRow > 0 ? true:false;
    }

    public boolean editBookByName(String oldname, Book book) {
        String sql = "UPDATE books SET NAME='"+book.getName()+"', " +
                     "author='"+ book.getAuthor()+ "'," +
                     " number='"+ book.getNumber()+ "'," +
                     "description='"+ book.getDescription()+ "'" +
                     " where name = '"+ oldname + "'" ;
        JDBCUtils jdbcUtils = new JDBCUtils();
        Integer influenceRow = jdbcUtils.editOrUpdate(sql);
        jdbcUtils.close();

        return influenceRow > 0 ? true:false;
    }
}
