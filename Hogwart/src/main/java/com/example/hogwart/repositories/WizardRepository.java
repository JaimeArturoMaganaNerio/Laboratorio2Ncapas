package com.example.hogwart.repositories;

import com.example.hogwart.models.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, UUID> {


    List<Wizard> findByIsDeatheaterTrue();

    List<Wizard> findByPatronusIgnoreCase(String patronus);
}