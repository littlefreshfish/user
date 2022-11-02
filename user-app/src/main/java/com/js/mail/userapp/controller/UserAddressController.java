package com.js.mail.userapp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.js.mail.user.address.UserAddressClient;
import com.js.mail.user.address.param.InsertAddressParam;
import com.js.mail.user.address.param.UpdateAddressParam;
import com.js.mail.user.address.result.UserAddressDto;
import com.js.mail.userapp.model.UserAddress;
import com.js.mail.userapp.service.UserAddressService;
import com.js.mail.userapp.utils.BeanCopyUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author js
 * @since 2022-11-02
 */
@RestController
@RequestMapping("/userAddress")
public class UserAddressController implements UserAddressClient {

    @Resource
    private UserAddressService userAddressService;

    @GetMapping("/getAllAddress")
    public List<UserAddressDto> getAddress(@RequestParam("userId") Integer userId) {
        return BeanCopyUtil.copyList(userAddressService
                .list(new QueryWrapper<UserAddress>()
                        .eq("user_id", userId)), UserAddressDto.class);
    }

    @PostMapping("/addAddress")
    public String addAddress(@RequestBody InsertAddressParam af) {
        UserAddress userAddress = BeanCopyUtil.copyObject(af, UserAddress.class);
        UserAddress addressDb = userAddressService.getOne(new QueryWrapper<UserAddress>()
                .eq("user_id", af.getUserId())
                .eq("address", af.getAddress()));
        if (addressDb == null) {
            userAddressService.save(userAddress);
            return "新增地址成功";
        } else {
            return "地址已存在";
        }

    }

    @PutMapping("/setDefaultAddress")
    public String setAddressDefault(@RequestBody Integer id) {
        UserAddress addressDb = userAddressService.getOne(new QueryWrapper<UserAddress>()
                .eq("id", id));
        if (addressDb == null){
            return "当前地址不存在";
        }else{
            if (addressDb.getAddressDefault()== 1)
                return "当前地址已经是默认地址";
            addressDb.setAddressDefault(1);
            userAddressService.updateById(addressDb);
            userAddressService.update(null,new UpdateWrapper<UserAddress>()
                    .eq("user_id",addressDb.getUserId())
                    .notIn("id",id)
                    .set("address_default",0));
            return "设置默认地址成功";
        }
    }

    @DeleteMapping("/delAddress/{id}")
    public String delete(@PathVariable("id") Integer id) {
        return null;
    }
}

