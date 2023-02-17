package com.hw.networkstore;

import com.hw.networkstore.model.Electronics;
import com.hw.networkstore.model.NetworkPlan;
import com.hw.networkstore.repos.NetworkPlanRepository;
import com.hw.networkstore.service.ElectronicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class NetworkStoreApplication {

/*    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(NetworkStoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "INSERT INTO \"testtable\" (id, name, amount) VALUES (" + "7, 'whatever', 2)";
        System.out.println("BEGINNINNN");
        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }
    }*/
    public static void main(String[] args) {
        SpringApplication.run(NetworkStoreApplication.class, args);
    }

}
