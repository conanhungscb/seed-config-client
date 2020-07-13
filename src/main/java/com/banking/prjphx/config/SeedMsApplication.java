package com.banking.prjphx.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class SeedMsApplication {

	// @Value("${app.context.path}")
	// private String contextPath;
	
	// @Value("${app.name}")
	// private String appName;
	
	


	public static void main(String[] args) {
		SpringApplication.run(SeedMsApplication.class, args);
	}

	// @GetMapping(
    //   value = "/helloworld",  
    //   produces = MediaType.TEXT_PLAIN_VALUE)
    // public String whoami() {
    //     return String.format("Hello! You're %s and you'll become a(n) %s...\n", appName, contextPath);
	// }
	
	
	@RestController
	@RefreshScope
	class GetMessageController{

		@Value("${app.name}")
	    private String appName;
	
	    @Value("${app.user}")
		private String appUser;
		
		@GetMapping(value = "/hellophoenix", produces = MediaType.TEXT_PLAIN_VALUE)
        public String phoenix() {
          return String.format("Hello! You're %s and you'll use the app %s...\n", appUser, appName);
	    }

	}

}
