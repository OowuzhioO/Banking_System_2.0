package com.hwj.banking.Controller;

import com.hwj.banking.Entity.Product;
import com.hwj.banking.Param.ProductParam;
import com.hwj.banking.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/getAllProduct")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

//    @PostMapping("/addProduct")
//    public String addProduct(@RequestBody Product product) {
//        productService.addProduct(product);
//        return "add Product successfully";
//    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody ProductParam productParam) {
        productService.addProduct(productParam);
        return "add Product successfully";
    }


    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return "delete Product successfully";
    }

    @PutMapping("/updateProduct")
    public String updateProduct(ProductParam productParam){
        System.out.println("contorller uodate pid : " + productParam.getPid());
        productService.updateProduct(productParam);
        return "update Product successfully";
    }

    @GetMapping("/queryAllProduct")
    public String queryAllProduct(){
        List<Product> products = productService.getAllProduct();
        for (Product product : products) {
            System.out.println(product);
        }
        return "query all products successfully!";
    }

    @GetMapping("/queryProduct/{id}")
    public String queryProduct(@PathVariable int id){
        Optional<Product> product = productService.getProduct(id);
        System.out.println(product);
        return "query one product successfully!";
    }
}
