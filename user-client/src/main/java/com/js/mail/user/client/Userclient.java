package com.js.mail.user.client;

import com.js.mail.user.client.param.InsertAccountParam;
import com.js.mail.user.client.param.UpdateAccountParam;
import com.js.mail.user.client.result.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(contextId = "Userclient",name = "account")
public interface Userclient {
    @GetMapping("/getAccountInfo")
    public AccountDto getAccountInfo(@RequestParam("id") Integer id);

    @PostMapping("/register")
    public String addNewAccount(@RequestBody InsertAccountParam af);

    @PutMapping("/updateAccountInfo")
    public String update(@RequestBody UpdateAccountParam af);

    @DeleteMapping("/deleteAccount/{id}")
    public String delete(@PathVariable("id") Integer id);

}
