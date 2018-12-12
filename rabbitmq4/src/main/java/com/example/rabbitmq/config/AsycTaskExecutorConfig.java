package com.example.rabbitmq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置、启用异步
 */
@EnableAsync(proxyTargetClass = true)
@Configuration
public class AsycTaskExecutorConfig {

	@Bean
	public ThreadPoolExecutor taskExecutor() {
		ExecutorService executor = Executors.newCachedThreadPool();
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;

		return threadPoolExecutor;
	}
}
