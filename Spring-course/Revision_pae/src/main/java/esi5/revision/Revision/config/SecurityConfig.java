package esi5.revision.Revision.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        return users;
    }

    @Bean
    DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/login/details", true));

        http.authorizeHttpRequests((authz) -> authz
                .requestMatchers("/login**").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/login/details**").hasAnyRole("ADMIN", "STUDENT")
                .requestMatchers("/student/detail**").hasAnyRole("ADMIN", "STUDENT")
                .requestMatchers("/**").hasRole("ADMIN")
                
                .requestMatchers("/h2-console/**").permitAll());
        //  http.csrf().disable();
        //  http.headers().frameOptions().disable();
        http.exceptionHandling(error -> error.accessDeniedPage("/login"));
        http.logout(logout -> logout.logoutSuccessUrl("/login"));

        return http.build();
    }

}
