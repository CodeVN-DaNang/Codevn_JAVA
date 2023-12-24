package model.repository;

import java.util.ArrayList;

import model.entity.TypeProduct;

public class TypeProductRepository {
    ArrayList<TypeProduct> typeProductList = new ArrayList<>();

    public ArrayList<TypeProduct> getAllTypeProduct(){
        return typeProductList;
    }

    public TypeProduct getTypeProductById(int id){
        for (int i = 0; i < typeProductList.size(); i++) {
            if (id == typeProductList.get(i).getTypeProductId()) {
                return typeProductList.get(i);
            }
        }
        return null;
    }
}
