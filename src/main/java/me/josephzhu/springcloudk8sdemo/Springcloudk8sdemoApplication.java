package me.josephzhu.springcloudk8sdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.lang.management.ManagementFactory;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@Slf4j
@RibbonClient(name = "k8sdemo")
public class Springcloudk8sdemoApplication {

	public static void main(String[] args) {
		log.info("jvm:{}",
				ManagementFactory.getRuntimeMXBean().getInputArguments().stream().collect(Collectors.joining(" ")));
		SpringApplication.run(Springcloudk8sdemoApplication.class, args);
	}

	@Autowired
	private TestConfig testConfig;

	@Scheduled(fixedDelay = 5000)
	public void hello() {
		log.info("config:{}", testConfig);
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
