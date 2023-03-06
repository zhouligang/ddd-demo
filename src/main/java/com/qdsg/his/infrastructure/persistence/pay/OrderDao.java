package com.qdsg.his.infrastructure.persistence.pay;

import com.qdsg.his.domain.model.pay.OrderPO;
import com.qdsgvision.orm.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author zhouligang
 * @Date 2023/3/6 10:09
 * @Desc
 */
public interface OrderDao extends BaseDao<OrderPO> {

    List<OrderPO> selectByStatus();

    int updateShipmentStatus(Long id, Integer orderStatus);

    void updateOrderVerify(Long id, String orderStatus);

    List<OrderPO> selectByMachineIdAndIdcard(
            @Param("machineId") String machineId,
            @Param("idCard") String idCard);

}
