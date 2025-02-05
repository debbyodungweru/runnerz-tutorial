package com.ixorasoftware.runnerz.user;

public record User(
		Integer id,
		String name,
		String username,
		Address address,
		String phone,
		String website,
		Company company
)
{
}
