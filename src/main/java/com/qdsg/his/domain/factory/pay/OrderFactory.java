package com.qdsg.his.domain.factory.pay;

import com.qdsg.his.domain.model.pay.OrderPO;
import com.qdsg.his.domain.repository.pay.OrderRepository;
import org.springframework.stereotype.Component;

/**
 * @Author zhouligang
 * @Date 2023/3/6 10:28
 * @Desc 利用工厂创建对象，来保证持久层注入到领域对象
 */
@Component
public class OrderFactory {

    private static OrderRepository orderRepository;

    public OrderFactory(OrderRepository repository){
        OrderFactory.orderRepository=repository;
    }
    public static OrderPO createOrder(){

        return new OrderPO(orderRepository);
    }
}
