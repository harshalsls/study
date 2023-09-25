package com.study.all.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director {
	private int id;
	private String name;
	private String imdb;
}
