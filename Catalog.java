package lab5;

import java.io.File;
import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    Catalog(String name, String path)
    {
        File currentDirFile = new File(".");
        String absolutePath = currentDirFile.getAbsolutePath();

        this.name = name;
        this.path = absolutePath.substring(0, absolutePath.length() - 1) + path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void add(Document doc) {
        documents.add(doc);
    }
    public Document findById(String id) {
        for (Document doc : documents) {
            if (doc.getId().equals(id)) {
                return doc;
            }
        }
        return null;
    }

    public Document findByIdFancy(String id) {
        return documents.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }
}

