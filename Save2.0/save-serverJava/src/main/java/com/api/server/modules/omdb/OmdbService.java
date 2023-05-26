package com.api.server.modules.omdb;

import com.api.server.modules.movies.MoviesDto;
import com.api.server.modules.omdb.projections.OmdbMovieDto;
import com.api.server.modules.omdb.projections.TopChartMovies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmdbService {

    final
    OmdbConsumer omdbConsumer;

    final
    TopChartConsumer topChartConsumer;

    @Value("${omdb.apiKey}")
    private String apiKey;

    public OmdbService(OmdbConsumer omdbConsumer, TopChartConsumer topChartConsumer) {
        this.omdbConsumer = omdbConsumer;
        this.topChartConsumer = topChartConsumer;
    }

    public List<MoviesDto> searchMovies(String s, String page) {
        return omdbConsumer.searchMovies(apiKey, s, page)
                .getMovieDtoList()
                .stream().map(this::mapOmdbToMoviesDto)
                .toList();
    }

    public List<MoviesDto> searchMovies(String s) {
        return omdbConsumer.searchMovies(apiKey, s)
                .getMovieDtoList()
                .stream().map(this::mapOmdbToMoviesDto)
                .toList();
    }

    public List<MoviesDto> getTopChart() {
        return topChartConsumer.getTopChartMovies()
                .getItems()
                .stream().map(this::mapTopChartToMoviesDto)
                .toList();
    }

    private MoviesDto mapOmdbToMoviesDto(OmdbMovieDto omdbMovieDto) {
        return MoviesDto.builder()
                .name(omdbMovieDto.getTitle())
                .year(omdbMovieDto.getYear())
                .poster(omdbMovieDto.getPoster())
                .build();
    }

    private MoviesDto mapTopChartToMoviesDto(TopChartMovies topChartMovies) {
        return MoviesDto.builder()
                .name(topChartMovies.getTitle())
                .year(topChartMovies.getYear())
                .poster(topChartMovies.getPoster())
                .build();
    }
}
