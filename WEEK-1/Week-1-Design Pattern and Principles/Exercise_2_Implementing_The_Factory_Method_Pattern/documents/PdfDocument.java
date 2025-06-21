package Exercise_2_Implementing_The_Factory_Method_Pattern.documents;

public class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF Document");
    }
}