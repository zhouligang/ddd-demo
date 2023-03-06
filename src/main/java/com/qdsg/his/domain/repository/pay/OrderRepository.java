package com.qdsg.his.domain.repository.pay;

import com.qdsg.his.domain.model.pay.OrderPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author zhouligang
 * @Date 2023/3/6 10:24
 * @Desc
 */
public interface OrderRepository {
    List<OrderPO> selectByStatus();

    int updateShipmentStatus(Long id, Integer orderStatus);

    void updateOrderVerify(Long id, String orderStatus);

    List<OrderPO> selectByMachineIdAndIdcard(
            @Param("machineId") String machineId,
            @Param("idCard") String idCard);

    void saveOrder();
}
