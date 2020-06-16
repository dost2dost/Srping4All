package com.movies.services;

import com.movies.models.Movie;
import com.movies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DostM on 6/13/2020.
 */
@Service
public class MovieService {
    @Autowired
    Movie movie;
    @Autowired
    MovieRepository repo;
    public Object getMovies(){


        return repo.findAll();
    }
    public List<Movie> getMovieByName(String name){
        return repo.findByName(name);
    }
    public List<Movie> filterByName(String name){
        return repo.filterByName(name);
    }

    public Movie saveMovie(Movie movie){
        return repo.save(movie);
    }
    public List<Movie> saveMovies(List<Movie> movies){
        List<Movie> newListMovie=new ArrayList<>();
        movies.forEach(movie->{
            newListMovie.add(saveMovie(movie));
        });
        return newListMovie;
    }
}
