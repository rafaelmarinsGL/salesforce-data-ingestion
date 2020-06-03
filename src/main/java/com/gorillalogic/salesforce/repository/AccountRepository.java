package com.gorillalogic.salesforce.repository;

import com.gorillalogic.salesforce.model.Account;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@EnableScan
@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRepository extends CrudRepository<Account, String> {
}
