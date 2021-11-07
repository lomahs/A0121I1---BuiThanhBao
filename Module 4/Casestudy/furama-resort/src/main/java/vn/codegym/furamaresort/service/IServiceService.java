package vn.codegym.furamaresort.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.furamaresort.model.service.Service;

import java.util.Optional;

@org.springframework.stereotype.Service
public interface IServiceService {

    Page<Service> listAllServices(Pageable pageable);

    Service saveService(Service service);

    boolean deleteServiceById(String id);

    Optional<Service> getServiceById(String id);
}