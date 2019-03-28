package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Servlet_01", urlPatterns = {"/exchange"})
public class Servlet_01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String moneyOption = request.getParameter("moneyOption");
        double amount = Double.parseDouble(request.getParameter("amount"));
        response.getWriter().println("Wybrano " + moneyOption + "<br>");
        switch (moneyOption) {
            case "eurusd": {
                amount *= 1.1;
                break;
            }
            case "usdeur": {
                amount *= 1 / 1.1;
                break;
            }
            case "eurpln": {
                amount *= 4.0;
                break;
            }
            case "plneur": {
                amount *= 1 / 4.0;
                break;
            }
            case "usdpln": {
                amount *= 3.7;
                break;
            }
            case "plnusd": {
                amount *= 1 / 3.7;
                break;
            }
        }
        response.setContentType("text/html");
        response.getWriter().println("Cash in new currency: " + String.format("%.2f", amount));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
