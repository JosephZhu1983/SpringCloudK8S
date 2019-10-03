package me.josephzhu.springcloudk8sdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
public class TestServer {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("servers")
    public List<String> servers() {
        return discoveryClient.getServices();
    }

    @GetMapping
    public String ip() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }
}
