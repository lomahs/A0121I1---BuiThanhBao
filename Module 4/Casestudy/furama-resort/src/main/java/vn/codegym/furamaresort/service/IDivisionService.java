package vn.codegym.furamaresort.service;

import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.employee.Division;

import java.util.List;

@Service
public interface IDivisionService {

    List<Division> listAllDivisions();
}