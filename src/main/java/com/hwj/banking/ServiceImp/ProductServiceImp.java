package com.hwj.banking.ServiceImp;

import com.hwj.banking.Dao.ProductDao;
import com.hwj.banking.Entity.Product;
import com.hwj.banking.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    @Transactional
    public Product getProduct() {
        return productDao.getProduct();
    }
}
