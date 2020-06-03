package com.gorillalogic.salesforce.service.impl;

import com.gorillalogic.salesforce.repository.AccountRepository;
import com.gorillalogic.salesforce.repository.CandidateRepository;
import com.gorillalogic.salesforce.repository.ContactRepository;
import com.gorillalogic.salesforce.repository.EmployeeRepository;
import com.gorillalogic.salesforce.repository.UserRepository;
import com.gorillalogic.salesforce.service.IngestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IngestionServiceImpl implements IngestionService {

    private AccountRepository accountRepository;
    private CandidateRepository candidateRepository;
    private ContactRepository contactRepository;
    private EmployeeRepository employeeRepository;
    private UserRepository userRepository;

    public IngestionServiceImpl(AccountRepository accountRepository, CandidateRepository candidateRepository, ContactRepository contactRepository, EmployeeRepository employeeRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.candidateRepository = candidateRepository;
        this.contactRepository = contactRepository;
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void ingestData() {
        log.info("Ingesting Data...");
    }
}
