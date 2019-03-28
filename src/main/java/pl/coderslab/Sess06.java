package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Sess06", urlPatterns = {"/favImages"})
public class Sess06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        List<Integer> choices = (ArrayList<Integer>) session.getAttribute("choices");
        if (choices == null) {
            choices = new ArrayList<>();
        }
        int count = Manager.checkCookies(request, response);
        if (request.getParameter("like" + count).equals("Yes")) {
            session.setAttribute("lastPage", "wybor_" + count);
            choices.add(count);
            session.setAttribute("choices", choices);
        }
        if (count == 4) {
            response.getWriter().println("Te obrazy Ci się podobały:<br>");
            for (int num : choices) {
                response.getWriter().println(num + " : Yes<br>");
            }
            Manager.clearCookies(request, response);
            session.removeAttribute("choices");
        } else {
            response.sendRedirect("wybor_" + (count + 1) + ".html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}
