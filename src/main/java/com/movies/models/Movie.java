package com.movies.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * Created by DostM on 6/13/2020.
 */
@Data
@Builder
@Document(collection="movie")
@NoArgsConstructor
@AllArgsConstructor
@EntityScan
public class Movie {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @NotNull
    @NotEmpty
    @Field(value = "name")
    private String name;
    private String comment;
    private String type;
    private double rating;
}
