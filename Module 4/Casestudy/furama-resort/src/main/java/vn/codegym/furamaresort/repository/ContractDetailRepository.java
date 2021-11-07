package vn.codegym.furamaresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furamaresort.model.contract.ContractDetail;

public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
}