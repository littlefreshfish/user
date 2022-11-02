package com.js.mail.user.address.param;

import lombok.Data;

/**
 * @ClassName : com.mail.mailserver.controller.form.UpdateAccountForm
 * @Description : 类描述
 * Created by js on 2022-11-01 18:57:35
 */
@Data
public class UpdateAddressParam {
    private Integer addressId;

    /**
     * 地址
     */
    private String address;

    /**
     * 用户ID
     */
    private Integer userId;


    private String receiverName;

    private String orderPhone;
}
