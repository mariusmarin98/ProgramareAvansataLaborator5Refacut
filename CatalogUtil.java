package lab5;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath())))
        {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogLoadException {
        try
        {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream(path));
            return (Catalog)oos.readObject();
        }
        catch(IOException | ClassNotFoundException ex)
        {
            throw new InvalidCatalogLoadException(ex);
        }
    }

    public static void view(Document doc) throws InvalidCatalogViewException {
        Desktop desktop = Desktop.getDesktop();

        String location = doc.getLocation();

        if (location.startsWith("http"))
        {
            try {
                URI uri = new URI(location);
                desktop.browse(uri);
            }
            catch(URISyntaxException | IOException ex)
            {
                throw new InvalidCatalogViewException(ex);
            }
        }
    }
}
