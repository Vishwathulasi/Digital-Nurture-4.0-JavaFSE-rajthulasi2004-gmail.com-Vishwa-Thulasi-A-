package Exercise_2_Implementing_The_Factory_Method_Pattern;

import Exercise_2_Implementing_The_Factory_Method_Pattern.documents.Document;

import Exercise_2_Implementing_The_Factory_Method_Pattern.factories.*;



public class Exercise2 {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}
