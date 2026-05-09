package com.example.hogwart.services;

import com.example.hogwart.models.Wizard;
import com.example.hogwart.repositories.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WizardService {

    @Autowired
    private WizardRepository wizardRepository;

    public Wizard createWizard(Wizard wizard) {
        return wizardRepository.save(wizard);
    }

    public List<Wizard> getAllWizards() {
        return wizardRepository.findAll();
    }

    public List<Wizard> getDeatheaters() {
        return wizardRepository.findByIsDeatheaterTrue();
    }

    public Wizard updateWizard(UUID id, Wizard wizardDetails) {
        return wizardRepository.findById(id).map(wizard -> {
            wizard.setName(wizardDetails.getName());
            wizard.setHouse(wizardDetails.getHouse());
            wizard.setPatronus(wizardDetails.getPatronus());
            wizard.setIsDeatheater(wizardDetails.getIsDeatheater());
            return wizardRepository.save(wizard);
        }).orElseThrow(() -> new RuntimeException("Mago no encontrado con el ID: " + id));
    }

    public List<Wizard> getByPatronus(String patronus) {
        return wizardRepository.findByPatronusIgnoreCase(patronus);
    }

    public void deleteWizard(UUID id) {
        wizardRepository.deleteById(id);
    }
}