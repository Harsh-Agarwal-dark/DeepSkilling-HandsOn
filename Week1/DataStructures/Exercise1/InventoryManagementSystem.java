package Week1.DataStructures.Exercise1;

import java.util.HashMap;

class Product {
    int prodId;
    String prodName;
    int qty;
    double amount;

    public Product(int prodId, String prodName, int qty, double amount) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.qty = qty;
        this.amount = amount;
    }
    public String toString() {
        return "ID: " + prodId + ", Name: " + prodName + ", Quantity: " + qty + ", Price: " + amount;
    }
}

public class InventoryManagementSystem {

    static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void addProduct(Product product) {
        if (inventory.containsKey(product.prodId)) {
            System.out.println("Product ID already exists");
        } else {
            inventory.put(product.prodId, product);
            System.out.println("Product added");
        }
    }

    public static void updateProduct(int productId, int quantity, double price) {
        if (inventory.containsKey(productId)) {
            Product p = inventory.get(productId);
            p.qty = quantity;
            p.amount = price;
            System.out.println("Product updated");
        } else {
            System.out.println("Product not found");
        }
    }

    public static void deleteProduct(int productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product deleted");
        } else {
            System.out.println("Product not found");
        }
    }

    public static void printInventory() {
        for (Product p : inventory.values())
            System.out.println(p);
    }

    public static void main(String[] args) {
        addProduct(new Product(101, "Television", 50, 20000));
        addProduct(new Product(102, "Air Conditioner", 30, 25000));
        printInventory();
        
        updateProduct(101, 60, 279.0);
        deleteProduct(102);
        printInventory();
    }
}
