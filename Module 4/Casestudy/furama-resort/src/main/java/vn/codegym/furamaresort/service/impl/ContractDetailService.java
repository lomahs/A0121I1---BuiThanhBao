package vn.codegym.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.contract.ContractDetail;
import vn.codegym.furamaresort.repository.ContractDetailRepository;
import vn.codegym.furamaresort.service.IContractDetailService;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public ContractDetail saveContractDetail(ContractDetail contractDetail) {
        return contractDetailRepository.save(contractDetail);
    }

    @Override
    public Page<ContractDetail> getAllContractDetails(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }
}