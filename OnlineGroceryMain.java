package groceryproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class OnlineGroceryMain implements OnlineGrocery {
    
    private static final String USERNAME = "Harika";
    private static final String PASSWORD = "12345";

    public static class Product {
        private long id;
        private String item;
        private String location;
        private double price;

        public Product(long id, String item, String location, double price) {
            this.id = id;
            this.item = item;
            this.location = location;
            this.price = price;
        }

        // Getters and Setters for the properties
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product ID: " + id + ", Item: " + item + ", Location: " + location + ", Price: " + price;
        }
    }

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to GroceryMart!");
        
        int attempts = 3; // Number of login attempts allowed
        boolean loggedIn = false;
        
        while (attempts > 0 && !loggedIn) {
            System.out.print("Enter username: ");
            String enteredUsername = sc.nextLine();
            
            System.out.print("Enter password: ");
            String enteredPassword = sc.nextLine();
            
            if (enteredUsername.equals(USERNAME) && enteredPassword.equals(PASSWORD)) {
                System.out.println("Login successful! Welcome, " + USERNAME + "!");
                loggedIn = true;
            } else {
                System.out.println("Login failed. Please try again. Attempts left: " + (attempts - 1));
                attempts--;
            }
        }
        
        if (!loggedIn) {
            System.out.println("Login attempts exhausted. Exiting the application.");
        } else {
            int choice;
            do {
                System.out.println("1. Add a product");
                System.out.println("2. View products");
                System.out.println("3. Search for a product");
                System.out.println("4. Delete a product");
                System.out.println("5. Update a product");
                System.out.println("6. Exit");
                System.out.println("7. Logout");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter item: ");
                        String item = sc.next();
                        System.out.println("Enter price: ");
                        double price = sc.nextDouble();
                        System.out.println("Enter location: ");
                        String location = sc.next();
                        System.out.println("Enter ID: ");
                        long id = sc.nextLong();
                        products.add(new Product(id, item, location, price)); 
                        break;
                    case 2:
                        for (Product product : products) {
                            System.out.println(product);
                        }
                        break;

                    case 3:
                        System.out.print("Enter product ID to search: ");
                        long productId = sc.nextLong();
                        boolean found = false;
                        for (Product product : products) {
                            if (product.getId() == productId) {
                                System.out.println(product);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Record not found");
                        }
                        break;

                    case 4:
                        System.out.print("Enter ID to delete: ");
                        long deleteId = sc.nextLong();
                        Iterator<Product> iterator = products.iterator();
                        while (iterator.hasNext()) {
                            if (iterator.next().getId() == deleteId) {
                                iterator.remove();
                                System.out.println("Record is deleted.");
                                break;
                            }
                        }
                        break;

                    case 5:
                        System.out.print("Enter ID to update: ");
                        long updateId = sc.nextLong();
                        for (Product product : products) {
                            if (product.getId() == updateId) {
                                System.out.println("Enter updated item: ");
                                String updatedItem = sc.next();
                                System.out.println("Enter updated location: ");
                                String updatedLocation = sc.next();
                                System.out.println("Enter updated price: ");
                                double updatedPrice = sc.nextDouble();
                                product.setItem(updatedItem);
                                product.setLocation(updatedLocation);
                                product.setPrice(updatedPrice);
                                System.out.println("Record is updated.");
                                break;
                            }
                        }
                        break;

                    case 6:
                        System.out.println("Thank you for visiting GroceryMart!");
                        break;
                    case 7:
                        loggedIn = false;
                        System.out.println("Logged out. Exiting the application.");
                        break;
                }
            } while (choice > 0 && choice <= 7);
        }
        sc.close();
    }
}
