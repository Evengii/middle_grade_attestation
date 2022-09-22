package configs;

/*
    Create method to for joining strings to use only one Base URL
 */

public class Config {
    private final static String BASE_URL = "https://demowebshop.tricentis.com/";
    private final static String BOOKS = BASE_URL + "books";
    private final static String COMPUTERS = BASE_URL + "computers";
    private final static String DESKTOPS = BASE_URL + "desktops";
    private final static String SIMPLE_COMPUTER = BASE_URL + "simple-computer";
    private final static String FICTION_BOOK_URL = BASE_URL + "fiction";
    private final static String CHECKOUT = BASE_URL + "onepagecheckout";
    private final static String LOGIN_CHECKOUT = BASE_URL + "login/checkoutasguest?returnUrl=%2Fcart";
    private final static String COMPLETED_CHECKOUT = BASE_URL + "completed";

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
