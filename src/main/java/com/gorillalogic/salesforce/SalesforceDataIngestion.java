package com.gorillalogic.salesforce;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.gorillalogic.salesforce.model.DynamoUser;
import com.gorillalogic.salesforce.repository.*;
import com.gorillalogic.salesforce.repository.dynamo.DynamoUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
                        AccountRepository.class, CandidateRepository.class, ContactRepository.class,
                        EmployeeRepository.class, UserRepository.class}
                )}
)
@EnableDynamoDBRepositories(
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
                        DynamoUser.class}
                )
        })
@Slf4j
public class SalesforceDataIngestion implements CommandLineRunner {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    private DynamoUserRepository dynamoUserRepository;

    public static void main(String[] args) {
        SpringApplication.run(SalesforceDataIngestion.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);


        CreateTableRequest tableRequest = dynamoDBMapper
                .generateCreateTableRequest(DynamoUser.class);

        tableRequest.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L));

        TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);

        DynamoUser dynamoUser = new DynamoUser("AWS DynamoDB");

        dynamoUser = dynamoUserRepository.save(dynamoUser);

        log.info("User created: "+dynamoUser.toString());

    }
}
