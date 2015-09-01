package ua.nure.cache.java.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import ua.nure.cache.java.constants.DBQueries;
import ua.nure.cache.java.dao.AttributeDAO;
import ua.nure.cache.java.entity.Attribute;

public class MysqlAttributeDAO implements AttributeDAO {
	Logger log = Logger.getLogger(MysqlAttributeDAO.class);
	@Override
	public int insertAttribute(Attribute attr) {
		int result = -1;
		Connection con = null;
		try {
			con = MysqlDAOFactory.getConnection();
			result = insertAttribute(con, attr);
			if (result !=-1) {
				con.commit();
			} else {
				MysqlDAOFactory.roolback(con);
			}
		} catch (SQLException e) {
			log.error(e);
			MysqlDAOFactory.roolback(con);
		} finally {
			MysqlDAOFactory.close(con);
		}
		return result;
	}

	private int insertAttribute(Connection con, Attribute attr) throws SQLException {
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			pstmt = con.prepareStatement(DBQueries.INSERT_ATTRIBUTE,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, attr.getObjectId());
			pstmt.setString(2, attr.getName());
			if (pstmt.executeUpdate() != 1) {
				return -1;
			}
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				return generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			log.error(e);
		} finally {
			MysqlDAOFactory.closeStatement(pstmt);
		}
		return result;
	}

	@Override
	public void deleteAttribute(int attributeId) {
		
	}

	@Override
	public void updateAttribute(Attribute attr) {
		
	}

	@Override
	public Attribute getAttribute(int attributeId) {
		return null;
		
	}

}