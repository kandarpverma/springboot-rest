package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CareProvider;

@Repository
public interface CareProviderRepository extends JpaRepository<CareProvider, Long> {

}
