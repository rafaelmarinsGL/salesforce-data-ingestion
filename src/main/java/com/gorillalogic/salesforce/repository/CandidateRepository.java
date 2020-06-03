package com.gorillalogic.salesforce.repository;

import com.gorillalogic.salesforce.model.Candidate;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@EnableScan
@RepositoryRestResource(collectionResourceRel = "candidates", path = "candidates")
public interface CandidateRepository extends CrudRepository<Candidate, String> {
}
