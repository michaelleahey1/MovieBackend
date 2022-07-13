package com.ust.movie.backendMovies.dao;

import com.ust.movie.backendMovies.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

    @Repository("MovieRepository")
    public class MovieRepository implements MovieDao {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        private static List<Movie> movie = new ArrayList<>();

        @Override
        public int insertMovie(int id, Movie movie) {
            String sql = "INSERT INTO MOVIES (Title, Debut, Genre, Rating, Director) VALUES (?, ?, ?, ?,?)";
            return jdbcTemplate.update(sql,
                    new Object[]{movie.getTitle(), movie.getDebut(), movie.getGenre(), movie.getRating(), movie.getDirector()});
        }

        @Override
        public int updateMovie(int id, Movie movie) {
            String sql = "UPDATE MOVIES SET Title=?, Debut=?, Genre=?, Rating=?,Director=? WHERE ID=?";
            return jdbcTemplate.update(sql,
                    new Object[]{movie.getTitle(), movie.getDebut(), movie.getGenre(), movie.getRating(), movie.getDirector(), id});
        }

        @Override
        public int deleteMovie(int id) {
            String sql = "DELETE FROM MOVIE WHERE ID=?";
            return jdbcTemplate.update(sql, id);
        }

        @Override
        public List<Movie> queryMovies() {
            String sql = "SELECT * FROM MOVIES";
            return jdbcTemplate.query(sql,
                    BeanPropertyRowMapper.newInstance(Movie.class));
        }

        @Override
        public Optional<Movie> queryMovie(int id) {
            Movie movie = null;
            try {
                String sql = "SELECT * FROM MOVIES WHERE ID=?";
                movie = jdbcTemplate.queryForObject(sql,
                        BeanPropertyRowMapper.newInstance(Movie.class), id);
                return Optional.ofNullable(movie);
            } catch (IncorrectResultSizeDataAccessException e) {
                return Optional.ofNullable(movie);
            }
        }
    }

