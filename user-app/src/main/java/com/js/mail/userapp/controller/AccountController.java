package com.js.mail.userapp.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.js.mail.user.client.Userclient;
import com.js.mail.user.client.model.Account;
import com.js.mail.user.client.param.InsertAccountParam;
import com.js.mail.user.client.param.UpdateAccountParam;
import com.js.mail.user.client.result.AccountDto;
import com.js.mail.userapp.dao.AccountDao;
import com.js.mail.userapp.service.AccountService;
import com.js.mail.userapp.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author js
 * @since 2022-11-01
 */
@RestController
public class AccountController implements Userclient {
    @Autowired
    private AccountService accountService;

    public AccountDto getAccountInfo(Integer id){
        return
                BeanCopyUtil.copyObject(accountService
                        .getOne(new QueryWrapper<Account>()
                                .eq("id",id)),AccountDto.class);
    }

    public String addNewAccount(@RequestBody InsertAccountParam af){
        boolean b = accountService.save(BeanCopyUtil.copyObject(af, Account.class));
        if (b)
            return  "注册成功";
        return "注册失败";
    }

    public String update(@RequestBody UpdateAccountParam af){
        boolean b = accountService.updateById(BeanCopyUtil.copyObject(af, Account.class));
        if (b)
            return  "更新成功";
        return "更新失败";
    }

    public String delete(@PathVariable("id") Integer id){
        boolean b = accountService.removeById(id);
        if (b)
            return  "删除成功";
        return "删除失败";
    }
}

