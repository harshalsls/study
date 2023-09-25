package com.study.all.example.exercises;

import com.study.all.example.domain.Director;
import com.study.all.example.domain.Genre;

import java.util.List;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
record DirectorGenresPair(Director director,List<Genre> genres) { }
