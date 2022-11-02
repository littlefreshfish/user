package com.js.mail.userapp.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.js.mail.user.client.model.Account;
import com.js.mail.userapp.dao.AccountDao;
import com.js.mail.userapp.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author js
 * @since 2022-11-01
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {

}
