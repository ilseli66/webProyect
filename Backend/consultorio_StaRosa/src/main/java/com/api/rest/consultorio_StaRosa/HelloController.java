package com.api.rest.consultorio_StaRosa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hola")
    public String saludar() {
        return "¡Hola Mundo desde Spring Boot! El servidor REST está funcionando.";
    }

}
