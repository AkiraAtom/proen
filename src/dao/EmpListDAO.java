/*
 * Copyright(C) 2016 emBex Education Inc. All Rights Reserved.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.EmpListBean;

/**
 *従業員一覧情報取得DAOクラス
 *
 * @author emBex Education
 * @version 1.00
 */
public class EmpListDAO {
    /**
     * 一覧情報取得.
     *
     * @return 取得結果
     * @throws SQLException
     *             SQLエラー
     * @throws Exception
     *             接続エラー
     */
	public ArrayList<EmpListBean> select() throws Exception {
        ArrayList<EmpListBean> empListInfo = new ArrayList<EmpListBean>();
        StringBuffer sql = new StringBuffer("SELECT * FROM m_employee ");
        // データベースへの接続の取得
        ConnectionManager cm = ConnectionManager.getInstance();
        try(Connection con = cm.getConnection();) {
        PreparedStatement pstmt = con.prepareStatement(sql.toString());

        // 一覧取得処理
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
        	EmpListBean empList = new EmpListBean();
        	empList.setEmpCode(rs.getString(1));
        	empList.setlName(rs.getString(2));
        	empList.setfName(rs.getString(3));
        	empList.setlKanaName(rs.getString(4));
        	empList.setfKanaName(rs.getString(5));
        	empList.setSex(rs.getInt(6));
        	empList.setBirthDay(rs.getString(7));
        	empList.setSectionName(rs.getString(8));
        	empList.setEmpDate(rs.getString(9));
        	empListInfo.add(empList);
        	System.out.println(rs.getString(1));
        }
        con.close();
    } catch(SQLException e) {
    	System.out.println("処理結果：異常が発生しました。");
        e.printStackTrace();
    }
    return empListInfo;

	}

}
