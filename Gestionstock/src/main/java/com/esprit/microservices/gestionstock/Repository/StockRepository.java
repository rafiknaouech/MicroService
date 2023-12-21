package com.esprit.microservices.gestionstock.Repository;

import com.esprit.microservices.gestionstock.Entity.StockItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StockRepository extends JpaRepository<StockItem, Long> {
    @Query("select s from StockItem s where s.nomProduit like %:name%")
    Page<StockItem> stockItemBynomProduit(@Param("name") String name, Pageable pageable);}

/* List<StockItem> findById();*/
