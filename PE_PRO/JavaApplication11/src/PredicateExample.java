
import java.util.ArrayList;
import java.util.function.Predicate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vannhat
 */
public class PredicateExample {

    public void search(Predicate<Customer> p) {
        ArrayList<Customer> newList = new ArrayList<>();
        int count = 0;
        for (Customer customer : danhSach) {
            if (p.test(customer)) {
                newList.add(customer);
                count++;
            }
        }
        listAll(newList);
        System.out.println("-------------------------");
        System.out.println("Count : " + count);
    }
    
}
