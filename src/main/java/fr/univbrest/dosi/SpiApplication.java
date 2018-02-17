package fr.univbrest.dosi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import fr.univbrest.dosi.services.FormationController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@ComponentScan
@EnableAutoConfiguration
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@EnableSwagger2
public class SpiApplication extends WebMvcConfigurerAdapter  implements CommandLineRunner{

    public static void main(final String[] args) {
        SpringApplication.run(SpiApplication.class, args);
    }
    
    @Autowired
    private FormationController fc;
    
	
	@Override
    public void run(String... args) throws Exception {
		//showAll();
	}
	
	public void showAll(){
		System.out.println("===============Show All Formations' Info===============");
		fc.getAll();
	}

    
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
          .addResourceLocations("classpath:/META-INF/resources/");
     
        registry.addResourceHandler("/webjars/**")
          .addResourceLocations("classpath:/META-INF/resources/webjars/");
        
        registry.addResourceHandler("/**")
        .addResourceLocations("classpath:/client/")
        .addResourceLocations("classpath:/.tmp/");
    }    

}
