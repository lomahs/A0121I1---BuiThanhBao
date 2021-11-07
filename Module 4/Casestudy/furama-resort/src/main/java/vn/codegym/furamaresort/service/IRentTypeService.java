package vn.codegym.furamaresort.service;

import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.service.RentType;

import java.util.List;

@Service
public interface IRentTypeService {

    List<RentType> listAllRentTypes();
}