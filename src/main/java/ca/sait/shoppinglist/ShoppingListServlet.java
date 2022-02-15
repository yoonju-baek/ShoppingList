package ca.sait.shoppinglist;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yoonju Baek
 */
public class ShoppingListServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        
        String username = (String)session.getAttribute("username");
        
        if(username == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        else {
            String query = request.getQueryString();
        
            if(query != null && query.contains("logout")) {
                session.invalidate();
                
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
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
        HttpSession session = request.getSession();
                
        String action = request.getParameter("action");
        
        if(action != null && action.equals("add")) {
            String item = request.getParameter("item");
            
            ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
            
            items.add(item);
            
            session.setAttribute("items", items);
        }
        else if(action != null && action.equals("delete")) {
             String item = request.getParameter("item");
             
             
            ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");      
            items.remove(item);
            session.setAttribute("items", items);    
        }
        else if(action != null && action.equals("register")) {
            String username = request.getParameter("username");

            ArrayList<String> items = new ArrayList<>();
            
            session.setAttribute("username", username);
            session.setAttribute("items", items);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
}
