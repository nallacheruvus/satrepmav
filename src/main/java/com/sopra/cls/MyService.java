package com.sopra.cls;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyService {

	@Autowired
	JdbcTemplate jdbc;

	@GetMapping("/firs")
	public List<Logins> retL() {
		List<Logins> ls = new ArrayList<Logins>();
		jdbc.query("select * from logins", new RowMapper<Logins>() {
			@Override
			public Logins mapRow(ResultSet rs, int rowNum) throws SQLException {
				Logins ll = new Logins();
				ll.setUsername(rs.getString(1));
				ll.setPassword(rs.getString(2));
				ls.add(ll);
				return ll;
			}

		});

		return ls;
	}

}
