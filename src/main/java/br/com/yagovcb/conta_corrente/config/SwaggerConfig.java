package br.com.yagovcb.conta_corrente.config;

import br.com.yagovcb.conta_corrente.web.rest.ContaCorrenteController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;


@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = ContaCorrenteController.class)
public class SwaggerConfig {

    @Bean
    public Docket contaCorrenteApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        return new ApiInfo(
                "Conta Corrente API REST",
                "API REST para Conta Corrente",
                "1.0",
                "Termos de serviço",
                new Contact("Yago Castelo Branco",
                        "https://github.com/Yagovcb/conta_corrente",
                        "yago.vcb@gmail.com"),
                "Apache License Version 2.0",
                "http://www.apache.org/licens.html",
                new ArrayList<VendorExtension>()
        );
    }

}
