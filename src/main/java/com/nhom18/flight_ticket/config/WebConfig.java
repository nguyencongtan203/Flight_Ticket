package com.nhom18.flight_ticket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Cho phép frontend từ localhost:8081
        registry.addMapping("/api/**") // Định nghĩa các URL cần cấu hình CORS
                .allowedOrigins("http://localhost:8081") // Chỉ cho phép yêu cầu từ localhost:8081
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Các phương thức HTTP được phép
                .allowedHeaders("*") // Cho phép tất cả các header
                .allowCredentials(true); // Cho phép gửi cookie hoặc thông tin xác thực
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
