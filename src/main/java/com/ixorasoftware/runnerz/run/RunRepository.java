package com.ixorasoftware.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository
{
	private List<Run> runs;

	public List<Run> findAll()
	{
		return runs;
	}

	public Optional<Run> findById(int id)
	{
		return runs.stream()
				.filter(run -> run.id() == id)
				.findFirst();
	}

	@PostConstruct
	private void init()
	{
		runs = new ArrayList<>();

		runs.add(new Run(1,
				"Monday Morning Run",
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(30),
				3,
				Location.INDOOR));

		runs.add(new Run(2,
				"Tuesday Evening Run",
				LocalDateTime.now().plusDays(1),
				LocalDateTime.now().plusDays(1).plusMinutes(45),
				5,
				Location.OUTDOOR));
	}

	public void create(Run run)
	{
		runs.add(run);
	}

	public void update(Run run, int id)
	{
		Optional<Run> existingRun = findById(id);
		existingRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
	}

	public void delete(int id)
	{
		Optional<Run> existingRun = findById(id);
		existingRun.ifPresent(value -> runs.remove(value));
	}
}
