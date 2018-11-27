package Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Controler", urlPatterns = {"/Controler"})
public class Controler extends HttpServlet {

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
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        // Partie client
        if (actionIsClient(request, "Connexion")) 
        {
           this.newConnect(request, response, true);
        } else if (actionIsClient(request, "Ajout")) {
            this.addCommand(request, response);
        } else if (actionIsClient(request, "Modifier")) {
            this.editCommand(request, response);
        } else if (actionIsClient(request, "Supprimer")){
            this.deleteCommand(request, response);
        }
        // Partie fournisseur
        else if (actionIsAdmin(request, "Connexion"))
        {
           this.newConnect(request, response, false);
        }else if (actionIsAdmin(request, "ChiffreAffaire")) {
            
        }else if (actionIsAdmin(request, "Ajout")) {
            this.addProduct(request, response);
        } else if (actionIsAdmin(request, "Modifier")) {
            this.editProduct(request, response);
        } else if (actionIsAdmin(request, "Supprimer")){
            this.deleteProduct(request, response);
        }
       
    }
    /**
     * Fonction qui retourne un boolean de la validité de l'action du client
     * @param request
     * @param action
     * @return 
     */
    private boolean actionIsClient(HttpServletRequest request, String action) 
    {
        return action.equals(request.getParameter("actionClient"));
    }
    
    /**
     * Fonction qui retourne un boolean de la validité de l'action de l'admin
     * @param request
     * @param action
     * @return 
     */
    private boolean actionIsAdmin(HttpServletRequest request, String action) 
    {
        return action.equals(request.getParameter("actionAdmin"));
    }
    
    /**
     * Fonction permettant d'afficher une vue
     * @param jsp
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void showView(String jsp, HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {
        getServletConfig().getServletContext().getRequestDispatcher("/views/" + jsp).forward(request, response);
    }
    
    /**
     * Fonction de permettant la connextion
     * @param request 
     * @param response 
     */
    private void newConnect(HttpServletRequest request, HttpServletResponse response, boolean isAd ) 
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        String pwd = (String) session.getAttribute("mdp");
        // Ici ajout de la condition de validité de login et pwd
        if (isAd)
        {
            showView("AdminPage.jsp", request, response);
        } else {
            showView("ClientPagge.jsp", request, response);
        }
        
    }
    // Partie lié au client 
    
    /**
     * Fonction permettant de géré l'ajout d'une commande
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void addCommand(HttpServletRequest request, HttpServletResponse response )
             throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String product = (String) session.getAttribute("produit");
        String company = (String) session.getAttribute("fournisseur");
        int quantite = (int) session.getAttribute("quantite");
        
    }
    
    private void editCommand(HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        
    }
    
    private void deleteCommand(HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        
    }
    
    // Partie lié a l'administrateur
    
    private void view(HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        HttpSession session = request.getSession(); 
        String choix = (String) session.getAttribute("choix");
        if (choix == "Géo")
        {
           // recupére les chiffre selon la zonne  
        } else if (choix == "Client"){
           // récupére les chiffre d'affaire selon le client  
        } else {
           //  récupére les chiffre d'affaire selon les articles
        }
    }
    
    private void addProduct(HttpServletRequest request, HttpServletResponse response )
             throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String product = (String) session.getAttribute("produit");
        String company = (String) session.getAttribute("fournisseur");
        int quantite = (int) session.getAttribute("quantite");
        
    }
    
    private void editProduct(HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        
    }
    
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        
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
