package com.microservices.reclamation.Service;

import com.microservices.reclamation.entity.Reclamation;
import com.microservices.reclamation.repository.ReclamationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReclamationService {
    private ReclamationRepository reclamationRepository;
    public Reclamation addReclamation(Reclamation reclamation){
        return reclamationRepository.save(reclamation);
    }
    public Reclamation updateReclamation(int id,Reclamation newReclamation){
        if (reclamationRepository.findById(id).isPresent()){
            Reclamation existingReclamation = reclamationRepository.findById(id).get();
            existingReclamation.setDescription(newReclamation.getDescription());

            return reclamationRepository.save(existingReclamation);
        }
        else return null;

    }

    public String deletReclamation(int id){
        if(reclamationRepository.findById(id).isPresent()){
            reclamationRepository.deleteById(id);
            return "reclamation supprimé";
        }
        else
            return "reclamation non supprimé";
    }
}
