package com.fyle.repository;

import com.fyle.model.BankBranches;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBankBranchesRepository extends PagingAndSortingRepository<BankBranches, Integer> {
    List<BankBranches> findByIfsc(String ifsc, Pageable pageList);

    @Query(value = "select * from bank_branches where bank_name = :bankName and city = :city", nativeQuery = true)
    List<BankBranches> findByBankNameAndCity(@Param(value = "bankName") String bankName,@Param(value = "city") String city, Pageable pageList);
}
