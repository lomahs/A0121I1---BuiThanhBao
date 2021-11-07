package vn.codegym.furamaresort.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.contract.ContractDetail;

@Service
public interface IContractDetailService {
    ContractDetail saveContractDetail(ContractDetail contractDetail);

    Page<ContractDetail> getAllContractDetails(Pageable pageable);
}