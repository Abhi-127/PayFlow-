package org.airtribe.PayFlow.repository;


import org.airtribe.PayFlow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Derived query method - JPA automatically generates SQL from method name
    Optional<User> findByUpiId(String upiId);

    // Custom query using @Query with JPQL
    @Query("SELECT u FROM User u WHERE u.balance > :minBalance")
    List<User> findByBalanceGreaterThan(@Param("minBalance") BigDecimal minBalance);
}