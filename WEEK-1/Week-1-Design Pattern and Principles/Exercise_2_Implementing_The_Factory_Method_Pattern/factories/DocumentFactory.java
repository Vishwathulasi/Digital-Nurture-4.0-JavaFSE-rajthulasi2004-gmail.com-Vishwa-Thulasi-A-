package Exercise_2_Implementing_The_Factory_Method_Pattern.factories;

import Exercise_2_Implementing_The_Factory_Method_Pattern.documents.Document;

public abstract class DocumentFactory {
    public abstract Document createDocument();
}