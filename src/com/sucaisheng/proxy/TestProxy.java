package com.sucaisheng.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();
        /**
         * 使用基于接口的动态代理
         */
        ProductService ProxyproductService = (ProductService) Proxy.newProxyInstance(productService.getClass().getClassLoader(), productService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object objValue = null;
                Float money = (Float) args[0];
                objValue = method.invoke(productService, money * 0.8f);
                return objValue;
            }
        });
        ProxyproductService.saleProduct(10000f);
    }
}
