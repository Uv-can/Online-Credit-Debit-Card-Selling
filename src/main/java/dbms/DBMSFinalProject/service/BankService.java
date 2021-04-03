package dbms.DBMSFinalProject.service;

import dbms.DBMSFinalProject.model.Bank;
import dbms.DBMSFinalProject.model.User;
import dbms.DBMSFinalProject.repository.BankRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepo;

    public Long getMovieCount(Bank bank) throws Exception {
        return bankRepo.findCountByMovieId(bank.getBank_id());
    }

    public List<Bank> getAllBankList() {
        List<Bank> banks = new ArrayList<>();
        banks.addAll(bankRepo.findAll());
        return banks;
    }

}
