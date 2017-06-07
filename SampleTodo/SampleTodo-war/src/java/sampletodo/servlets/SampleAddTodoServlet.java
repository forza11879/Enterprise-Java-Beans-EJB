/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampletodo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sampletodo.ejb.SampleTodoDataEJBRemote;
import sampletodo.entities.SampleTodoItem;

/**
 *
 * @author John
 */
public class SampleAddTodoServlet extends HttpServlet {
    
    @EJB
    SampleTodoDataEJBRemote sampleTodoService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet AddTodoServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet AddTodoServlet at " + request.getContextPath() + "</h1>");

                if (request.getMethod().toLowerCase().equals("get")) {
                    out.println("<form method=\"POST\">");
                    out.println("Task: <textarea name=\"task\"></textarea><br>");
                    out.println("Due date: <input type=\"date\" name=\"dueDate\" ><br>");
                    out.println("<input type=\"submit\" value=\"Add todo\"><br>");
                    out.println("</form>");
                } else {
                    String task = request.getParameter("task");
                    String dueDateStr = request.getParameter("dueDate");
                    Date dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDateStr); 
                    SampleTodoItem item = new SampleTodoItem(task, dueDate, false);
                    sampleTodoService.addTodoItem(item);
                    out.println("<p>Item addedd successfully</p>");
                }
                out.println("</body>");
                out.println("</html>");
            } catch (Exception e) {
                e.printStackTrace();
                out.println("Exception occured: " + e.getMessage());
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
