package com.generation.blogpessoal.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

    @Bean // Fica instanciável e permite mexer na estrutura do código
    public OpenAPI springBlogPessoalOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Projeto Blog Pessoal - Nathalie Brasil")
                        .description("Projeto Blog Pessoal - critério para conclusão do Bootcamp de Java"
                                + "Full-Stack da Generation Brasil")
                        .version("v1.0")
                        .license(new License()
                                .name("Generation Brasil")
                                .url("https://brazil.generation.org/"))
                        .contact(new Contact()
                                .name("Nathalie Brasil")
                                .url("https://github.com/nathaliebfm")
                                .email("natibfm@hotmail.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Veja também o meu Projeto Integrador:")
                        .url("https://github.com/nathaliebfm/SerraDaCapijava"));

    }

    @Bean
    public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {

        return openApi -> {
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

                ApiResponses apiResponses = operation.getResponses();

                apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
                apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
                apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
                apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
                apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
                apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
                apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));

            }));
        };
    }

    private ApiResponse createApiResponse(String message) {

        return new ApiResponse().description(message);

    }

}
