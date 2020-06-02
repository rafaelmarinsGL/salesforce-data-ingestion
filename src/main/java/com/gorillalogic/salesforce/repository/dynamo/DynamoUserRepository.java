package com.gorillalogic.salesforce.repository.dynamo;

import com.gorillalogic.salesforce.model.DynamoUser;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface DynamoUserRepository extends CrudRepository<DynamoUser, String> {
}
