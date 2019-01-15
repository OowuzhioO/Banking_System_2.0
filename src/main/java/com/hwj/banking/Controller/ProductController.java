package com.hwj.banking.Controller;

import com.hwj.banking.Entity.Product;
import com.hwj.banking.Service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Resource
    ProductService productService;

    @RequestMapping(value = "GetInfo")
    public List<Product> getInfo() {
        return productService.getProduct();
    }


}
