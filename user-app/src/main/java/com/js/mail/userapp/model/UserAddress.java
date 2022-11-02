package com.js.mail.userapp.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author js
 * @since 2022-11-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "address_id", type = IdType.AUTO)
    private Integer addressId;

    /**
     * 地址
     */
    private String address;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 是否默认地址 1 是 0 否
     */
    private Integer addressDefault;

    private String receiverName;

    private String orderPhone;


}
