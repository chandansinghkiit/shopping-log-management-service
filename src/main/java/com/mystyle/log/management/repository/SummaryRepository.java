package com.mystyle.log.management.repository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mystyle.log.management.model.Summary;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



public interface SummaryRepository extends CrudRepository<Summary, Long> {

    Optional<Summary> findByProductId(Long productId);

    @Query("update summary set hit_count = hit_count + 1 where product_id=?0")
    void incrementHitCount(Long productId);

    @Query("Select * from summary limit 100")
    List<Summary> findPopularProduct();
}
