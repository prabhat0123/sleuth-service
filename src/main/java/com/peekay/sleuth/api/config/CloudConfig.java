package com.peekay.sleuth.api.config;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CloudConfig {

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

	@Bean
	public Sampler defaultSampler() {
		return new AlwaysSampler();
	}

}
