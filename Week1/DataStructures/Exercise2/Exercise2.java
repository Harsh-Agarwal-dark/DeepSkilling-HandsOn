package Week1.DataStructures.Exercise2;

import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return "[" + productId + "] " + productName + " (" + category + ")";
    }
}

class SearchUtil {

    // Linear search by productName
    public static Product linearSearch(Product[] prods, String targ) {
        for (Product p : prods) {
            if (p.productName.equalsIgnoreCase(targ)) {
                return p;
            }
        }
        return null;
    }

    // Binary search by productName (array must be sorted by productName)
    public static Product binarySearch(Product[] prods, String targ) {
        int low = 0, high = prods.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = prods[mid].productName.compareToIgnoreCase(targ);
            if (cmp == 0)
                return prods[mid];
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        Product[] products = {
            new Product(201, "Laptop", "Electronics"),
            new Product(202, "T-Shirt", "Apparel"),
            new Product(203, "Shoes", "Footwear"),
            new Product(204, "Headphones", "Electronics"),
            new Product(205, "Backpack", "Accessories")
        };

        System.out.println("Linear Search:");
        Product result1 = SearchUtil.linearSearch(products, "Shoes");
        System.out.println(result1 != null ? result1 : "Product not found");

        // Sort before binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("Binary Search:");
        Product result2 = SearchUtil.binarySearch(products, "Shoes");
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}
