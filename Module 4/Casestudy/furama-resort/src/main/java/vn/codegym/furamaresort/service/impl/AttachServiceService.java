package vn.codegym.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.service.AttachService;
import vn.codegym.furamaresort.repository.AttachServiceRepository;
import vn.codegym.furamaresort.service.IAttachServiceService;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService {

    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> getAllAttachServices() {
        return attachServiceRepository.findAll();
    }
}