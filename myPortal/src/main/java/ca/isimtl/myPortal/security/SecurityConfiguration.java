package ca.isimtl.myPortal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Amine
 */
@Configuration
@EnableWebSecurity
@ComponentScan({"ca.isimtl.myPortal.security"})
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("appUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/")
                    .access("hasRole('ADMIN') or hasRole('PROFESSEUR') or hasRole('ETUDIANT') or hasRole('AVOCAT') or hasRole('COMPTABILITE')")
                .antMatchers("/users")
                    .access("hasRole('ADMIN')")
                .antMatchers("/profile")
                    .access("hasRole('ADMIN') or hasRole('PROFESSEUR') or hasRole('ETUDIANT') or hasRole('AVOCAT') or hasRole('COMPTABILITE')")
                .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password")
                    .defaultSuccessUrl("/users", true)
                    .failureUrl("/login?errorLogin")
                .and()
                .logout()
                    .logoutSuccessUrl("/login")
                .and()
                .exceptionHandling()
                    .accessDeniedPage("/denied");
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }
    
    @Bean
    public AuthenticationTrustResolver getAuthenticationTrustResolver() {
        return new AuthenticationTrustResolverImpl();
    }
    
}
