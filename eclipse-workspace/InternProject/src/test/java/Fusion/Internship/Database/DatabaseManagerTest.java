package Fusion.Internship.Database;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class DatabaseManagerTest {

	@Test
	void test() throws SQLException {
		System.out.println("openConnection");
		Connection result = Fusion.Internship.Database.DatabaseManager.openConnection();
		assertEquals(result != null, true);
	}

}
