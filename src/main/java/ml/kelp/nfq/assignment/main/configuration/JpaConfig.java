package ml.kelp.nfq.assignment.main.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
class JpaConfig {
    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(System.getenv("DB_URL"))
                .username(System.getenv("DB_USER"))
                .password(System.getenv("DB_PASSWORD"))
                .build();
    }
}