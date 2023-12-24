package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.entity.TypeCustomer;

public class TypeCustomerRepository {

    public ArrayList<TypeCustomer> getAllTypeCustomer() throws IOException {
        ArrayList<TypeCustomer> typeCustomers = new ArrayList<>();
        FileReader fr = new FileReader(
                "/Users/vannhat/Documents/java/NHATTV_JAVA/teaching/demo_codevn4/data/typecustomer.txt");
        BufferedReader bf = new BufferedReader(fr);
        String st;
        while ((st = bf.readLine()) != null) {
            int idTypeCustomer = Integer.parseInt(st.split(",")[0]);
            String nameTypeCustomer = st.split(",")[1];
            TypeCustomer typeCustomer = new TypeCustomer(idTypeCustomer, nameTypeCustomer);
            typeCustomers.add(typeCustomer);
        }
        bf.close();
        fr.close();
        return typeCustomers;
    }

    public TypeCustomer getTypeCustomerById(int idTypeCustomer) throws IOException {
        ArrayList<TypeCustomer> typeCustomers = getAllTypeCustomer();
        for (TypeCustomer typeCustomer : typeCustomers) {
            if (typeCustomer.getIdTypeCustomer() == idTypeCustomer) {
                return typeCustomer;
            }
        }
        return null;
    }

}
