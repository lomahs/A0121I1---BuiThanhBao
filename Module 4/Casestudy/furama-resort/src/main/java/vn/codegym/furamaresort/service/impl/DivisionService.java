package vn.codegym.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.employee.Division;
import vn.codegym.furamaresort.repository.DivisionRepository;
import vn.codegym.furamaresort.service.IDivisionService;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> listAllDivisions() {
        return divisionRepository.findAll();
    }
}