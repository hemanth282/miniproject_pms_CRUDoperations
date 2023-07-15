package com.pms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	Connection conn = DBUtil.getDBConnection();

	public int addProd(Product prod) {

		String insertQuery = "insert into product values(?,?,?,?)";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);

			pstmt.setInt(1, prod.getPid());
			pstmt.setString(2, prod.getPname());
			pstmt.setDouble(3, prod.getPrice());
			pstmt.setString(4, prod.getDom());

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;

	}

	public int updateProd(Product prod) {
		String updateQuery = "update product set pname =? , price =? ,dom =? where pid = ?";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);

			pstmt.setString(1, prod.getPname());
			pstmt.setDouble(2, prod.getPrice());
			pstmt.setString(3, prod.getDom());
			pstmt.setInt(4, prod.getPid());

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;

	}

	public int deleteProdById(int pid) {
		String deleteQuery = "delete from product where pid = ?";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(deleteQuery);

			pstmt.setInt(1, pid);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;

	}

	public Product getProdById(int pid) {
		String selectQuery = "select * from product where pid = ?";

		Product prod = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);

			pstmt.setInt(1, pid);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int pid1 = rs.getInt("pid");
				String pname = rs.getString("pname");
				double price = rs.getDouble("price");
				String dom = rs.getString("dom");

				prod = new Product();
				prod.setPid(pid1);
				prod.setPname(pname);
				prod.setPrice(price);
				prod.setDom(dom);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prod;

	}

	public List<Product> getAll() {
		String selectAllQuery = "select * from product";

		List<Product> list = new ArrayList<Product>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAllQuery);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				double price = rs.getDouble("price");
				String dom = rs.getString("dom");
				
				Product prod = new Product();
				list.add(prod);

				prod.setPid(pid);
				prod.setPname(pname);
				prod.setPrice(price);
				prod.setDom(dom);
				

			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return list;

	}
}
