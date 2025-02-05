package com.ixorasoftware.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run (
		int id,
		@NotEmpty
		String title,
		LocalDateTime started,
		LocalDateTime ended,
		@Positive
		int miles,
		String location)
{
	public Run{
		if(!ended.isAfter(started))
			throw new IllegalArgumentException("Started time cannot be after end time");
	}
}
