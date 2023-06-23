package br.com.fiap.postech.fastfood.adapters.configs;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "EntityManagerFactory",
        transactionManagerRef = "TransactionManager",
        basePackages = {"br.com.fiap.postech.fastfood.infrastructure.repository"})
@EnableJpaAuditing
@Profile("local")
public class SqlConnectionConfig {

    public static final String TWO_POINTS = ":";

    @Value("${app.datasource.username}")
    private String username;

    @Value("${app.datasource.password}")
    private String passwordEnvironmentsVariable;

    @Value("${app.datasource.db}")
    private String db;

    @Value("${app.datasource.host}")
    private String host;

    @Value("${app.datasource.connector}")
    private String connector;

    @Value("${app.datasource.driver}")
    private String driver;

    @Value("${app.datasource.poolname}")
    private String poolName;

    @Value("${app.datasource.poolsize}")
    private int poolSize;

    @Value("${app.datasource.leakDetectionThreshold}")
    private int leakDetectionThreshold;

    @Value("${spring.jpa.show-sql}")
    private String showSql;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlGeneration;

    @Value("$app.datasource.properties.allowPublicKeyRetrieval")
    private String allowPublicKeyRetrieval;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        final String url = getUrl();
        final HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setDriverClassName(this.driver);
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(this.username);
        hikariConfig.setPassword(this.passwordEnvironmentsVariable);
        hikariConfig.setMaximumPoolSize(this.poolSize);
        hikariConfig.setPoolName(this.poolName);
        hikariConfig.setAutoCommit(true);
        hikariConfig.setLeakDetectionThreshold(this.leakDetectionThreshold);
        hikariConfig.setMaxLifetime(this.leakDetectionThreshold);

        return new HikariDataSource(hikariConfig);
    }

    private String getUrl() {
        if ("jdbc:h2".equals(this.connector)) {
            return this.connector + TWO_POINTS + this.host + TWO_POINTS + this.db + ";DB_CLOSE_DELAY=-1";
        }
        return this.connector + "://" + this.host + "/" + this.db + "?useSSL=false";
    }

}

