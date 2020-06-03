package com.gorillalogic.salesforce.repository;

import com.gorillalogic.salesforce.model.Contact;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@EnableScan
@RepositoryRestResource(collectionResourceRel = "contacts", path = "contacts")
public interface ContactRepository extends CrudRepository<Contact, String> {
}
