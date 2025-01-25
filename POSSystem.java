import java.util.*;

class Car 
{
    private int carId;
    private String model;
    private double price;
    private int stock;
    private String engine;
    private double power;
    private double torque;
    private String transmission;
    private int topSpeed;
    private String driveType;
    private double rating;
    private String safetyRating;

    public Car(int carId, String model, double price, int stock, String engine, double power, double torque, String transmission, int topSpeed, String driveType, double rating, String safetyRating) 
    {
        this.carId = carId;
        this.model = model;
        this.price = price;
        this.stock = stock;
        this.engine = engine;
        this.power = power;
        this.torque = torque;
        this.transmission = transmission;
        this.topSpeed = topSpeed;
        this.driveType = driveType;
        this.rating = rating;
        this.safetyRating = safetyRating;
    }
    public int getCarId()
    {
        return carId;
    }
    public String getModel()
    {
        return model;
    }
    public double getPrice()
    {
        return price;
    }
    public int getStock()
    {
        return stock;
    }
    public void setStock(int stock)
    {
        this.stock = stock;
    }
    public String getEngine() 
    {
        return engine;
    }
    public double getPower() 
    {
        return power;
    }
    public double getTorque()
    {
        return torque;
    }
    public String getTransmission()
    {
        return transmission;
    }
    public int getTopSpeed() {
        return topSpeed;
    }
    public String getDriveType() {
        return driveType;
    }
    public double getRating() 
    {
        return rating;
    }
    public String getSafetyRating() 
    {
        return safetyRating;
    }
    public String toString() 
    {
        return "Car ID: " + carId + "\nModel: " + model + "\nPrice: Rs." + price + " Lakh\nStock: " + stock + "\nEngine: " + engine + "\nPower: " + power + " bhp\nTorque: " + torque + " Nm\nTransmission: " + transmission + "\nTop Speed: " + topSpeed + " kmph\nDrive Type: " + driveType + "\nRating: " + rating + "\nSafety Rating: " + safetyRating;
    }
}
class Customer 
{
    private int customerId;
    private String name;
    public Customer(int customerId, String name) 
    {
        this.customerId = customerId;
        this.name = name;
    }
    public int getCustomerId() 
    {
        return customerId;
    }
    public String getName()
    {
        return name;
    }
     public String toString() 
     {
        return "Customer ID: " + customerId + ", Name: " + name;
    }
}
class Showroom 
{
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    public Showroom(String name, String address, String contactNumber, String email)
    {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
    }
    public void displayShowroomDetails() {
        System.out.println("\n--- Showroom Details ---");
        System.out.println("Showroom Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Email: " + email);
    }
    public String getShowroomDetails() {
        return "\nShowroom Name: " + name +
               "\nAddress: " + address +
               "\nContact Number: " + contactNumber +
               "\nEmail: " + email;
    }
}
class Invoice {
    private Customer customer;
    private List<Car> cars;
    private double total;
    private double taxRate;
    private Showroom showroom;
    public Invoice(Customer customer, Showroom showroom, double taxRate)
    {
        this.customer = customer;
        this.showroom = showroom;
        this.cars = new ArrayList<>();
        this.taxRate = taxRate;
    }
    public void addCar(Car car, int quantity)
    {
        if (car.getStock() >= quantity)
        {
            cars.add(car);
            total += car.getPrice() * quantity;
            car.setStock(car.getStock() - quantity);
        } else {
            System.out.println("Insufficient stock for car: " + car.getModel());
        }
    }
    public double calculateTotalWithTax() {
        return total + (total * taxRate);
    }
    public void printInvoice() {
        System.out.println("\n--- Invoice for " + customer.getName() + " ---");
        System.out.println(showroom.getShowroomDetails());
        for (Car car : cars) {
            System.out.println("\n" + car);
        }
        System.out.println("Total: Rs." + total + " Lakh");
        System.out.println("Total with Tax: Rs." + calculateTotalWithTax() + " Lakh");
    }
}
public class POSSystem 
{
    private static Map<Integer, Car> inventory = new HashMap<>();
    private static Map<Integer, Customer> customers = new HashMap<>();
    private static Showroom showroom = new Showroom("EnergyHub", "6-3-569, Khairatabad Rd, opp. RTA Office, Somajiguda, Hyderabad, Telangana 500082", "+91 9000000000", "energyhub@gmail.com");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inventory.put(1, new Car(1, "BMW 3 Series", 74.90, 5, "2998 cc", 368.78, 500, "Automatic", 253, "4WD", 4.2, "5 Star"));
        inventory.put(2, new Car(2, "BMW M4 Competition", 153.00, 3, "2993 cc", 503, 650, "Automatic", 250, "AWD", 4.6, "5 Star"));
        inventory.put(3, new Car(3, "BMW M4 CS", 189.00, 2, "2993 cc", 543, 650, "Automatic", 280, "AWD", 4.6, "5 Star"));
        inventory.put(4, new Car(4, "BMW M8 Coupe Competition", 244.00, 4, "4395 cc", 616.87, 800, "Automatic", 305, "AWD", 4.3, "5 Star"));
        customers.put(1, new Customer(1, "Jagan Goginani"));
        customers.put(2, new Customer(2, "Ramesh raj Rangaesta"));
        customers.put(3, new Customer(5, "Tisha sanika"));
        customers.put(4, new Customer(4, "Badhra Bobile"));
        while (true) {
            System.out.println("\n--- Retail POS System ---");
            System.out.println("1. View Cars");
            System.out.println("2. View Customers");
            System.out.println("3. Create Invoice");
            System.out.println("4. View Showroom Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n--- Cars ---");
                    for (Car car : inventory.values())
                    {
                        System.out.println(car);
                    }
                    break;
                case 2:
                    System.out.println("\n--- Customers ---");
                    for (Customer customer : customers.values())
                    {
                        System.out.println(customer);
                    }
                    break;
                case 3:
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    Customer customer = customers.get(customerId);
                    if (customer == null) {
                        System.out.println("Customer not found!");
                        break;
                    }
                    Invoice invoice = new Invoice(customer, showroom, 0.18); 
                    while (true) {
                        System.out.print("Enter Car ID to add (or 0 to finish): ");
                        int carId = scanner.nextInt();
                        if (carId == 0) break;
                        Car carFromInventory = inventory.get(carId);
                        if (carFromInventory == null) {
                            System.out.println("Car not found!");
                            continue;
                        }
                        System.out.print("Enter Quantity: ");
                        int quantity = scanner.nextInt();
                        invoice.addCar(carFromInventory, quantity);
                    }
                    invoice.printInvoice();
                    break;
                case 4:
                    showroom.displayShowroomDetails();
                    break;
                case 5:
                    System.out.println("Thank You!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}