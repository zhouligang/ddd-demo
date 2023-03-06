package com.qdsg.his.domain.model.pay;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qdsg.his.domain.AggregateRoot;
import com.qdsg.his.domain.repository.pay.OrderRepository;
import com.qdsgvision.orm.pojo.po.BasePO;
import com.qdsgvision.orm.typehandler.AESStringTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author zhouligang
 * @Date 2023/3/6 10:07
 * @Desc
 */
@Data
@Table(name = "order_rec")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AggregateRoot
public class OrderPO extends BasePO implements Serializable {

    private static final long serialVersionUID = 1653280349594L;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 用户id
     （身份证id
     社保id
     人脸id
     传三者中的一个）
     */
    @ColumnType(typeHandler = AESStringTypeHandler.class)
    private String userId;

    @ColumnType(typeHandler = AESStringTypeHandler.class)
    private String certNo;

    private String cardType;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户留言
     */
    private String userNote;

    /**
     * 用户是否评价（1 评价 2 未评价）
     */
    private Integer userRate;

    /**
     * 业务号 有处方的必须传所选择的处方id，可传多个，格式：如选择了三个处方（1，2，3）
     零售的可为空

     */
    private String businessNo;

    /**
     * 业务类型 1 有处方
     2 零售

     */
    private Integer bisType;

    /**
     * 机器编号
     */
    private String machineId;

    /**
     * 外部传入支付机构订单金额（分）
     */
    private Long outOrderAmount;

    /**
     * 医保金额（分）
     */
    private Long healthCareAmount;

    /**
     * 支付机构订单金额（分）
     */
    private Long orderAmount;

    /**
     * 订单总金额（分）
     */
    private Long orderTotalAmount;

    /**
     * 药品费（分）
     */
    private Integer drugFee;

    /**
     * 诊疗费（分）
     */
    private Integer zlFee;


    /**
     * 订单备注
     */
    private String orderNote;

    /**
     * 订单标题
     */
    private String orderSubject;

    /**
     * 订单创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderCreateTime;

    /**
     * 订单更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderUpdateTime;

    /**
     * 订单状态
     （1 待支付 2 支付中 3 支付成功 4 支付失败 5 已出货 6 出货异常 7 全部退款 8 部分退款
     ）
     */
    private Integer orderStatus;

    /**
     * 支付机构返回的json信息字符串
     */
    private String payReturnInfo;

    /**
     * 退款金额
     */
    private Long refundAmount;

    /**
     * 订单通知地址
     */
    private String notifyUrl;

    /**
     * 前端返回地址
     */
    private String backUrl;

    /**
     * 乐观锁
     */
    private Integer revision;

    /**
     * 创建来源 1：business 2:manage
     */
    private Integer createSource;

    /**
     * 操作来源 1：business 2:manage
     */
    private Integer operateSource;

    /**
     * 持久层注入
     */
    private OrderRepository orderRepository;

    public OrderPO(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * 根据状态查找订单列表
     *
     * @return
     */
    public List<OrderPO> selectByStatus(){
        return orderRepository.selectByStatus();
    };

    /**
     * 根据状态查找订单列表
     *
     * @return
     */
    public void saveOrder(){
        orderRepository.saveOrder();
    };
}
