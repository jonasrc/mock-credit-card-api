package com.library.card;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class CreditCardConfiguration {

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.library.card.rest"))              
          .paths(PathSelectors.regex("/.*"))                      
          .build()
          .apiInfo(apiEndPointsInfo());                                           
    }
	
	private ApiInfo apiEndPointsInfo() {

        return new ApiInfoBuilder().title("Mock API de transações com cartão de crédito")
                .description("Spring boot REST API para simulação de criação de transações via cartão de créditor"
                		+ "\n\nAPI implementada como parte da disciplina de Arquitetura de Backend e Microsserviços do curso de pós-graduação em Arquitetura de Software Distribuído da PUC Minas.")
                .contact(new Contact("Jonas Castanheira", "https://github.com/jonasrc", "jonasrcastanheira@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0-SNAPSHOT")
                .build();
    }
}
