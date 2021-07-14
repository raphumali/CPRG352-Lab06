
package servlet;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;



public class ShoppingListServlet extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        HttpSession sess = request.getSession();
        String action = request.getParameter("action");
        
        
        if(action!=null){
            if(action.equals("logout")){
            sess.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);  
        }
        }
          getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 
        HttpSession sess = request.getSession();
        
        String addItems = request.getParameter("addItem");
        String listItems = request.getParameter("list");
        String action = request.getParameter("action");
         
       
        ArrayList<String> items = (ArrayList<String>) sess.getAttribute("items");
        
        if(items == null){
            items = new ArrayList<>();
    }
        
        if(action!=null) switch(action){
            case "register":
                sess.setAttribute("username", request.getParameter("username"));
                break;
            case "add":
                items.add(addItems);
                sess.setAttribute("items", items);
                break;
            case "delete":
                items.remove(listItems);
                sess.setAttribute("items", items);
                break;
        }
    
       getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
       
}
}
