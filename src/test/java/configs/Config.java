package configs;

public class Config {
    private final static String BASE_URL = "https://demowebshop.tricentis.com/";
    private final static String BOOKS = "https://demowebshop.tricentis.com/books/";
    private final static String FICTION_BOOK_URL = "https://demowebshop.tricentis.com/fiction";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getBooks() {return BOOKS; }

    public static String getFictionBookUrl() {return FICTION_BOOK_URL;}
}
