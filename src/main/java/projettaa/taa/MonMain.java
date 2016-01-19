package projettaa.taa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages ={
   "projettaa.taa.aspect",
   "projettaa.taa.Controleur",
   "projettaa.taa.model",
   "projettaa.taa.repository",
   "projettaa.taa.service",
   "projettaa.taa.config"})

public class MonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MonMain.class, args);
	}

}
