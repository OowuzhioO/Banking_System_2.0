package com.hwj.banking.Service;

import com.hwj.banking.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void addProduct(Product product);
    void updateProduct(Product product);
    Optional<Product> getProduct(int id);
//    Optional<Product> getProduct(int id);
    List<Product> getAllProduct();
    void deleteProduct(int id);
}
