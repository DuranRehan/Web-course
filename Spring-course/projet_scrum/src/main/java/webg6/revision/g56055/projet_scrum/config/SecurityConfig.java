package webg6.revision.g56055.projet_scrum.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
        @Bean
        public UserDetailsManager users(DataSource dataSource) {
                PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

                String secret = encoder.encode("passwd");

                UserDetails user = User.withUsername("user")
                                .password(secret)
                                .authorities("USER")
                                .build();

                JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

                users.createUser(user);

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
                                .requestMatchers("/project/addStory").hasAuthority("USER")
                                //.requestMatchers("/h2-console/**").permitAll()
                                .requestMatchers("/**").permitAll()

                );
                // http.csrf().disable(); // for h2-console
                // http.headers().frameOptions().disable(); // for h2-console
                http.exceptionHandling(error -> error.accessDeniedPage("/"));
                http.logout(logout -> logout.logoutSuccessUrl("/login"));
                return http.build();
        }

}
