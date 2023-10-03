package com.study.all.stream.exercises;

import com.study.all.stream.domain.Director;
import com.study.all.stream.domain.Genre;

import java.util.List;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
record DirectorGenresPair(Director director,List<Genre> genres) { }
