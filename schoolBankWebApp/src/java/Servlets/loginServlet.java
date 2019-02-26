/**
 * Julian A. P.
 * addAccServlets
 * Servlet allows user to login with there customer id and pass and if it matches in the database.
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


@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //var that will used to complete the process
        String cID;
        String Pwd;
        customer c1;
        try{
            //fills the var with the data found in the jsp
            cID = request.getParameter("ID");
            Pwd = request.getParameter("password");
            System.out.println(cID);
            System.out.println(Pwd);
            //create Objects
            c1 = new customer();
            c1.selectCust(cID); 
            
            //pull password from database
            String pwdb = c1.getPwd();
            //puts customer into the session
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("c1",c1);
            System.out.println("customer addeed to Session" + pwdb);
            //if password is a match takes user to user home page
            if(Pwd.equals(pwdb)){
                System.out.println("id is right");
                RequestDispatcher rd = request.getRequestDispatcher("/userHome.jsp");
                rd.forward(request, response);
            }
            //if it doee not match, takes user to invalid jsp
            else{
                System.out.println("id is wrong");
                RequestDispatcher rd = request.getRequestDispatcher("/invalid.jsp");
                rd.forward(request, response);
            }
        }
        finally {
            System.out.println("LoginServlet Ending...");
            out.close();
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