package model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import model.entity.TypeCustomer;

public class TypeCustomerRepo {

    ArrayList<TypeCustomer> typeCustomerList = new ArrayList<>();

    public void readTxt() {
        typeCustomerList.clear();
        try {
            FileReader fr = new FileReader("/data/TypeCustomer.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                int id = Integer.parseInt(line.split(",")[0]);
                String name = line.split(",")[1];
                TypeCustomer typeCustomer = new TypeCustomer(id, name);
                typeCustomerList.add(typeCustomer);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<TypeCustomer> getAllTypeCustomers(){
        readTxt();
        return typeCustomerList;
    }

    public TypeCustomer getTypeCustomerById(int id){
        readTxt();
        for (TypeCustomer typeCustomer : typeCustomerList) {
            if (typeCustomer.getTypeCustomerId() == id) {
                return typeCustomer;
            }
        }
        return null;
    }

}
