package com.ixorasoftware.runnerz.run;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RunRepositoryTest
{
	@Autowired
	private RunRepository runRepository;

	@Test
	public void save_shouldSaveNewRun()
	{
		//Given
		Run run = new Run("Sunday Evening Run",
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(30),
				2,
				Location.OUTDOOR);

		//When
		Run savedRun = runRepository.save(run);

		//Assert
		Assertions.assertThat(savedRun).isEqualTo(run);
	}

	@Test
	public void findAll_shouldReturnAllRuns()
	{
		//Given
		Run run1 = new Run("Sunday Evening Run",
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(30),
				2,
				Location.OUTDOOR);

		Run run2 = new Run("Thursday Morning Run",
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(30),
				4,
				Location.INDOOR);

		runRepository.save(run1);
		runRepository.save(run2);

		//When
		List<Run> runs = runRepository.findAll();

		//Assert
		Assertions.assertThat(runs).hasSize(2);
	}

	@Test
	public void findById_shouldReturnRun()
	{
		//Given
		Run run = new Run("Sunday Evening Run",
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(30),
				2,
				Location.OUTDOOR);

		Run savedRun = runRepository.save(run);

		//When
		Run foundRun = runRepository.findById(savedRun.getId()).orElse(null);

		//Assert
		Assertions.assertThat(foundRun).isNotNull();
		Assertions.assertThat(foundRun).isEqualTo(savedRun);
	}
}