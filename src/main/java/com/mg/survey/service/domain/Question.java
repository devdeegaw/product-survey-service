package com.mg.survey.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(exclude = "product")
@Table(name = "QUESTION")
public class Question {

    @Id
    @GeneratedValue
    @Column(name = "QUESTION_ID")
    private int questionId;

    @Column(name = "QUESTION_TEXT")
    private String questionText;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    @JsonIgnore
    private Product product;
}

