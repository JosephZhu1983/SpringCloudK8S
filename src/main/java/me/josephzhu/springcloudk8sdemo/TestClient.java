package me.josephzhu.springcloudk8sdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@Slf4j
public class TestClient {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TestConfig testConfig;

    @GetMapping("client")
    public String client() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        String response = restTemplate.getForObject("http://"+testConfig.getServiceName()+"/", String.class);
        return String.format("%s -> %s", ip, response);
    }
}
