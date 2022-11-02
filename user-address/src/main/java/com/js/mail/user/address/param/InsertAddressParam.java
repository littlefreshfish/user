package com.js.mail.user.address.param;

import lombok.Data;

/**
 * @ClassName : com.mail.mailserver.controller.form.InsertAccountForm
 * @Description : 类描述
 * Created by js on 2022-11-01 18:53:01
 */
@Data
public class InsertAddressParam {


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
