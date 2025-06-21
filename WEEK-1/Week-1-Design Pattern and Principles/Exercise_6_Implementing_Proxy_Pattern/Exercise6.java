package Exercise_6_Implementing_Proxy_Pattern;

import java.util.HashMap;
import java.util.Map;
interface Image {
    void display();
}

class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image from remote server: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}

class ProxyImage implements Image {
    private String fileName;
    private static Map<String, RealImage> imageCache = new HashMap<>();

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        RealImage realImage = imageCache.get(fileName);
        if (realImage == null) {
            realImage = new RealImage(fileName); // Lazy load
            imageCache.put(fileName, realImage); // Cache it
        } else {
            System.out.println("Loaded from cache: " + fileName);
        }
        realImage.display();
    }
}

public class Exercise6 {
        public static void main(String[] args) {
        Image image1 = new ProxyImage("flower.jpg");
        Image image2 = new ProxyImage("sunset.jpg");

        image1.display();
        image2.display();

        System.out.println();

        image1.display();
        image2.display();
    }
}
