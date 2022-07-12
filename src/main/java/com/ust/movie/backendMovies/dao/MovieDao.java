package com.ust.movie.backendMovies.dao;

import com.ust.movie.backendMovies.model.Movie;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface MovieDao {

      default   int insertMovie(Movie movie) {
            Random rand = new Random();
            int id = rand.nextInt();
            return insertMovie(id, movie);
        }
        int insertMovie(int id, Movie movie);
        int updateMovie(int id, Movie movie);
        int deleteMovie(int id);
        List<Movie> queryMovies();
        Optional<Movie> queryMovie(int id);
    }

