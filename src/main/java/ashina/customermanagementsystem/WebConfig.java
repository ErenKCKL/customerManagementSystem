package ashina.customermanagementsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // İzin vermek istediğiniz URL yolu
                .allowedOrigins("http://localhost:3000") // İzin vermek istediğiniz etki alanı
                .allowedMethods("GET", "POST", "PUT", "DELETE") // İzin vermek istediğiniz HTTP yöntemleri
                .allowedHeaders("*"); // İzin vermek istediğiniz başlıklar
    }
}
