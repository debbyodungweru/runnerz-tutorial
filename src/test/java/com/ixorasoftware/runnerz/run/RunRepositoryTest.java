package com.ixorasoftware.runnerz.run;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RunRepositoryTest
{
	@Autowired
	private RunRepository runRepository;

	@Test
	public void shouldSaveNewRun()
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
}