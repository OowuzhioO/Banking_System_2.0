package com.hwj.banking.Param;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductParam {

    private Integer pid;

    @NotBlank(message = "product name should not be null")
    @Length(min = 1, max = 20, message = "product name should be set in 20 letters")
    private String name;

    @NotNull(message = "product should have a price")
    private Double price;

    public ProductParam() {
    }

    public ProductParam(@NotBlank(message = "product name should not be null") @Length(min = 1, max = 20, message = "product name should be set in 20 letters") String name, @NotNull(message = "product should have a price") Double price) {
        this.name = name;
        this.price = price;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
