package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Manager {
    public static int checkCookies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        boolean found = false;
        int numOfVisitsAsInt = 0;

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("pagesVisited")) {
                    Cookie visits = cookies[i];
                    String pagesVisited = visits.getValue();
                    found = true;
                    numOfVisitsAsInt = Integer.parseInt(pagesVisited) + 1;
                    visits.setValue("" + numOfVisitsAsInt);
                    response.addCookie(visits);
                    break;
                }
            }
        }
        if (!found) {
            Cookie visits = new Cookie("pagesVisited", "1");
            response.addCookie(visits);
            numOfVisitsAsInt = 1;
        }
        return numOfVisitsAsInt;
    }

    public static void clearCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookies[i].setMaxAge(0);
                response.addCookie(cookies[i]);
            }
        }
    }
}
