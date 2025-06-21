package Exercise_2_Implementing_The_Factory_Method_Pattern.factories;
import Exercise_2_Implementing_The_Factory_Method_Pattern.documents.Document;
import Exercise_2_Implementing_The_Factory_Method_Pattern.documents.ExcelDocument;

public class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}
