package com.api.server.modules.actuator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actuator")
public class HealthyController {

    @GetMapping("/healthy")
    ResponseEntity<String> healthyStatus() {
        return ResponseEntity.ok()
                .body("healthy");
    }

}
