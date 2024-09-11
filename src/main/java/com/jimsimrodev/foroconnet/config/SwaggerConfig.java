package com.jimsimrodev.foroconnet.config;

import org.springframework.http.HttpHeaders;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "Foroconnet", description = "Es un api que sirve para implementar en un foro el cual acepta preguntas y respuestas de diferentes usuarios", termsOfService = "www.jimsimrodev.com/terminos-y-servicios", version = "1.0.0", contact = @Contact(name = "Jimmis J. Simanca", url = "jimsimrodev.com/contact", email = "jimsimrodev.com")), servers = {
    @Server(description = "DEV SERVER", url = "http://devserver.com")
}, security = @SecurityRequirement(name = "Security Token"))
@SecurityScheme(name = "Security Token", description = "Access Token for My API", type = SecuritySchemeType.HTTP, paramName = HttpHeaders.AUTHORIZATION, in = SecuritySchemeIn.HEADER, scheme = "bearer", bearerFormat = "JWT")
public class SwaggerConfig {

}
