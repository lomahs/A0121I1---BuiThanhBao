package vn.codegym.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.employee.EducationDegree;
import vn.codegym.furamaresort.repository.EducationDegreeRepository;
import vn.codegym.furamaresort.service.IEducationDegreeService;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> listAllEducationDegrees() {
        return educationDegreeRepository.findAll();
    }
}