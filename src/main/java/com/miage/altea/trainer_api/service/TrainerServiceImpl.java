package com.miage.altea.trainer_api.service;

import com.miage.altea.trainer_api.bo.Trainer;
import com.miage.altea.trainer_api.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService{

    private TrainerRepository  trainerRepository;

    @Autowired
    public TrainerServiceImpl(TrainerRepository  trainerRepository){
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Iterable<Trainer> getAllTrainers() {
        return this.trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainer(String name) {
        return this.trainerRepository.findById(name).orElse(null);
    }

    @Override
    public Trainer createTrainer(Trainer trainer) {
        return this.trainerRepository.save(trainer);
    }

    @Override
    public Trainer updateTrainer(Trainer trainer) {
            return this.trainerRepository.save(trainer);
    }

    @Override
    public void removeTrainer(String name) {
        Optional<Trainer> trainer = this.trainerRepository.findById(name);
        if (trainer.isPresent())
            this.trainerRepository.delete(trainer.get());

    }
}
