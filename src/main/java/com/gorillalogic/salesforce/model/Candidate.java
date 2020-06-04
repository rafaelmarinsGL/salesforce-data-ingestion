package com.gorillalogic.salesforce.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.gorillalogic.salesforce.converter.LocalDateTimeConverter;
import com.gorillalogic.salesforce.enums.CandidateEnums;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@DynamoDBTable(tableName = "Candidate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Candidate {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private String firstName;

    @DynamoDBAttribute
    private String lastName;

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute
    private CandidateEnums.Type type;

    @DynamoDBAttribute
    private String phone;

    @DynamoDBAttribute
    private String mobile;

    @DynamoDBAttribute
    private String email;

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute
    private CandidateEnums.RecordType recordType;

    @DynamoDBAttribute
    private String mailingAddress;

    @DynamoDBAttribute
    private String createdById;

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    private LocalDateTime createdOnDate;

    @DynamoDBAttribute
    private String description;

    @DynamoDBAttribute
    private String techScreenResult;

    @DynamoDBAttribute
    private String techScreenCodeEvalCompletionDate;

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    private LocalDateTime techScreenCompletionDate;

    @DynamoDBAttribute
    private String techScreenWriteup;

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute
    private CandidateEnums.TechScreenScore techScreenScore;

    @DynamoDBAttribute
    private String techScreenerUserId;

    @DynamoDBAttribute
    private String countryCode;

    @DynamoDBAttribute
    private String status;

    @DynamoDBAttribute
    private String skillTestUrl;

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    private LocalDateTime skillTestSentDate;

    @DynamoDBAttribute
    private String skillTestStatus;

    @DynamoDBAttribute
    private String skillTestGrade;

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute
    private CandidateEnums.EnglishTestGrade englishTestGrade;

    @DynamoDBAttribute
    private String communicationSkills;

    @DynamoDBAttribute
    private String gradeLevelRecommendation;

    @DynamoDBAttribute
    private String clientInterviewFeedback;

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute
    private CandidateEnums.Decision decision;


}
