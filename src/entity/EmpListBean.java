package entity;

/**
 * 従業員一覧情報クラス.
 *
 * @author emBex
 * @version 1.00
 */
public class EmpListBean {

	private String empCode; // 従業員コード
	private String lName; // 氏
	private String fName; // 名
	private String lKanaName; // 氏(ふりがな)
	private String fKanaName; // 名(ふりがな)
	private int sex = 0; // 性別
	private String birthDay; // 誕生日
	private String sectionName; // 所属部署名
	private String empDate; // 入社日

	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlKanaName() {
		return lKanaName;
	}
	public void setlKanaName(String lKanaName) {
		this.lKanaName = lKanaName;
	}
	public String getfKanaName() {
		return fKanaName;
	}
	public void setfKanaName(String fKanaName) {
		this.fKanaName = fKanaName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getEmpDate() {
		return empDate;
	}
	public void setEmpDate(String empDate) {
		this.empDate = empDate;
	}

}
