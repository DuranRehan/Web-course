package webg.g65055.helloSecu.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
    // User stocké en dur dans la mémoire
    // @Bean
    // public UserDetailsManager users() {
    // UserDetails user1 = User.withUsername("prof")
    // .password("{noop}prof")
    // .authorities("PROF")
    // .build();

    // UserDetails user2 = User.withUsername("etudiant")
    // .password("{noop}etudiant")
    // .authorities("USER")
    // .build();

    // InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();

    // users.createUser(user1);
    // users.createUser(user2);

    // return users;
    // }

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // http.formLogin(form -> form.loginPage("/login"));
    // http.authorizeHttpRequests((authz) -> authz
    // .requestMatchers("/private").hasAuthority("PROF")
    // .requestMatchers("/**").permitAll());
    // http.exceptionHandling(error -> error.accessDeniedPage("/"));
    // http.logout(logout -> logout.logoutSuccessUrl("/login"));

    // return http.build();
    // }

    // User stocké dans une base de données sans cryptage
    // @Bean
    // public UserDetailsManager users(DataSource dataSource) {

    // JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
    // users.setUsersByUsernameQuery("SELECT username,password,enabled FROM user_
    // WHERE username=?");
    // users.setAuthoritiesByUsernameQuery("SELECT username,authority FROM authority
    // WHERE username=?");

    // return users;
    // }

    // User stocké dans une base de données avec cryptage
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
                .requestMatchers("/private").hasAuthority("PROF")
                .requestMatchers("/**").permitAll());
        // .requestMatchers("/h2-console/**").permitAll());// pour h2-console
        // http.csrf().disable(); // pour h2-console
        // http.headers().frameOptions().disable();// pour h2-console
        http.exceptionHandling(error -> error.accessDeniedPage("/"));
        http.logout(logout -> logout.logoutSuccessUrl("/login"));
        return http.build();
    }
}