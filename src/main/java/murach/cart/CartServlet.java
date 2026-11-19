package murach.cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import murach.business.*;
import murach.data.ProductIO;
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String url= "/index.html";
    String action = request.getParameter("action");
    if (action == null){
        action = "cart";
    }
    if (action.equals("shop")){
        url = "/index.html";
    }else if (action.equals("cart")){
        String productCode = request.getParameter("productCode");
        String quantityString = request.getParameter("quantity");

        HttpSession  session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if ( cart==null){
            cart = new Cart();
        }
        int quantity;
        try {
            quantity = Integer.parseInt(quantityString);
            if (quantity < 0) {
                quantity = 1;
            }
        }
        catch (NumberFormatException nfe){
            quantity =1 ;
        }
        Product product = ProductIO.getProduct(productCode);
        if (product!= null){
            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);

            if(quantity>0){
                cart.addItems(lineItem);
            }
            else{
                cart.removeItems(lineItem);
            }
        }
        session.setAttribute("cart", cart);
        url = "/cart.jsp";
        }
    else if (action.equals("checkout")){
        url = "/checkout.jsp";
    }
    else if (action.equals("complete")){
        HttpSession  session = request.getSession();
        session.removeAttribute("cart");
        url = "/index.html";
    }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
