package lab5;

public class InvalidCatalogLoadException extends Exception {
    public InvalidCatalogLoadException(Exception ex) {
        super("Invalid catalog file", ex);
    }
}
