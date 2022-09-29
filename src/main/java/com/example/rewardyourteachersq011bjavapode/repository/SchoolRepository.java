package com.example.rewardyourteachersq011bjavapode.repository;

import com.example.rewardyourteachersq011bjavapode.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<School , Long> {
    Optional<School> findByName(String name);

}
