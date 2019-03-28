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

@WebServlet(name = "Servlet_05_1", urlPatterns = {"/serv51"})
public class Servlet_05_1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> basket = (ArrayList<Product>) session.getAttribute("basket");
        if (basket == null) {
            basket = new ArrayList<>();
        }
        String name = request.getParameter("name");
        int amount = Integer.parseInt(request.getParameter("amount"));
        double price = Double.parseDouble(request.getParameter("price"));
        basket.add(new Product(name, amount, price));
        session.setAttribute("basket", basket);

        response.getWriter().println("Produkt dodany");

        productForm(response);
    }

    private void productForm(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("<form action=\"/serv51\" method=\"POST\">");
        response.getWriter().println("Name: <input type = \"text\" name = \"name\"><br>");
        response.getWriter().println("Amount: <input type = \"number\" name = \"amount\"><br>");
        response.getWriter().println("Price: <input type = \"number\" name = \"price\" step=\"0.01\"><br>");
        response.getWriter().println("<input type = \"submit\" value = \"Go shopping!\">");
        response.getWriter().println("</form>");

        response.getWriter().println("<a href=\"/serv52\">Pokaż koszyk</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productForm(response);
    }
}
