package com.hwj.banking.ServiceImp;

import com.hwj.banking.Dao.ProductDao;
import com.hwj.banking.Entity.Product;
import com.hwj.banking.Param.ProductParam;
import com.hwj.banking.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public void addProduct(ProductParam productParam) {
        Product product = new Product();
        product.setName(productParam.getName());
        product.setPrice(productParam.getPrice());
        productDao.save(product);
    }

    @Override
    public void updateProduct(ProductParam productParam) {
        Product product = new Product();
        product.setPid(productParam.getPid());
        product.setName(productParam.getName());
        product.setPrice(productParam.getPrice());
        productDao.save(product);
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
