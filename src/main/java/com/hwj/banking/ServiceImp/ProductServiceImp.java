package com.hwj.banking.ServiceImp;

import com.hwj.banking.Dao.ProductDao;
import com.hwj.banking.Entity.Product;
import com.hwj.banking.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public void addProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        Product product1 = productDao.save(product);
        System.out.println("ServiceImp update pid: " + product1.getPid());
    }

    @Override
    public Optional<Product> getProduct(int id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> getAllProduct() {
        return (List<Product>) productDao.findAll();
    }

    @Override
    public void deleteProduct(int id) {
        productDao.deleteById(id);
    }
}
