import java.util.ArrayList;

public class Cart{

    private double totalAmount;
    private double totalDiscountAmount;
    private int totalItems;
    private ArrayList<CartItem> cartItems;

    public Cart(){
        cartItems = new ArrayList<>();
        totalAmount = 0;
        totalDiscountAmount = 0;
        totalItems = 0;
    }

    public double getTotalAmount(){
        return this.totalAmount;
    }

    public double getTotalDiscountAmount(){
        return this.totalDiscountAmount;
    }

    public int getTotalItems(){
        return this.totalItems;
    }

    public void addItemToCart(Book book,int quantity){
        CartItem cartItem = new CartItem(book,quantity);
        cartItems.add(cartItem);
        totalItems = totalItems + quantity;
        totalAmount = totalAmount + (book.getBookPrice() * quantity);
    }

    public void addItemToCart(Book book,int quantity,double discount){
        double discountAmount = 0;
        CartItem cartItem = new CartItem(book,quantity);
        cartItems.add(cartItem);
        totalItems = totalItems + quantity;
        discountAmount = (book.getBookPrice()/100) * discount;
        totalDiscountAmount = totalDiscountAmount + discountAmount;
        totalAmount = totalAmount + ((book.getBookPrice() - discountAmount) * quantity);
    }

    public ArrayList<CartItem> getCartItems(){
        return cartItems;
    }

    public ArrayList<CartItem> cartItems() {
        return cartItems;
    }
}

