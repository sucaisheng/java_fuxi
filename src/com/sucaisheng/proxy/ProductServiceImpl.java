package com.sucaisheng.proxy;

public class ProductServiceImpl implements ProductService{
    @Override
    public void saleProduct(Float money) {
        System.out.println("卖了一台电脑，获得" + money + "钱！");
    }
}
