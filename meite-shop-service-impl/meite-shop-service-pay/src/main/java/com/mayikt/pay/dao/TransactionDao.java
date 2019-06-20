package com.mayikt.pay.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mayikt.pay.entity.TransactionEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 支付交易  Mapper 接口
 * </p>
 *
 * @author Xxm123
 * @since 2019-06-21
 */
public interface TransactionDao extends BaseMapper<TransactionEntity> {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO `payment_transaction` VALUES (null, #{payAmount}, '0', #{userId}, #{orderId}, null, null, now(), null, now(),null,#{paymentId});")
    public int insertPaymentTransaction(TransactionEntity transactionEntity);

    @Select("SELECT ID AS ID ,pay_Amount AS payAmount,payment_Status AS paymentStatus,user_ID AS userId, order_Id AS orderId , created_Time as createdTime ,partypay_Id as partyPayId , payment_Id as paymentId FROM payment_transaction WHERE ID=#{id};")
    public TransactionEntity selectById(Long id);
}