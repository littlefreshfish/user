package com.js.mail.user.client.param;

import lombok.Data;

/**
 * @ClassName : com.mail.mailserver.controller.form.InsertAccountForm
 * @Description : 类描述
 * Created by js on 2022-11-01 18:53:01
 */
@Data
public class InsertAccountParam {
    private String account;

    private String name;

    private String password;
}
