package vn.codegym.furamaresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.codegym.furamaresort.model.contract.Contract;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select c from Contract as c where c.customer.customerId = :id")
    List<Contract> getContractByCustomerId(String id);
}