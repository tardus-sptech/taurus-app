package com.taurus.financeapi.modules.openfeign.dto;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "user", url="http://localhost:8080/api/user/email/renan.oliveira@taurus.com")
public interface UsuarioResponse {
    @RequestMapping(method = RequestMethod.GET, value = "")
    UserRequest getUser();
}
