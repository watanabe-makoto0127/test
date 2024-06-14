package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpInfo {
	/*-- メソッド --*/
	public employee getEmployee(String id, String pass) {
		// データベース接続機能
		Connection con = null;
		// ResultSet:データベースの結果セットを表すデータのテーブル
		ResultSet rs = null;
		// SQL 実行機能
		PreparedStatement ps = null;
		// 社員情報格納用クラス
		employee emp = null;
		// sql 文 select
		String sql = "Select *\n"
				+ "From rogin \n"
				+ "left join emp\n"
				+ "on rogin.e_id = emp.e_id\n"
				+ "Where login_id = ? AND pass = ?";
		// select 文の確認
		System.out.println("login-select: " + sql);
		//接続先<MySQL データベースの workbook に文字設定 UTF-8 で接続>
		String url = "jdbc:mysql:///dailywm"
				+ "?useUnicode=true&characterEncoding=UTF-8"
				+ "&useSSL=false";
		// ユーザ名
		String dbuser = "guest01";
		// パスワード
		String dbpass = "password01";
		// MySQL 接続
		try {
			con = DriverManager.getConnection(url, dbuser, dbpass);
			// SQL 実行機能の作成<プレコンパイル>
			ps = con.prepareStatement(sql);
			// 穴埋め
			ps.setString(1, id);
			ps.setString(2, pass);
			// SQL 実行
			rs = ps.executeQuery();
			// 情報があると true
			if (rs.next()) {
				// 情報の分解、クラス User に格納
				emp = new employee();
						emp.setE_id(rs.getString("e_id"));
						emp.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			emp = null;
		} finally {
			// データベース切断
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ignr) {
				} // 何もしない
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignr) {
				} // 何もしない
			}
		}
		return emp;
	}
}
