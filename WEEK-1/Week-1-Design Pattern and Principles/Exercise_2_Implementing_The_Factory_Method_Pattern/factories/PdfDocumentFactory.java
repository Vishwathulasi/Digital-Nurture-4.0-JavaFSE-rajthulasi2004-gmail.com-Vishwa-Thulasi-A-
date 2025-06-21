package Exercise_2_Implementing_The_Factory_Method_Pattern.factories;
import Exercise_2_Implementing_The_Factory_Method_Pattern.documents.Document;
import Exercise_2_Implementing_The_Factory_Method_Pattern.documents.PdfDocument;

public class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}