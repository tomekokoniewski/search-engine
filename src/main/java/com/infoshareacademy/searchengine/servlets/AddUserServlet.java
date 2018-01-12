package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {

    @EJB
    private //?
            UsersRepositoryDao usersRepositoryDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getParameter("id").isEmpty()||//== null ||
                req.getParameter("name").isEmpty()||// == null ||
                req.getParameter("surname").isEmpty()||// == null ||
                req.getParameter("age").isEmpty()||// == null ||
                req.getParameter("login").isEmpty()){// == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            PrintWriter printWriter=resp.getWriter();
            printWriter.println("Status 400, BAD_REQUEST Za 5 sec zostaniesz przekierowany z powrotem");
            resp.setHeader("Refresh","5; /add-user.jsp"); // niestety form bedzie wyczyszczony - mamy refresh
            return;
        }


        String gender;

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int age = Integer.parseInt(req.getParameter("age"));
        String login = req.getParameter("login");
        if(req.getParameter("gender").isEmpty()){
            gender = null;
        }else {
            gender = req.getParameter("gender").toUpperCase();
        }

        User user = usersRepositoryDao.getUserById(id);

        if (user != null) {
            resp.setStatus(HttpServletResponse.SC_CONFLICT);
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("uzytkownik o ID = " + id + " juz istnieje");
            return;
        }

        User user1 = new User();
        user1.setId(id);
        user1.setName(name);
        user1.setSurname(surname);
        user1.setAge(age);
        user1.setLogin(login);

        if(gender!=null) {
            if (gender.equals("MAN"))
                user1.setGender(Gender.MAN);
            else
                user1.setGender(Gender.WOMAN);
        }

        usersRepositoryDao.addUser(user1);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter prWr = resp.getWriter();

        prWr.println("<!DOCTYPE html>");
        prWr.println("<html>");
        prWr.println("<body>");

      prWr.println("Dodano uzytkownika:");
      prWr.println("ID: "+id+"<br>Name: "+name+"<br>Surname: "+surname+"<br>Age: "+
              " "+age+"<br>Login: "+login+"<br>Gender: "+gender);

      prWr.println("</body>");
      prWr.println("</html>");
}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("id") == null || req.getParameter("name") == null ||
                req.getParameter("surname") == null || req.getParameter("age") == null ||
                req.getParameter("login") == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int age = Integer.parseInt(req.getParameter("age"));
        String login = req.getParameter("login");
        String gender = req.getParameter("gender").toUpperCase();

        User user = usersRepositoryDao.getUserById(id);

        if (user != null) {
            resp.setStatus(HttpServletResponse.SC_CONFLICT);
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("uzytkownik o ID = " + id + " juz istnieje");
            return;
        }


        User user1 = new User();
        user1.setId(id);
        user1.setName(name);
        user1.setSurname(surname);
        user1.setAge(age);
        user1.setLogin(login);

        if (gender.equals("MAN"))
            user1.setGender(Gender.MAN);
        else
            user1.setGender(Gender.WOMAN);

        usersRepositoryDao.addUser(user1);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter prWr = resp.getWriter();

        prWr.println("<!DOCTYPE html>");
        prWr.println("<html>");
        prWr.println("<body>");

        prWr.println(id+" "+name+" "+surname+" "+" "+age+" "+login);

        prWr.println("</body>");
        prWr.println("</html>");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/add-user.jsp");
        requestDispatcher.forward(req, resp);

    }




}
