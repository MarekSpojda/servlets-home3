package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_04", urlPatterns = {"/serv4"})
public class Servlet_04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        boolean found = false;

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("visits")) {
                    Cookie visits = cookies[i];
                    String numOfVisits = visits.getValue();
                    found = true;
                    response.getWriter().println("Witaj, odwiedziłeś nas już " + numOfVisits + " razy");
                    int numOfVisitsAsInt = Integer.parseInt(numOfVisits) + 1;
                    visits.setValue("" + numOfVisitsAsInt);
                    response.addCookie(visits);
                    break;
                }
            }
        }
        if (!found) {
            response.getWriter().println("Witaj pierwszy raz na naszej stronie");
            Cookie visits = new Cookie("visits", "1");
            visits.setMaxAge(365 * 24 * 60 * 60);
            response.addCookie(visits);
        }
    }
}
