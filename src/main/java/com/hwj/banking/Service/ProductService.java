package com.hwj.banking.Service;

import com.hwj.banking.Entity.Product;
import com.hwj.banking.Param.ProductParam;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void addProduct(ProductParam productParam);
    void updateProduct(ProductParam productParam);
    Optional<Product> getProduct(int id);
//    Optional<Product> getProduct(int id);
    List<Product> getAllProduct();
    void deleteProduct(int id);
}
