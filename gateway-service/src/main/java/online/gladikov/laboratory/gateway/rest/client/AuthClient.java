package online.gladikov.laboratory.gateway.rest.client;

import online.gladikov.laboratory.gateway.config.FeignClientConfiguration;
import online.gladikov.laboratory.gateway.rest.dto.UserResDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="admin-service", configuration = FeignClientConfiguration.class)
public interface AuthClient {
    @GetMapping("/api/v1/admin/users/{username}")
    UserResDto getUserByUsername(@PathVariable String username);
}
