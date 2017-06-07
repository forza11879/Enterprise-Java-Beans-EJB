/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shout.ejb.ShoutBoardEJBRemote;

@WebServlet(name = "ShoutBoardServlet", urlPatterns = {"/shout"})
public class ShoutBoardServlet extends HttpServlet {

    @EJB
    ShoutBoardEJBRemote shoutService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ShoutBoardServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Shout Board</h1>");
                out.println(" <form method=\"post\">\n"
                        + " Shout: <input type=\"text\" name=\"shout\"><br>\n"
                        + " <input type=\"submit\" value=\"Add shout\" >\n"
                        + " </form>");

                if (request.getMethod().toLowerCase().equals("post")) {
                    String shout = request.getParameter("shout");
                    if (!shout.isEmpty()) {
                        shoutService.addShout(shout);
                    }
                }

                out.println("<ul>");
                String[] shoutArray = shoutService.getAllShouts();
                for (String s : shoutArray) {
                    out.printf("<li>%s</li>\n", s);
                }

                out.println("</ul>");

                out.println("</body>");
                out.println("</html>");
            } catch (Exception e) {
                out.printf("<div>Exception %s: %s</div>", e, e.getMessage());
            }
        }

        

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
