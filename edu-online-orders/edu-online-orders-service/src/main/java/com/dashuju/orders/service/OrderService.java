package com.dashuju.orders.service;

import com.dashuju.messagesdk.model.po.MqMessage;
import com.dashuju.orders.model.dto.AddOrderDto;
import com.dashuju.orders.model.dto.PayRecordDto;
import com.dashuju.orders.model.dto.PayStatusDto;
import com.dashuju.orders.model.po.XcPayRecord;

public interface OrderService {


    /**
     * @param addOrderDto 订单信息
     * @return PayRecordDto 支付记录(包括二维码)
     * @description 创建商品订单
     */
    PayRecordDto createOrder(String userId, AddOrderDto addOrderDto);

    /**
     * @description 查询支付记录
     * @param payNo  交易记录号
     * @return com.dashuju.orders.model.po.XcPayRecord
     */
    public XcPayRecord getPayRecordByPayno(String payNo);
    /**
     * 请求支付宝查询支付结果
     * @param payNo 支付记录id
     * @return 支付记录信息
     */
    PayRecordDto queryPayResult(String payNo);
    /**
     * @description 保存支付宝支付结果
     * @param payStatusDto  支付结果信息
     * @return void
     */
    void saveAliPayStatus(PayStatusDto payStatusDto) ;
    /**
     * 发送通知结果
     * @param message
     */
    void notifyPayResult(MqMessage message);

}
/**
 * @description TODO
 * @author 74667
 * @date 2023/5/4 19:56
 * @version 1.0
 */