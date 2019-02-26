/**
 * Julian A. P.
 * addAccServlets
 * Servlet that adds a new account for the customer if they have not reached the limit.
 * */
package Servlets;

import bis.account;
import bis.customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "addAccServelt", urlPatterns = {"/addAccServelt"})
public class addAccServelt extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //gets customer from session
            HttpSession ses1;
            ses1 = request.getSession();
            customer c1;
            c1 = (customer)ses1.getAttribute("c1");
            //var that will used to complete the process
            String aNo;
            String cId;
            String aTp;
            double b;
            account a1;
            a1 = new account();
            //fills the var with the data found in the jsp 
            cId = c1.getId();
            aTp = request.getParameter("aType");
            b = 100;
            a1.getUnusedAccNo();
            aNo = a1.getAccNo();
            //uses insertAcc method to add a new account with the given var
            a1.insertAcc(aNo, cId, aTp, b);
            a1.display();
            c1.accList.addAccount(a1);
            //puts customer back into the session and takes user to the user home page
            ses1.setAttribute("c1",c1);
            RequestDispatcher rd = request.getRequestDispatcher("/userHome.jsp");
            rd.forward(request, response);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addAccServlets</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ur not supports to be here >.> </h1>");
            out.println("</body>");
            out.println("</html>");
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
