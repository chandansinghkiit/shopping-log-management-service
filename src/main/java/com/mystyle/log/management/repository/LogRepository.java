package com.mystyle.log.management.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mystyle.log.management.model.Log;

import java.util.List;
import java.util.UUID;


public interface LogRepository extends CrudRepository<Log, UUID> {
}