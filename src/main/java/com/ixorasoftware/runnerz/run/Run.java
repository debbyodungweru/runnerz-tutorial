package com.ixorasoftware.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

public record Run (
		@Id
		int id,
		@NotEmpty
		String title,
		LocalDateTime started,
		LocalDateTime ended,
		@Positive
		int miles,
		String location,
		@Version
		Integer version
)
{
	public Run{
		if(!ended.isAfter(started))
			throw new IllegalArgumentException("Started time cannot be after end time");
	}
}
