package com.parcial.NievesPerri.repository;

import com.parcial.NievesPerri.model.Birthdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirthdateRepository extends JpaRepository<Birthdate,Integer> {
}
