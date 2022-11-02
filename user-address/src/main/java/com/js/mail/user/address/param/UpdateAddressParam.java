package com.js.mail.user.address.param;

import lombok.Data;

/**
 * @ClassName : com.mail.mailserver.controller.form.UpdateAccountForm
 * @Description : 类描述
 * Created by js on 2022-11-01 18:57:35
 */
@Data
public class UpdateAddressParam {
    private Integer id;

    private String account;

    private String name;

    private String password;
}
