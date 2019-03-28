package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletServlet_05_2", urlPatterns = {"/serv52"})
public class ServletServlet_05_2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        List<Product> basket = (ArrayList<Product>) session.getAttribute("basket");
        if (basket == null) {
            response.getWriter().println("Koszyk jest pusty");
        } else {
            String name;
            int amount;
            double price;
            double total = 0d;
            for (Product product : basket) {
                name = product.getName();
                amount = product.getAmount();
                price = product.getPrice();
                double recordCost = price * amount;
                response.getWriter().println(name + " - " + amount + " x " + String.format("%.2f", price) + "zł = " +
                        String.format("%.2f", recordCost) + "zł<br>");
                total += recordCost;
            }
            response.getWriter().println("SUMA: " + String.format("%.2f", total) + "zł");
        }
    }
}
