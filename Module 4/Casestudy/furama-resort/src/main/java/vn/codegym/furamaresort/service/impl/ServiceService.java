package vn.codegym.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.repository.ServiceRepository;
import vn.codegym.furamaresort.service.IServiceService;

import java.util.Optional;

@Service
public class ServiceService implements IServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Page<vn.codegym.furamaresort.model.service.Service> listAllServices(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public vn.codegym.furamaresort.model.service.Service saveService(vn.codegym.furamaresort.model.service.Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public boolean deleteServiceById(String id) {
        if (getServiceById(id).isPresent()) {
            serviceRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public Optional<vn.codegym.furamaresort.model.service.Service> getServiceById(String id) {
        return serviceRepository.findById(id);
    }
}