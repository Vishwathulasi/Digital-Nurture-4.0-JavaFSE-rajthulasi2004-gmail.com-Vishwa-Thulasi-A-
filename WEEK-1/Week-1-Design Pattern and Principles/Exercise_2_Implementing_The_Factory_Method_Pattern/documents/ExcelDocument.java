package Exercise_2_Implementing_The_Factory_Method_Pattern.documents;

public class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel Document");
    }
}
