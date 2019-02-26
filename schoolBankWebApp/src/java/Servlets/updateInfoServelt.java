/**
 * Julian A. P.
 * updateInfoServelt
 * Servlet updates customer's information
 * */
package Servlets;

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

@WebServlet(name = "updateInfoServelt", urlPatterns = {"/updateInfoServelt"})
public class updateInfoServelt extends HttpServlet {

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
            String firstN;
            String lastN;
            String pass;
            String state;
            String mail;
            //fills the var with the data found in the jsp 
            firstN = request.getParameter("fName");
            lastN = request.getParameter("lName");
            pass = request.getParameter("password");
            state = request.getParameter("state");
            mail = request.getParameter("email");
            //removes spaces before and after the the var
            firstN = firstN.trim();
            lastN = lastN.trim();
            pass = pass.trim();
            mail = mail.trim();
            //set customer var with the var from the jsp
            c1.setFName(firstN);
            c1.setLName(lastN);
            c1.setPwd(pass);
            c1.setState(state);
            c1.setEMail(mail);
            c1.updateCust();
            c1.display();
            //puts customer into the session and takes user to the user home page
            ses1.setAttribute("c1",c1);
            RequestDispatcher rd = request.getRequestDispatcher("/userHome.jsp");
            rd.forward(request, response);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateInfoServelt</title>");            
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
