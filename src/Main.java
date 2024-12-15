import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Person> users = new ArrayList<>();
    public static ArrayList<Book> books = new ArrayList<>();
    public static Person activeUser;
    public static Cart cart;

    public static void createBooks() {
        Book book = new Book("Leaves of Grass by Walt Whitman ", Book.BookType.Poetry);
        Book book1 = new Book("House of Light by Mary Oliver", Book.BookType.Poetry);
        Book book2 = new Book("The Sun and Her Flowers by Rupi Kaur", Book.BookType.Poetry);
        books.add(book);
        books.add(book1);
        books.add(book2);
        Book book3 = new Book("The Adventures of Tom Sawyer", Book.BookType.Classics);
        Book book4 = new Book("The Secret Garden", Book.BookType.Classics);
        Book book5 = new Book("The Diary of a Young Girl", Book.BookType.Classics);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        Book book6 = new Book("The Lost Dreamer", Book.BookType.Fantasy);
        Book book7 = new Book("Only a Monster", Book.BookType.Fantasy);
        Book book8 = new Book("Nettle & Bone", Book.BookType.Fantasy);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        Book book9 = new Book("The Shining", Book.BookType.Horror);
        Book book10 = new Book("Rebecca", Book.BookType.Horror);
        Book book11 = new Book("The Hunger", Book.BookType.Horror);
        books.add(book9);
        books.add(book10);
        books.add(book11);
        Book book12 = new Book("Beloved", Book.BookType.Novels);
        Book book13 = new Book("Emma",Book.BookType.Novels);
        Book book14 = new Book("Invisible Man", Book.BookType.Horror);
        books.add(book12);
        books.add(book13);
        books.add(book14);
        Book book15 = new Book("Reminders of Him", Book.BookType.Romance);
        Book book16 = new Book("Vision in White", Book.BookType.Romance);
        Book book17 = new Book("One Last Stop", Book.BookType.Romance);
        books.add(book15);
        books.add(book16);
        books.add(book17);
    }

    public static void createusers() {
        Person naduni = new User("Naduni","Perera","Naduni", "mynum115", User.UserType.ADMIN);
        users.add(naduni);
        Person chamika = new User("Chamika","Kumara","Chamika", "its217", User.UserType.USER);
        users.add(chamika);
    }

    public static void login() {
        for (Person user : users) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Username:");
            String username = scanner.next();
            System.out.println("password:");
            String password = scanner.next();
            if (user.getUsername().equals(username) && user.IsPasswordMatch(password)) {
                System.out.println("You have been logged in successfully.");
                activeUser = user;
            }
        }
    }

    public static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("First name:");
        String firstName = scanner.next();
        System.out.println("Last name:");
        String lastName = scanner.next();
        System.out.println("User name:");
        String username = scanner.next();
        System.out.println("password:");
        String password = scanner.next();

        Person newUser = new User(firstName,lastName,username, password, User.UserType.USER);
        activeUser = newUser;
        users.add(newUser);
        System.out.println("You have been registered successfully.");
    }

    public static void addBookToCart() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        for (int i = 0; i < 18; i++) {
            System.out.println(i + "-" + books.get(i).getBookName());
        }
        choice = scanner.nextInt() % 18;
        if (activeUser.getType() == User.UserType.ADMIN || activeUser.getType() == User.UserType.USER) {
            // please capture the no of quantity and pass it to the addItemToCart method
            cart.addItemToCart(books.get(choice),1);
            //cart += books.get(choice).getBookPrice();
        }else {
            // over loaded method
            cart.addItemToCart(books.get(choice),1,1.5);
            //cart += books.get(choice).getBookPrice() * 1.5;
        }
        System.out.println("Total Amount : Rs. " + cart.getTotalAmount());

        if (activeUser.getType() == User.UserType.CUSTOMER) {
            choice = 0;
            System.out.println("Do you want to login as user? (1: Yes,2: No)");
            choice = scanner.nextInt();
            if (choice == 1) {
                register();
            }
            else {
                System.out.println("Do you want to buy more book or exit?(press1 to exit.)");
                int option = scanner.nextInt();
                if (option == 1) {
                    System.out.println("Thank you for choosing us.Hope to see you again dear customer.");
                    System.exit(0);
                }
            }
        }
    }

    public static void pay() {
        System.out.println("Thank you " + activeUser.getUsername() + "!" +  "\nYou paid Rs."+  cart.getTotalAmount());
        newCart();
    }

    public static void newCart(){
        cart = new Cart();
    }

    public static void main(String[] args) {
        createusers();
        createBooks();
        newCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = 0;
            if (activeUser == null) {

                System.out.println("Welcome to the Akura Book Paradise.");
                System.out.println("There are the options:");
                String options = "1 - login as an user\n"
                        + "2 - Buy as a customer\n"
                        + "3 - Exit the system";
                System.out.println(options);
                choice = scanner.nextInt();
                if (choice == 1) {
                    login();
                } else if (choice == 2) {
                    activeUser = new User("Temporary user", "test123", User.UserType.CUSTOMER);
                    addBookToCart();
                } else {
                    break;
                }

            } else {
                System.out.println("1 - Buy a book");
                if (cart.cartItems() != 0)) {
                    System.out.println("2 - pay");
                    System.out.println("3 -shutdown");
                } else {
                    System.out.println("2- shut down");
                }
                choice = scanner.nextInt();
                if (choice == 1) {
                    addBookToCart();
                } else if (cart != 0 && choice == 2) {
                    pay();

                } else {
                    System.out.println("Thank you for choosing us dear customer.Hope to see you again!");
                    break;
                }
            }
        }
    }
}