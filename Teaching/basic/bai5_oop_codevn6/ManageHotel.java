import java.util.ArrayList;
import java.util.Scanner;

public class ManageHotel {
    static ArrayList<Room> roomList = new ArrayList<>();
    static ArrayList<Customer> customerList = new ArrayList<>();
    static ArrayList<Bill> billList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        roomList.add(new Room("RoomA", 500));
        roomList.add(new Room("RoomB", 300));
        roomList.add(new Room("RoomC", 100));
        customerList.add(new Customer("Tuan", 21, "170785"));
        customerList.add(new Customer("Cuong", 21, "170264"));
        billList.add(new Bill("12", customerList.get(0), roomList.get(0)));
        billList.add(new Bill("30", customerList.get(1), roomList.get(0)));
        billList.add(new Bill("15", customerList.get(0), roomList.get(2)));
        billList.add(new Bill("28", customerList.get(1), roomList.get(1)));
        while (true) {
            System.out.println("HOTEL\n"
                    + "1. Add new customer\n"
                    + "2. Delete customer\n"
                    + "3. Calculate money for rent\n"
                    + "4. Exit");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    deleteCustomer();
                    break;
                case 3:
                    calculateMoney();
                    break;
                case 4:
                    System.out.println("Thank you!!!");
                    return;
                default:
                    break;
            }
        }
    }

    private static void calculateMoney() {
        System.out.println("Input id of customer to calculate:");
        String idCustomer = sc.nextLine();
        Customer customer = new Customer();
        int sumMoney = 0;
        for (Bill bill : billList) {
            if (bill.getCustomer().getIdCustomer().equalsIgnoreCase(idCustomer)) {
                customer = bill.getCustomer();
                sumMoney = sumMoney + (Integer.parseInt(bill.getDateRent()) * bill.getRoom().getPrice());
            }
        }
        System.out.println("Mr/Ms/Mrs " + customer.getName() + " pays: " + sumMoney );
    }

    private static void deleteCustomer() {
        System.out.println("Input id of customer to delete:");
        String idCustomer = sc.nextLine();
        for (Customer customer : customerList) {
            if (customer.getIdCustomer().equals(idCustomer)) {
                System.out.println(customer.toString());
                System.out.println("Do you want to delete this customer? Y||N");
                String key = sc.nextLine();
                if (key.equalsIgnoreCase("Y") || key.equalsIgnoreCase("yes")) {
                    customerList.remove(customer);
                }
            }
        }
    }

    private static void addCustomer() {
        System.out.println("Input name of cusotmer:");
        String name = sc.nextLine();
        System.out.println("Input age of cusotmer:");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Input id of cusotmer:");
        String idCustomer = sc.nextLine();
        Customer customer = new Customer(name, age, idCustomer);
        customerList.add(customer);
    }
}
