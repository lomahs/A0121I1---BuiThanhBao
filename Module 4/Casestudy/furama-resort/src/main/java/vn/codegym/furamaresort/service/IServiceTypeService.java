package vn.codegym.furamaresort.service;

import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.service.ServiceType;

import java.util.List;

@Service
public interface IServiceTypeService {

    List<ServiceType> listAllServiceTypes();
}