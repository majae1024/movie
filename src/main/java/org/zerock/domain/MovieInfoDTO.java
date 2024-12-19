package org.zerock.domain;

import lombok.Data;

@Data

public class MovieInfoDTO {
	private int movieId;
	private String imgSrc;
	private String description;
	private String movieNm;
	private double voteAverage;
	private double salesShare;
	private String certification;
}
