package ecommerce.example.ecommerce;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///D:/sts%20project/ecommerce/images/");
        
        
        
     //  profile_image folder 
        registry.addResourceHandler("/profile_image/**")
                .addResourceLocations("file:///D:/sts%20project/ecommerce/profile_image/");
        
    //  profile_image folder 
        registry.addResourceHandler("/signature_image/**")
                .addResourceLocations("file:///D:/sts%20project/ecommerce/signature_image/");
        
        //profile update 
        registry.addResourceHandler("/updated_profileimages/**")
        .addResourceLocations("file:///D:/sts project/ecommerce/updated_profileimages/");
        
        //Vender Image in Login
        registry.addResourceHandler("/vender_image/**")
        .addResourceLocations("file:D:/sts project/ecommerce/vender_image/");
    
    }
	
	
	@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofMegabytes(5));
        factory.setMaxRequestSize(DataSize.ofMegabytes(10));
        return factory.createMultipartConfig();
    }
	
	@Bean
	public ObjectMapper objectMapper() {
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(new JavaTimeModule());
	    return mapper;
	}

	
	

}
