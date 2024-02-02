package bootiful.jdbc;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@EnableCaching
@SpringBootApplication
public class JdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }

    @Bean
    ConcurrentMapCacheManager concurrentMapCacheManager() {
        var cache = new ConcurrentMapCacheManager();
        cache.setAllowNullValues(true);
        cache.setStoreByValue(true);
        return cache;
    }

    @Bean
    ApplicationRunner demo(CustomerRepository repository) {
        return args -> {
            var orderSet = Set.of(new Order(null, "A"), new Order(null, "B"));
            var profile = new Profile(null, "user", "password");
            var customer = repository.save(new Customer(null, "A", profile, orderSet));

            System.out.println("getting hopefully cached version (1)");
            repository.findById(customer.id()).get();

            System.out.println("getting hopefully cached version (2)");
            var result = repository.findById(customer.id()).get();

            Assert.state(result != customer, "the two references should not be the same");
        };
    }
}

@Table("customer_orders")
record Order(@Id Integer id, String name) implements Serializable {

}

@Table("customer_profile")
record Profile(@Id Integer id, String username, String password) implements Serializable {

}

record Customer(@Id Integer id, String name, Profile profile, Set<Order> orders) implements Serializable {

}

interface CustomerRepository extends ListCrudRepository<Customer, Integer> {

    String CUSTOMER_CACHE_KEY = "customers";

    @Override
    @Cacheable(CUSTOMER_CACHE_KEY)
    Optional<Customer> findById(Integer id);

    Collection<Customer> findByName(String name);

    @CacheEvict(value = CUSTOMER_CACHE_KEY, key = "#result.id")
    @Override
    <S extends Customer> S save(S entity);
}
