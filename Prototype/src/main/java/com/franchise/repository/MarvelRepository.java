package com.franchise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franchise.model.Marvel;

@Repository
public interface MarvelRepository extends JpaRepository<Marvel, Long>{

    List<Marvel> findByPosted(boolean posted);
    List<Marvel> findByMovie(String movie);
}

