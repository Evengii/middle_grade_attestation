package configs;

/*
    Create method to for joining strings to use only one Base URL
 */

public class Config {
    private final static String BASE_URL = "https://demowebshop.tricentis.com/";
    private final static String BOOKS = "https://demowebshop.tricentis.com/books/";
    private final static String COMPUTERS = "https://demowebshop.tricentis.com/computers";
    private final static String DESKTOPS = "https://demowebshop.tricentis.com/desktops";
    private final static String SIMPLE_COMPUTER = "https://demowebshop.tricentis.com/simple-computer";
    private final static String FICTION_BOOK_URL = "https://demowebshop.tricentis.com/fiction";
    private final static String CHECKOUT = "https://demowebshop.tricentis.com/onepagecheckout";
    private final static String LOGIN_CHECKOUT = "https://demowebshop.tricentis.com/login/checkoutasguest?returnUrl=%2Fcart";
    private final static String COMPLETED_CHECKOUT = "https://demowebshop.tricentis.com/checkout/completed/";


    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getBooks() {return BOOKS; }
    public static String getComputers() {return COMPUTERS; }
    public static String getDesktops() {return DESKTOPS; }
    public static String getSimpleComputer() {return SIMPLE_COMPUTER; }

    public static String getFictionBookUrl() {return FICTION_BOOK_URL;}
    public static String getCheckout() {return CHECKOUT;}
    public static String getLoginCheckout() {return LOGIN_CHECKOUT;}
    public static String getCompletedCheckout() {return COMPLETED_CHECKOUT;}
}
