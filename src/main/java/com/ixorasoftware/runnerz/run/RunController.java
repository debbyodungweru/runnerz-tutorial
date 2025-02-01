package com.ixorasoftware.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController
{
    private final RunRepository runRepository;

	public RunController(RunRepository runRepository)
	{
		this.runRepository = runRepository;
	}

	@GetMapping()
    public List<Run> findAll()
    {
        return runRepository.findAll();
    }

	@GetMapping("/{id}")
	public Run findById(@PathVariable int id)
	{
		Optional<Run> run = runRepository.findById(id);
		if(run.isEmpty())
			throw new NotFoundException("Run %d not found".formatted(id));

		return run.get();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody Run run)
	{
		runRepository.create(run);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@Valid @RequestBody Run run, @PathVariable int id)
	{
		runRepository.update(run, id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id)
	{
		runRepository.delete(id);
	}
}
