package com.example.Events.catering;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateringService {

    private final CateringRepository cateringRepository;

    @Autowired
    public CateringService(CateringRepository cateringRepository) {
        this.cateringRepository = cateringRepository;
    }

    public void createCatering(Catering catering){
        cateringRepository.save(catering);
    }

    public void updateCatering(Long id, String foodType) {
        Catering catering = cateringRepository.findById(id).orElseThrow (()-> new IllegalStateException(""));
        catering.setTypeFood(foodType);
        cateringRepository.save(catering);
    }

    public List<Catering> getAllCaterings(){ return cateringRepository.findAll(); }

    public void deleteCatering(Long cateringId){
        boolean exists = cateringRepository.existsById(cateringId);
        if (!exists) {
            throw new IllegalStateException("Catering event with id" + cateringId + " does no exist");
        }
        cateringRepository.deleteById(cateringId);
    }


}
