package com.ixorasoftware.runnerz.run;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

@Entity
public class Run
{
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty
	private String title;
	private LocalDateTime started;
	private LocalDateTime ended;
	@Positive
	private int miles;
	private Location location;
	@Version
	private int version = 1;

	public Run()
	{
	}

	public Run(String title, LocalDateTime started, LocalDateTime ended, int miles, Location location)
	{
		this(0, title, started, ended, miles, location);
	}

	public Run(int id, String title, LocalDateTime started, LocalDateTime ended, int miles, Location location)
	{
		if(!ended.isAfter(started))
			throw new IllegalArgumentException("Started time cannot be after end time");

		this.id = id;
		this.title = title;
		this.started = started;
		this.ended = ended;
		this.miles = miles;
		this.location = location;
	}

	public int getId()
	{
		return id;
	}

	public String getTitle()
	{
		return title;
	}

	public LocalDateTime getStarted()
	{
		return started;
	}

	public LocalDateTime getEnded()
	{
		return ended;
	}

	public int getMiles()
	{
		return miles;
	}

	public Location getLocation()
	{
		return location;
	}

	public int getVersion()
	{
		return version;
	}
}

