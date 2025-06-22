package Exercise6;

interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading image from remote server: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // Lazy initialization
        } else {
            System.out.println("Image already loaded: " + filename);
        }
        realImage.display(); // Delegate display
    }
}

public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("nature.jpg");
        Image image2 = new ProxyImage("city.jpg");

        System.out.println("\nFirst time displaying image1:");
        image1.display();  // loads + displays

        System.out.println("\nSecond time displaying image1:");
        image1.display();  // cached, only displays

        System.out.println("\nDisplaying image2:");
        image2.display();
    }
}
