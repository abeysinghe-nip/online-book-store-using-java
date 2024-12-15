public class Person{
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    protected UserType userType;

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Enum<UserType> getUserType(){
        return userType;
    }

    public String getUsername(){
        return username;
    }

    protected Person(String firstName,String lastName,String username,String password,UserType userType){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public boolean IsPasswordMatch(String password){
        return this.password.equals(password);
    }

    public boolean getType() {
        return getType();
    }
}

public class Customer extends Person{

    private boolean isLoyaltyCustomer ;

    protected Customer(String firstName, String lastName, String username, String password, UserType userType) {
        super(firstName, lastName, username, password, userType);
    }

    public void User(String firstName, String lastName, String username, String password, boolean isLoyaltyCustomer){
        super(firstName,lastName,username,password,UserType.CUSTOMER);
        this.isLoyaltyCustomer = isLoyaltyCustomer;
    }
}

