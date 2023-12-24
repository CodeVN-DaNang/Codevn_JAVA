package model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import model.entities.TypeCustomer;

public class TypeCustomerRepo {
    ArrayList<TypeCustomer> typeCustomerList = new ArrayList<>();

    public void read() {
        typeCustomerList.clear();
        try {
            FileReader fr = new FileReader("/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/library_demo_codevn7/src/data/TypeCustomer.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String arr[] = line.split(",");
                String typeCustomerId = arr[0];
                String typeCustomerName = arr[1];
                TypeCustomer typeCustomer = new TypeCustomer(typeCustomerId, typeCustomerName);
                typeCustomerList.add(typeCustomer);
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<TypeCustomer> getAllCustomers(){
        read();
        return this.typeCustomerList;
    }

    public TypeCustomer getTypeCustomerById(String id){
        read();
        for (TypeCustomer typeCustomer : typeCustomerList) {
            if (typeCustomer.getTypeCustomerId().equals(id)) {
                return typeCustomer;
            }
        }
        return null;
    }

}
