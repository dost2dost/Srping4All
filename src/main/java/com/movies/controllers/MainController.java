package com.movies.controllers;

import com.exceptions.ResourceNotFoundErros;
import com.movies.models.Movie;
import com.movies.models.ResponseData;
import com.movies.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;


/**
 * Created by DostM on 6/13/2020.
 */
@RestController
@RequestMapping("/movies")
@Validated
public class MainController {
    @Autowired
    MovieService movieService;


    @GetMapping("/getMovies")
    public Object getMovies(@RequestParam String filterBy){
        List<Movie> movies=null;
        if(filterBy!=null && !filterBy.isEmpty())
        {
        movies=movieService.filterByName(filterBy);
        }else{
            movies= (List<Movie>) movieService.getMovies();
        }

        if(movies==null||movies.isEmpty()) {
            return ResponseData.builder().success(Boolean.TRUE).message("Movie not Found").data(movies)
                    .build();
        }
        return ResponseData.builder().success(Boolean.TRUE).data(movies)
                .build();
    }

    @GetMapping("/{name}")
    public ResponseData getMovieByName(@PathVariable String name){
        List<Movie> movies= (List<Movie>) movieService.getMovieByName(name);
        if(movies==null||movies.isEmpty()) {
            return ResponseData.builder().success(Boolean.TRUE).message("Movie not Found").data(movies)
                    .build();
        }
        return ResponseData.builder().success(Boolean.TRUE).data(movies)
                .build();
    }

    @PostMapping(path = "/saveMovie")
    public ResponseData saveMovie(@Valid @RequestBody  Movie  movie,BindingResult bindingResult ){
        Movie createdMovie=movieService.saveMovie(movie);
        createdMovie=null;
        if(createdMovie==null){
            throw new ResourceNotFoundErros("Resource not found errors ");

        }
        return ResponseData.builder().success(Boolean.TRUE).data(createdMovie).message("Movie Saved")
                .build();
    }


    @PostMapping(path = "/saveMovies")
    public ResponseData saveMovies(@RequestBody List<Movie> movies){

        List<Movie> movieList = movieService.saveMovies(movies);

        if(movieList==null||movieList.isEmpty()) {
            return ResponseData.builder().success(Boolean.TRUE).data("movi not saved")
                    .build();
        }
        return ResponseData.builder().success(Boolean.TRUE).data(movieList)
                .build();
    }
    //@DeleteMapping
    //@PostMapping
}