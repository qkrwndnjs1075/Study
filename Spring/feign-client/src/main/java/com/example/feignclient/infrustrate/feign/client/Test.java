package com.example.feignclient.infrustrate.feign.client;

import com.example.feignclient.infrustrate.feign.infrustructure.RetryConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="아몰랑", url="url", configuration = RetryConfiguration.class)
public interface Test {

    @GetMapping("/test")
    // 작성
}
