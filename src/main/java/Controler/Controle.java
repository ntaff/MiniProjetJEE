/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import DataBase.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author camilleclaret
 */

@WebServlet(name = "Controle", urlPatterns = {"/Controle"})
public class Controle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private DataSource MyDataSource = DataSourceFactoryDeployed.getDataSource();
    private DAO myDAO = new DAO(MyDataSource);
    
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws SQLException
     * @throws DAOException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, DAOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        System.out.print("action");
        
        
        
        if (actionIs(request, "Connexion"))
        {
            System.out.println("cc");
            newConnection(request,response);
        } else {
            showView("LoginPage.jsp", request, response);
        }
    }
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws SQLException
     * @throws DAOException 
     */
    private void newConnection (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, DAOException
    {
            
        String user = request.getParameter("login");
        String mdp = request.getParameter("mdp");
    
        if (myDAO.loginCheck(user, mdp))
        {
           if (user.equals("admin"))
           {
               showView("AdminPage.jsp", request, response);
           } else {
               showView("ClientPage.html", request, response);
           }
        } else {
            showView("LoginPage.jsp", request, response);
            ServletContext context = getServletContext();
            context.setAttribute("erreur", "mot de passe ou identifiant incorrect");
        }
            
    }
    
    /**
     * 
     * @param request
     * @param action
     * @return 
     */
    private boolean actionIs(HttpServletRequest request, String action)
    {
        return action.equals(request.getParameter("action"));
    }
    
    /**
     * 
     * @param jsp
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void showView(String jsp, HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {
        getServletConfig().getServletContext().getRequestDispatcher("/Views/" + jsp).forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
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
