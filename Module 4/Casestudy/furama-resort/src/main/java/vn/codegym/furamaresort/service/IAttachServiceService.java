package vn.codegym.furamaresort.service;

import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.service.AttachService;

import java.util.List;

@Service
public interface IAttachServiceService {

    List<AttachService> getAllAttachServices();
}