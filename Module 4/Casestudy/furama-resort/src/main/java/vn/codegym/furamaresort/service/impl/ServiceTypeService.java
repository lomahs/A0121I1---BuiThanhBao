package vn.codegym.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.service.ServiceType;
import vn.codegym.furamaresort.repository.ServiceTypeRepository;
import vn.codegym.furamaresort.service.IServiceTypeService;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> listAllServiceTypes() {
        return serviceTypeRepository.findAll();
    }
}