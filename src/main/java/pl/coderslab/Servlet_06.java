package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;

@WebServlet(name = "Servlet_06", urlPatterns = {"/serv6"})
public class Servlet_06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        double[] tab = new double[4];
        tab[0] = Double.parseDouble(request.getParameter("num1"));
        tab[1] = Double.parseDouble(request.getParameter("num2"));
        tab[2] = Double.parseDouble(request.getParameter("num3"));
        tab[3] = Double.parseDouble(request.getParameter("num4"));

        response.getWriter().println("Liczby:<br>");
        double avg = 1.0d;
        double sum = 0d;
        double multiplyEffect = 1.0d;
        for (int i = 0; i < 4; i++) {
            response.getWriter().println(" - " + String.format("%.2f", tab[i]) + "<br>");
            sum += tab[i];
            multiplyEffect *= tab[i];
        }
        avg = sum / 4.0d;
        response.getWriter().println("Średnia:<br>");
        response.getWriter().println(" - " + String.format("%.2f", avg) + "<br>");
        response.getWriter().println("Suma:<br>");
        response.getWriter().println(" - " + String.format("%.2f", sum) + "<br>");
        response.getWriter().println("Iloczyn:<br>");
        response.getWriter().println(" - " + String.format("%.2f", multiplyEffect) + "<br>");
    }
}
