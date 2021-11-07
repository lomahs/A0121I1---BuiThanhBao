package vn.codegym.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.service.RentType;
import vn.codegym.furamaresort.repository.RentTypeRepository;
import vn.codegym.furamaresort.service.IRentTypeService;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> listAllRentTypes() {
        return rentTypeRepository.findAll();
    }
}