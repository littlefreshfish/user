package com.js.mail.user.address.result;


import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author js
 * @since 2022-11-01
 */
@Data
public class UserAddressDto {


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
