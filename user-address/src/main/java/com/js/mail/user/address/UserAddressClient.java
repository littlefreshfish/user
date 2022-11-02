package com.js.mail.user.address;

import com.js.mail.user.address.param.InsertAddressParam;
import com.js.mail.user.address.param.UpdateAddressParam;
import com.js.mail.user.address.result.UserAddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(contextId = "UserAddressClient",name = "address")
public interface UserAddressClient {
    @GetMapping("/getAllAddress")
    public List<UserAddressDto> getAddress(@RequestParam("userId") Integer userId);

    @PostMapping("/addAddress")
    public String addAddress(@RequestBody InsertAddressParam af);

    @PutMapping("/setDefaultAddress")
    public String setAddressDefault(@RequestBody Integer id);

    @DeleteMapping("/delAddress/{id}")
    public String delete(@PathVariable("id") Integer id);

}
