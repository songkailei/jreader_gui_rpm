package net.jreader.dao;

import java.sql.Connection;
import java.util.List;

import net.jreader.dao.bean.TestBean;
import net.jreader.dao.util.DBManager;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class IndexDao {
	
	public List<TestBean> getAll() {
		Connection conn = null;
		QueryRunner run = null;
		List<TestBean> res = null;
		String sql = "select link, img, title from taobao_tg limit 0, 14";
		try {
			conn = DBManager.getInstance().getConnection();
			ResultSetHandler h = new BeanListHandler<TestBean>(TestBean.class);
			run = new QueryRunner();
			res = (List<TestBean>)run.query(conn, sql, h);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return res;
	}

}
