package com.qdsg.his.infrastructure.persistence.pay;

import com.qdsg.his.domain.model.pay.OrderPO;
import com.qdsg.his.domain.repository.pay.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zhouligang
 * @Date 2023/3/6 10:25
 * @Desc
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Resource
    private OrderDao orderDao;

    @Override
    public List<OrderPO> selectByStatus() {
        return orderDao.selectByStatus();
    }

    @Override
    public int updateShipmentStatus(Long id, Integer orderStatus) {
        return orderDao.updateShipmentStatus(id,orderStatus);
    }

    @Override
    public void updateOrderVerify(Long id, String orderStatus) {
        orderDao.updateOrderVerify(id,orderStatus);
    }

    @Override
    public List<OrderPO> selectByMachineIdAndIdcard(String machineId, String idCard) {
        return orderDao.selectByMachineIdAndIdcard(machineId, idCard);
    }

    @Override
    public void saveOrder() {

    }
}
