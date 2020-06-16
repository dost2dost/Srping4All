package com.movies.repositories;

import com.movies.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DostM on 6/13/2020.
 */
@Repository
public interface MovieRepository extends MongoRepository<Movie,String> {
    List<Movie> findByName(String name);
    @Query("{ 'name':{$regex:?0}}")
    List<Movie> filterByName(String name);

}
