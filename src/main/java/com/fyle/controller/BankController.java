package com.fyle.controller;

import com.fyle.model.Bank;
import com.fyle.model.BankBranches;
import com.fyle.repository.IBankRepository;
import com.fyle.service.BankBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fyle/")
public class BankController {


    @Autowired
    private BankBranchService bankBranchService;

    @GetMapping(value = "bank/bankDetails")
    public ResponseEntity getBankDetails(
            @RequestParam(value = "ifsc") String ifsc,
            @RequestParam(value = "offset") Integer offset,
            @RequestParam(value = "limit") Integer limit)
    {
        List<BankBranches> bankBranchesList = bankBranchService.getBranchOfBank(ifsc, offset, limit);
        return new ResponseEntity(bankBranchesList,HttpStatus.OK);
    }

    @GetMapping(value = "bank/branches")
    public ResponseEntity getBranchDetails(
            @RequestParam(value = "bank_name") String bankName,
            @RequestParam(value = "city") String city,
            @RequestParam(value = "offset") Integer offset,
            @RequestParam(value = "limit") Integer limit)
    {
        List<BankBranches> bankBranchesList = bankBranchService.getBranches(bankName,city, offset, limit);
        return new ResponseEntity(bankBranchesList, HttpStatus.OK);
    }
}
