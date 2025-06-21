package Exercise_2_Implementing_The_Factory_Method_Pattern.factories;
import Exercise_2_Implementing_The_Factory_Method_Pattern.documents.Document;
import Exercise_2_Implementing_The_Factory_Method_Pattern.documents.WordDocument;

public class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}