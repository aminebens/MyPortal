package ca.isimtl.myPortal.configuration;

import ca.isimtl.myPortal.converter.RoleToUserConverter;
import ca.isimtl.myPortal.converter.UserToSujetConverter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ca.isimtl.myPortal")
public class MyPortalConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    UserToSujetConverter userToSujetConverter;
    
    @Autowired
    RoleToUserConverter roleToUserConverter;
    
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
    
    /**
     * Configure Converter to be used.
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //registry.addConverter(userToSujetConverter);
        registry.addConverter(roleToUserConverter);
    }
    
    /**
     * Configure MessageSource to lookup any validation/error message in internationalized property files
     * @return 
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
    
    @Bean
    public Map<String, String> sideMenu() {
        final Map<String, String> list = new HashMap<String, String>();
        list.put("Utilisateurs","/users");
        list.put("Matieres","/allMatieres");
        list.put("Cours","/allCours");
        list.put("Emploi de Temps", "/horairesCours");
        list.put("Sujets","/sujets");
        list.put("Groupes","/group");
        list.put("Alerts","/alerts");
        list.put("Contacts", "/contacts");
        list.put("Formations", "/allFormations");
        return list;
    }

}
