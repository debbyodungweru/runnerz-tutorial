package com.ixorasoftware.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run (
		int id,
		@NotEmpty
		String title,
		LocalDateTime start,
		LocalDateTime end,
		@Positive
		int miles,
		Location location)
{
	public Run{
		if(!end.isAfter(start))
			throw new IllegalArgumentException("Started time cannot be after end time");
	}
}
