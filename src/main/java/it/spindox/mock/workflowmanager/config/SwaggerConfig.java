package it.spindox.mock.workflowmanager.config;

/*
 * Created by Marco Terrinoni, on 11/07/2018 - 23:32.
 */

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
public class SwaggerConfig {

  @Value("${custom.swagger.apinfo.title")
  private String title;
  @Value("${custom.swagger.apinfo.description")
  private String description;
  @Value("${custom.swagger.apinfo.version")
  private String version;
  @Value("${custom.swagger.apinfo.termsofserviceurl")
  private String termsOfServiceUrl;
  @Value("${custom.swagger.apinfo.contactname")
  private String contactName;
  @Value("${custom.swagger.apinfo.contacturl")
  private String contactUrl;
  @Value("${custom.swagger.apinfo.contactemail")
  private String contactEmail;
  @Value("${custom.swagger.apinfo.license")
  private String license;
  @Value("${custom.swagger.apinfo.licenseurl")
  private String licenseUrl;

  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
  }

  @Bean
  ApiInfo apiInfo() {
    ApiInfo apiInfo = new ApiInfo(
        title,
        description,
        version,
        termsOfServiceUrl,
        new Contact(contactName, contactUrl, contactEmail),
        license,
        licenseUrl,
        new ArrayList<>() // empty list
    );

    return apiInfo;
  }

}
