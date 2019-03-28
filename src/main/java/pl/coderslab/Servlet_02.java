package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "Servlet_02", urlPatterns = {"/task2"})
public class Servlet_02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String binary = request.getParameter("binary");

        String regex = "[01]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(binary);
        if (!matcher.matches()) {
            response.getWriter().println("Nie swtierdzono liczby binarnej w formularzu.");
        } else {
            //Calculating binary to dec
            int dec = 0;
            int pow = -1;
            for (int i = (binary.length() - 1); i > (-1); i--) {
                int digit = Integer.parseInt("" + binary.charAt(i));
                pow++;
                dec += digit * (int) Math.pow(2, i);
            }
            response.getWriter().println("Liczba binarna " + binary + " to dziesiętnie " + dec);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
