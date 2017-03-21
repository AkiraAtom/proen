/*
 * Copyright(C) 2016 emBex Education Inc. All Rights Reserved.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.LoginBean;

/**
 *ログインDAOクラス
 *
 * @author emBex Education
 * @version 1.00
 */
public class LoginDAO {
	/**
	 *@author Funakoshi Akira
	 * @since 2017/03/18
	 * @param daoPassword DBに設定済みのパスワード
	 */
	private String daoPassword = null;
    /**
     * 検索.
     *
     * @param param
     *            ログイン情報
     * @return 取得結果
     * @throws SQLException
     *             SQLエラー
     * @throws Exception
     *             接続エラー
     */
    public String select(LoginBean param) throws Exception {
        ArrayList<LoginBean> loginInfo = new ArrayList<LoginBean>();
        StringBuffer sql = new StringBuffer("SELECT * FROM m_user ");
        // データベースへの接続の取得
        ConnectionManager cm = ConnectionManager.getInstance();
        try(Connection con = cm.getConnection();) {
                // WHERE句の追加
                sql.append("WHERE ");
                if(!param.getUserId().isEmpty()) {
                    sql.append("user_id = ?");
                }
                PreparedStatement pstmt = con.prepareStatement(sql.toString());
                // パラメーターの設定
                if(!param.getUserId().isEmpty()) {
                    // パスワードを検索
                	pstmt.setString(1,param.getUserId());
                }
            // 検索処理
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
            	LoginBean login = new LoginBean();
            	login.setUserId(rs.getString(1));
            	login.setPassword(rs.getString(2));
            	daoPassword = rs.getString(2);
                loginInfo.add(login);
            }
            con.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return daoPassword;
    }
}
