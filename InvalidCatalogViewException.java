package lab5;

public class InvalidCatalogViewException extends Exception{
    public InvalidCatalogViewException(Exception ex) {
        super("Invalid catalog attributes / file", ex);
    }
}
