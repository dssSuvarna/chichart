package com.activ8.chichart.api.config;

import org.springframework.context.annotation.*;
import org.springframework.http.*;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.*;
import springfox.documentation.spi.service.contexts.*;
import springfox.documentation.spring.web.plugins.*;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.*;

import java.time.*;
import java.util.*;
import java.util.stream.*;

/**
 * Swagger API documentation configuration.
 * <p>
 * URL for api doc generation is http://localhost:8085/v2/api-docs
 * URL for swagger ui is http://localhost:8082/swagger-ui.html
 * <p>
 * The BeanValidatorPluginsConfiguration class affects the way object types are declared in the Swagger JSON file.
 * It transfers JSR-303 annotations like NotNull and Size into the equivalent swagger properties
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final AuthorizationScope[] AUTHORIZATION_SCOPES = new AuthorizationScope[]{
            new AuthorizationScope("all", "Access All")};

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/api/v1/.*"))
                .build()
                .pathMapping("/")
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("All Endpoints")
                                .description("REST API")
                                .build())
                .directModelSubstitute(LocalDate.class, String.class)
                .directModelSubstitute(LocalDateTime.class, String.class)
                .directModelSubstitute(LocalTime.class, String.class)
                .consumes(Stream.of("text/plain", "application/json").collect(Collectors.toSet()))
                .genericModelSubstitutes(ResponseEntity.class)
                .securitySchemes(Collections.singletonList(securitySchema()))
                .securityContexts(Collections.singletonList(securityContext("/api/v1/.*")));
    }

    private OAuth securitySchema() {
        return new OAuth(
                "oauth2schema",
                Arrays.asList(AUTHORIZATION_SCOPES),
                Collections.singletonList(new ClientCredentialsGrant("oauth/token")));
    }

    private SecurityContext securityContext(String regexPathPattern) {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(regexPathPattern))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        return Collections.singletonList(new SecurityReference("oauth2schema", AUTHORIZATION_SCOPES));
    }

    @Bean
    SecurityConfiguration security() {
        return new SecurityConfiguration(
                "test",
                "test",
                null,
                null,
                null,
                ApiKeyVehicle.HEADER,
                null,
                null);
    }

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration(
                null,
                null,
                null,
                null,
                null,
                true,
                true,
                60000L);
    }
}
