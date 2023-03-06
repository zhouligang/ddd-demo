package com.qdsg.his.application.service;

import cn.hutool.core.date.DateUtil;
import com.qdsg.his.application.service.third.DemoOrderThirdService;
import com.qdsg.his.domain.model.pay.OrderPO;
import com.qdsg.his.domain.repository.pay.OrderRepository;
import com.qdsg.his.infrastructure.enums.OrderSourceEnum;
import com.qdsgvision.util.BeanUtil;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author zhouligang
 * @Date 2023/3/6 11:23
 * @Desc
 */
public class OrderService implements IService{

    private DemoOrderThirdService demoOrderThirdService;
    private OrderRepository orderRepository;

    @Transactional(rollbackFor = Exception.class)
    public void userCreateOrder(OrderCreateDTO orderCreateDTO) {
        demoOrderThirdService.createOrder();
        OrderPO orderPO = new OrderPO(orderRepository);
        BeanUtil.copy(orderCreateDTO,orderPO);
        //获取创建订单时间
        Date orderCreateTime = DateUtil.parse(DateUtil.now());
        //设置订单号、订单生成时间、订单创建来源和操作来源为业务平台、操作者为用户id、订单状态为未支付
//        orderPO.setOrderNo(orderNo);
        orderPO.setCreateSource(Integer.valueOf(OrderSourceEnum.businessSource.getCode()));
        orderPO.setOrderCreateTime(orderCreateTime);
        orderPO.setOperateSource(Integer.valueOf(OrderSourceEnum.businessSource.getCode()));
        orderPO.initDateForInsert();
        orderPO.setIsDeleted(0);
        orderPO.saveOrder();
    }
}
