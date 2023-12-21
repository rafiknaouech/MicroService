package com.microservices.reclamation.repository;

import com.microservices.reclamation.entity.Reclamation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReclamationRepository extends JpaRepository<Reclamation,Integer> {

    @Query("select r from Reclamation r where r.description like :description")
    public Page<Reclamation> reclamationByDescription(@Param("description") String description, Pageable pageable);
}
