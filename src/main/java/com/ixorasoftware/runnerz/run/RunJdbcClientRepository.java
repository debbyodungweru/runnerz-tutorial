package com.ixorasoftware.runnerz.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RunJdbcClientRepository
{
	private static final Logger log = LoggerFactory.getLogger(RunJdbcClientRepository.class);
	private final JdbcClient jdbcClient;

	public RunJdbcClientRepository(JdbcClient jdbcClient)
	{
		this.jdbcClient = jdbcClient;
	}

	public List<Run> findAll()
	{
		return jdbcClient.sql("select * from run")
				.query(Run.class)
				.list();
	}

	public Optional<Run> findById(Integer id)
	{
		return jdbcClient.sql("select * from run where id = ?")
				.param(id)
				.query(Run.class)
				.optional();
	}

	public int create(Run run)
	{
		return jdbcClient.sql("insert into run(id, title, started, ended, miles, location) values(?, ?, ?, ?, ?, ?)")
				.params(List.of(run.getId(), run.getTitle(), run.getStarted(), run.getEnded(), run.getMiles(),String.valueOf(run.getLocation())))
				.update();
	}

	public int update(Run run, Integer id)
	{
		return jdbcClient.sql("update run set title = ?, started = ?, ended = ?, miles = ?, location = ? where id = ?")
				.params(List.of(run.getTitle(), run.getStarted(), run.getEnded(), run.getMiles(), String.valueOf(run.getLocation()), id))
				.update();
	}

	public int delete(Integer id)
	{
		return jdbcClient.sql("delete from run where id = ?")
				.params( id)
				.update();
	}
}
