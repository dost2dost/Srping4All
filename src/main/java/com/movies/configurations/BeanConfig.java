package com.movies.configurations;

import com.movies.models.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by DostM on 6/13/2020.
 */
@Configuration
public class BeanConfig {
    @Bean
    public Movie movie(){
        return Movie.builder()
                .name("Mr:Bean")
                .comment("")
                .rating(9.9)
                .build();
    }
}
