package com.gorillalogic.salesforce;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.gorillalogic.salesforce.model.Candidate;
import com.gorillalogic.salesforce.model.Contact;
import com.gorillalogic.salesforce.model.Employee;
import com.gorillalogic.salesforce.model.User;
import com.gorillalogic.salesforce.repository.AccountRepository;
import com.gorillalogic.salesforce.repository.CandidateRepository;
import com.gorillalogic.salesforce.repository.ContactRepository;
import com.gorillalogic.salesforce.repository.EmployeeRepository;
import com.gorillalogic.salesforce.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
                        AccountRepository.class, CandidateRepository.class, ContactRepository.class,
                        EmployeeRepository.class}
                )}
)
@EnableDynamoDBRepositories(
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
                        User.class, Candidate.class, Contact.class, Employee.class}
                )
        })
@Slf4j
public class SalesforceDataIngestion implements CommandLineRunner {

    private AmazonDynamoDB amazonDynamoDB;

    private UserRepository userRepository;

    public SalesforceDataIngestion(AmazonDynamoDB amazonDynamoDB, UserRepository userRepository) {
        this.amazonDynamoDB = amazonDynamoDB;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesforceDataIngestion.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);


        CreateTableRequest tableRequest = dynamoDBMapper
                .generateCreateTableRequest(User.class);

        tableRequest.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L));

        TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);

        User user = new User("AWS DynamoDB");

        user = userRepository.save(user);

        log.info("User created: "+ user.toString());

    }
}
