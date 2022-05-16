package com.example.isaacbank.web;

import com.example.isaacbank.IsaacbankApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class WebIniti extends SpringBootServletInitializer {


    //The function is used to tell Spring Boot to use the same configuration as the main application class
     //(IsaacbankApplication.class) when it is launched by the web server

     //@param builder The SpringApplicationBuilder instance that is used to configure the application.
     //@return A SpringApplicationBuilder object.

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(IsaacbankApplication.class);
    }
}
