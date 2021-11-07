package vn.codegym.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.contract.Contract;
import vn.codegym.furamaresort.repository.ContractRepository;
import vn.codegym.furamaresort.service.IContractService;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Optional<Contract> getContractById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public boolean deleteContractById(int id) {
        if (getContractById(id).isPresent()) {
            contractRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public List<Contract> getContractByCustomerId(String id) {
        return contractRepository.getContractByCustomerId(id);
    }
}