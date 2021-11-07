package vn.codegym.furamaresort.service;

import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.employee.EducationDegree;

import java.util.List;

@Service
public interface IEducationDegreeService {

    List<EducationDegree> listAllEducationDegrees();
}