package com.ixorasoftware.runnerz.run;

import java.time.LocalDateTime;

public record Run (
		int id,
		String title,
		LocalDateTime start,
		LocalDateTime end,
		int miles,
		Location location)
{
}
