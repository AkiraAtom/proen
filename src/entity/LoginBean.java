package entity;

import javax.servlet.http.HttpServletRequest;

/**
 * ログイン情報クラス.
 *
 * @author emBex
 * @version 1.00
 */
public class LoginBean {

    private String userId; // ID
    public String password; // 書籍名


    /**
     * ユーザIDを取得する.
     *
     * @return userId
     */
	public String getUserId() {
		return userId;
	}

    /**
     * ユーザIDを設定する.
     *
     * @param userId
     *
     */
	public void setUserId(String userId) {
		this.userId = userId;
	}

    /**
     * パスワードを取得する.
     *
     * @return password
     */
	public String getPassword() {
		return password;
	}

    /**
     * パスワードを設定する.
     *
     * @param password
     *
     */
	public void setPassword(String password) {
		this.password = password;
	}

    /**
     * リクエスト情報からログイン情報を生成.
     *
     * @param request
     *            リクエスト
     * @return ログイン情報
     */
    public LoginBean createLoginBean(HttpServletRequest request) {

    	LoginBean loginBean = new LoginBean();
    	loginBean.setUserId(request.getParameter("userId"));
    	loginBean.setPassword(request.getParameter("password"));

        return loginBean;
    }

}
