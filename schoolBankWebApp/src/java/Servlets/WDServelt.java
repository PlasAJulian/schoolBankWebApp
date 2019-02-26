/**
 * Julian A. P.
 * WDServlets
 * Servlet that deposits or withdraws from a customer's selected account
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


@WebServlet(name = "WDServelt", urlPatterns = {"/WDServelt"})
public class WDServelt extends HttpServlet {

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
            int accountIndex;
            double amount;
            String Index;
            String action;
            String a;
            //fills the var with the data found in the jsp 
            Index = request.getParameter("acc");
            a = request.getParameter("amount");
            action = request.getParameter("WD");
            //removes spaces before and after the the var
            a = a.trim();
            
            try{
                //converts string into double and int
                amount = Double.parseDouble(a);
                accountIndex = Integer.parseInt(Index);
                //looks at the action var. if its D it will finish the process as a depoist
                if(action.equals("D")){
                    c1.accList.uAcc[accountIndex].deposit(amount);
                    c1.accList.uAcc[accountIndex].updateAcc();
                    c1.display();
                    //puts customer back into the session and takes user to the user home page
                    ses1.setAttribute("c1",c1);
                    RequestDispatcher rd = request.getRequestDispatcher("/userHome.jsp");
                    rd.forward(request, response);
                }
                //if its W it will finish the process as a withdraw
                else if(action.equals("W")){
                    double b;
                    b = c1.accList.uAcc[accountIndex].getBal();
                    //checks to make sure the amount user wishes to withdraw is less than or equal to the amount in there account
                    //if statement is true then it competes the process
                    if(amount <= b){
                    c1.accList.uAcc[accountIndex].withdraw(amount);
                    c1.accList.uAcc[accountIndex].updateAcc();
                    c1.display();
                    //puts customer back into the session and takes user to the user home page
                    ses1.setAttribute("c1",c1);
                    RequestDispatcher rd = request.getRequestDispatcher("/userHome.jsp");
                    rd.forward(request, response);
                    }
                    //if amount is more then the amount in the account it takes user back into the WDAccount jsp
                    else{
                        ses1.setAttribute("c1",c1);
                        RequestDispatcher rd = request.getRequestDispatcher("/WDAccount.jsp");
                        rd.forward(request, response);
                    }
                }
            }
            //if any data is not a number, user goes back to the WDAccount jsp
            catch(NumberFormatException e)
            {
                ses1.setAttribute("c1",c1);
                RequestDispatcher rd = request.getRequestDispatcher("/WDAccount.jsp");
                rd.forward(request, response);
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WDServelt</title>");            
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
