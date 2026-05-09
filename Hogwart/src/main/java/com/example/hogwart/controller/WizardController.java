package com.example.hogwart.controller;

import com.example.hogwart.models.Wizard;
import com.example.hogwart.services.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/wizards")
public class WizardController {

    @Autowired
    private WizardService wizardService;

    // POST: /api/wizards (Registrar mago)
    @PostMapping
    public ResponseEntity<Wizard> createWizard(@RequestBody Wizard wizard) {
        return ResponseEntity.ok(wizardService.createWizard(wizard));
    }

    // GET: /api/wizards (Obtener todos)
    @GetMapping
    public ResponseEntity<List<Wizard>> getAllWizards() {
        return ResponseEntity.ok(wizardService.getAllWizards());
    }

    // GET: /api/wizards/deatheaters (Obtener solo los Mortífagos)
    @GetMapping("/deatheaters")
    public ResponseEntity<List<Wizard>> getDeatheaters() {
        return ResponseEntity.ok(wizardService.getDeatheaters());
    }

    // PUT: /api/wizards/{id} (Actualizar mago)
    @PutMapping("/{id}")
    public ResponseEntity<Wizard> updateWizard(@PathVariable UUID id, @RequestBody Wizard wizardDetails) {
        return ResponseEntity.ok(wizardService.updateWizard(id, wizardDetails));
    }

    // GET: /api/wizards/patronus/{patronus} (Obtener por nombre del patronus)
    @GetMapping("/patronus/{patronus}")
    public ResponseEntity<List<Wizard>> getWizardsByPatronus(@PathVariable String patronus) {
        return ResponseEntity.ok(wizardService.getByPatronus(patronus));
    }

    // DELETE: /api/wizards/delete/{id} (Eliminar mago)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWizard(@PathVariable UUID id) {
        wizardService.deleteWizard(id);
        return ResponseEntity.noContent().build();
    }
}