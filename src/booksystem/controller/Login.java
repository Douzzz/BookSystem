package booksystem.controller;

import booksystem.dao.UserDao;
import booksystem.model.User;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// 扩展 HttpServlet 类
public class Login extends HttpServlet {

    public void init() throws ServletException{
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao userdao = new UserDao();
        User user = userdao.getUser(username, password);
        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            //重定向;
            response.sendRedirect("/booklist");
        } else {
            request.setAttribute("message","username or password is not correct");
            request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}