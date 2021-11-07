package vn.codegym.furamaresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.furamaresort.model.service.AttachService;

@Repository
public interface AttachServiceRepository extends JpaRepository<AttachService, Integer> {
}