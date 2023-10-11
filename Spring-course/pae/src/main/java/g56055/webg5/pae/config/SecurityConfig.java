package g56055.webg5.pae.config;

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
                http.formLogin(form -> form.loginPage("/login"));
                http.authorizeHttpRequests((authz) -> authz
                                .requestMatchers("/courses*").hasAuthority("SECRETARY")
                                .requestMatchers("/students*").hasAuthority("SECRETARY")
                                .requestMatchers("/**").permitAll());
                http.exceptionHandling(error -> error.accessDeniedPage("/login"));
                http.logout(logout -> logout.logoutSuccessUrl("/login"));

                return http.build();
        }

}
