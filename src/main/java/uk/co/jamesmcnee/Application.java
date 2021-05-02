package uk.co.jamesmcnee;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "micronaut-playground",
                version = "1.0",
                description = "Playground"))
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
