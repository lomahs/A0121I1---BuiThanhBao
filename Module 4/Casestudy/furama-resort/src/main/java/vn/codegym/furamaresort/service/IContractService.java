package vn.codegym.furamaresort.service;

import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.contract.Contract;

import java.util.List;
import java.util.Optional;

@Service
public interface IContractService {

    Contract saveContract(Contract contract);

    List<Contract> getAllContracts();

    Optional<Contract> getContractById(int id);

    boolean deleteContractById(int id);

    List<Contract> getContractByCustomerId(String id);
}