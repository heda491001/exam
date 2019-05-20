/*
 * ＪａｖａＤＢアクセス サンプルプログラム
 *
 * Copyright(C)  株式会社ラーニングエージェンシー 2019-
 */

package DAO;

/**
 * 1人の成績表クラス
 *
 * @author xxxx
 * @version 1.00
 */
public class OneRecord implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String studentNo; // 学籍番号
	private String studentName; // 生徒名
	private int math; // 数学
	private int english; // 英語
	private int japanese; // 国語
	private int science; // 理科

	public OneRecord() {
		this.studentNo = "";
		this.studentName = "";
		this.math = 0;
		this.english = 0;
		this.japanese = 0;
		this.science = 0;
	}

	public OneRecord(String studentNo, String studentName, int math, int english,
			int japanese, int science) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.math = math;
		this.english = english;
		this.japanese = japanese;
		this.science = science;
	}

	@Override
	public String toString() {
		return "学籍番号は " + getStudentNo() + "\t" + "氏名は " + getStudentName()
				+ "\t" + "数学は " + getMath() + "点" + "\t" + "英語は "
				+ getEnglish() + "点" + "\t" + "国語は " + getJapanese() + "点"
				+ "\t" + "理科は " + getScience() + "点";
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getJapanese() {
		return japanese;
	}

	public void setJapanese(int japanese) {
		this.japanese = japanese;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

}
