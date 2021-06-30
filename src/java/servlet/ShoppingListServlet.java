
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
        
        
        if(request.getParameter("action") != null && request.getParameter("action").equals("logout")){
           sess.invalidate();
           getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
           return;
       }
          getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 
        HttpSession sess = request.getSession();
        String username = request.getParameter("username");
        String addItems = request.getParameter("addItem");
        String listItems = request.getParameter("list");
         
        
        ArrayList<String> items = (ArrayList<String>) sess.getAttribute("items");
        
        if(items == null){
            items = new ArrayList<>();
    }
       if(request.getParameter("action").equals("add")) {
           items.add(addItems);
       }
       if(request.getParameter("action").equals("delete")){
           items.remove(listItems);
       }
       sess.setAttribute("items", items);
       request.setAttribute("items", sess.getAttribute("items"));
       
       sess.setAttribute("username", username);
       request.setAttribute("username", username);
       getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
       
}
}
