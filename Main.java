package lab5;

import java.io.IOException;

public class Main {

    public static void main(String args[]) {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() {
        Catalog catalog =
                new Catalog("Java Resources", "catalog.ser");
        Document doc = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);

        try {
            CatalogUtil.save(catalog);
        }
        catch (IOException ex){
            System.out.println("Next error appeared when saving the catalog: " + ex);
        }
    }

    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("catalog.ser");
            Document doc = catalog.findById("java1");
            CatalogUtil.view(doc);
        }
        catch(InvalidCatalogLoadException | InvalidCatalogViewException ex)
        {
            System.out.println("Next error appeared when loading the catalog: " + ex);
        }
    }
}
