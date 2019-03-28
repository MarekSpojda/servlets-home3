package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Servlet_03", urlPatterns = {"/serv3"})
public class Servlet_03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("input1", request.getParameter("input1"));
        session.setAttribute("input2", request.getParameter("input2"));
        session.setAttribute("input3", request.getParameter("input3"));
        session.setAttribute("input4", request.getParameter("input4"));
        session.setAttribute("input5", request.getParameter("input5"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String atr1 = "";
        String atr2 = "";
        String atr3 = "";
        String atr4 = "";
        String atr5 = "";

        HttpSession session = request.getSession();
        if (session.getAttribute("input1") != null) {
            atr1 = (String) session.getAttribute("input1");
        }
        if (session.getAttribute("input2") != null) {
            atr2 = (String) session.getAttribute("input2");
        }
        if (session.getAttribute("input3") != null) {
            atr3 = (String) session.getAttribute("input3");
        }
        if (session.getAttribute("input4") != null) {
            atr4 = (String) session.getAttribute("input4");
        }
        if (session.getAttribute("input5") != null) {
            atr5 = (String) session.getAttribute("input5");
        }

        response.getWriter().println("<form action=\"/serv3\" method=\"POST\">");
        response.getWriter().println("Input 1: <input type = \"text\" name = \"input1\" value=\"" + atr1 + "\"><br>");
        response.getWriter().println("Input 2: <input type = \"text\" name = \"input2\" value=\"" + atr2 + "\"><br>");
        response.getWriter().println("Input 3: <input type = \"text\" name = \"input3\" value=\"" + atr3 + "\"><br>");
        response.getWriter().println("Input 4: <input type = \"text\" name = \"input4\" value=\"" + atr4 + "\"><br>");
        response.getWriter().println("Input 5: <input type = \"text\" name = \"input5\" value=\"" + atr5 + "\"><br>");
        response.getWriter().println("<input type = \"submit\" value = \"Go!\">");
        response.getWriter().println("</form>");
    }
}
