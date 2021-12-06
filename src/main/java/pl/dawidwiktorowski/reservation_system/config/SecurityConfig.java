package pl.dawidwiktorowski.reservation_system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private DataSource dataSource;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select email, password, active from user where email = ?")
                .authoritiesByUsernameQuery("select u.email, r.role_type, from users u inner join user_role ur on (u.id = ur.user_id) inner join role r on(ur.role_id=r.id) where u.email=?")
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/login").permitAll()
                .antMatchers("/forget", "/reset").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/admin").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/", true)
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/?logout")
                .logoutSuccessUrl("/")
                .and().csrf().disable();
    }

    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers("/css/**");
        webSecurity.ignoring().antMatchers("/js/**");
        webSecurity.ignoring().antMatchers("/images/**");
    }
}
