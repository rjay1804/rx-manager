package org.rxmanager.service;

import org.rxmanager.model.Medicine;
import org.rxmanager.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    @Autowired
    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public Medicine save(Medicine medicine) {
        Medicine fetched = medicineRepository.findByName(medicine.getName());

        if(fetched == null) {
            return medicineRepository.save(medicine);
        } else {
            HashSet<String> variants = fetched.getVariants();

            variants.addAll(medicine.getVariants());

            fetched.setVariants(variants);

            return medicineRepository.save(fetched);

        }
    }

    public List<Medicine> findByName(String name) {
        return medicineRepository.findAllByNameContaining(name);
    }
}
