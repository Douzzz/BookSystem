package booksystem.controller;

import booksystem.dao.BookDao;
import booksystem.model.Book;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class BookList extends HttpServlet{
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDao bookdao = new BookDao();
        req.setAttribute("books", bookdao.getBooks());
        req.getServletContext().getRequestDispatcher("/booklist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        BookDao bookdao = new BookDao();
        book.setName(req.getParameter("bookname"));
        book.setAuthor(req.getParameter("author"));
        book.setNumber(Integer.parseInt(req.getParameter("number")));
        book.setDescription(req.getParameter("description"));
        if(bookdao.addBook(book)) {
            doGet(req, resp);
        } else {
           //donothing;haha
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDao bookdao = new BookDao();
        String name = req.getParameter("name");
        Integer influenceRow = bookdao.deleteBookByName(name);
        resp.setContentType("application/json");
        if( influenceRow > 0 ) {
            resp.getWriter().write("{ \"result\":  1 }");
        } else {
            resp.getWriter().write("{ \"result\":  0 }");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        BookDao bookdao = new BookDao();
        String oldname = req.getParameter("oldname");
        book.setName(req.getParameter("name"));
        book.setAuthor(req.getParameter("author"));
        book.setNumber(Integer.parseInt(req.getParameter("number")));
        book.setDescription(req.getParameter("description"));
        if(bookdao.editBookByName(oldname, book)) {
            resp.getWriter().write("{ \"result\":  1 }");
        } else {
            resp.getWriter().write("{ \"result\":  0 }");
        }

    }
}
