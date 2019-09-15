package com.fyle.service;

import com.fyle.model.BankBranches;
import com.fyle.repository.IBankBranchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankBranchService {


    @Autowired
    private IBankBranchesRepository iBankBranchesRepository;

    public List<BankBranches> getBranchOfBank(String ifsc, Integer offset, Integer limit) {
        Pageable pageList = PageRequest.of(offset, limit);
        List<BankBranches> bankBranchesList = iBankBranchesRepository.findByIfsc(ifsc, pageList);
        return bankBranchesList;
    }

    public List<BankBranches> getBranches(String bankName, String city, Integer offset, Integer limit) {
        Pageable pageList = PageRequest.of(offset, limit);
        List<BankBranches> bankBranchesList = iBankBranchesRepository.findByBankNameAndCity(bankName,city, pageList);
        return bankBranchesList;
    }
}
