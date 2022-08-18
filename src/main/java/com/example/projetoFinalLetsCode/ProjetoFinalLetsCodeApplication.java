package com.example.projetoFinalLetsCode;

import com.example.projetoFinalLetsCode.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class ProjetoFinalLetsCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFinalLetsCodeApplication.class, args);
	}

}
