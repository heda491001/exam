package Model;

import java.util.Comparator;
import java.util.List;

import DAO.*;

public class getDate {
	public static dbBean getdata(String args, String id) {
		dbBean result = null;
		/* 判断 */
		if (args.equals("select")) {
			OneRecord t = ExamDAO.find(id);
			if (t != null) {
				result = new dbBean(t);
			}
			return result;
		} else {
			/* data貰う */
			List<OneRecord> records = ExamDAO.findAll();
			Comparator<OneRecord> c;
			/* 整列 */
			switch (args) {
			case "english":
				c = new Comparator<OneRecord>() {
					@Override
					public int compare(OneRecord o1, OneRecord o2) {
						return (o2.getEnglish() - o1.getEnglish());
					}
				};
				break;
			case "math":
				c = new Comparator<OneRecord>() {
					@Override
					public int compare(OneRecord o1, OneRecord o2) {
						return (o2.getMath() - o1.getMath());
					}
				};
				break;
			case "japanese":
				c = new Comparator<OneRecord>() {
					@Override
					public int compare(OneRecord o1, OneRecord o2) {
						return (o2.getJapanese() - o1.getJapanese());
					}
				};
				break;
			case "science":
				c = new Comparator<OneRecord>() {
					@Override
					public int compare(OneRecord o1, OneRecord o2) {
						return (o2.getScience() - o1.getScience());
					}
				};
				break;
			default:
				c = new Comparator<OneRecord>() {
					@Override
					public int compare(OneRecord o1, OneRecord o2) {
						return 0;
					}
				};
				break;
			}
			records.sort(c);
			result = new dbBean(records);
		}
		return result;
	}
}
