package hoge;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	private static final String FLG_OFF = "0";
	private static final String FLG_ON = "1";
	private static final String COMPLETION_DATE = "完了日";
	private static final String STATUS1 = "001";
	private static final String STATUS2 = "002";
	private static final String STATUS3 = "003";

	public static void main(String[] args) {

		List<HumanDataBean> humanList = settingHumanData();
		List<FlowHeaderBean> flowHeaderList = settingFlowHeader();
		List<StatusDataBean> statusList = settingStatusData();

		List<String> header = new ArrayList<String>();
		// ヘッダが固定の項目はenumで全取得
		for (FixHeaderEnum month : FixHeaderEnum.values()) {
			header.add(month.toString());
		}
		// ヘッダが必要か不要か
		Map<String, List<Integer>> isHeadermap = new HashMap<String, List<Integer>>();
		List<Integer> colList = null;
		for (FlowHeaderBean bean : flowHeaderList) {
			colList = new ArrayList<Integer>();
			for (int i = 1; i <= 3; i++) {
				String name = "col" + String.valueOf(i);
				if (isHeader(bean, name)) {
					header.add(bean.getStatusName() + COMPLETION_DATE + String.valueOf(i));
					colList.add(i);
				}
			}
			isHeadermap.put(bean.getStatus(), colList);
		}

		System.out.println("header");
		for (String str : header) {
			System.out.println(str);
		}

		List<String> dataList = new ArrayList<String>();
		for (HumanDataBean bean : humanList) {
			dataList.add("********************************************");
		    for (Field field : bean.getClass().getDeclaredFields()) {
		        field.setAccessible(true);
		        dataList.add(getDate(bean, field.getName()));
		    }
			String id = bean.getId();
			for (StatusDataBean stBean : statusList) {
				if (!id.equals(stBean.getId())) {
					continue;
				}
				List<Integer> list = isHeadermap.get(stBean.getStatus());
				for (Integer i : list) {
					String name = "compDate" + String.valueOf(i);
					String compData = getDate(stBean, name);
					dataList.add(stBean.getStatus() + ":" + compData);
				}
			}
		}
		System.out.println("data");
		for (String str : dataList) {
			System.out.println(str);
		}

	}

	private static List<FlowHeaderBean> settingFlowHeader() {
		FlowHeaderBean bean1 = new FlowHeaderBean(STATUS1, "種別1", "0", "0", "0");
		FlowHeaderBean bean2 = new FlowHeaderBean(STATUS2, "種別2", "1", "0", "1");
		FlowHeaderBean bean3 = new FlowHeaderBean(STATUS3, "種別3", "1", "0", "1");
		List<FlowHeaderBean> beanList = new ArrayList<FlowHeaderBean>();
		beanList.add(bean1);
		beanList.add(bean2);
		beanList.add(bean3);
		return beanList;
	}

	private static List<StatusDataBean> settingStatusData() {
		List<StatusDataBean> beanList = new ArrayList<StatusDataBean>();
		StatusDataBean bean1 = new StatusDataBean("001", STATUS1, "20110101", "20110102", "20110103");
		StatusDataBean bean2 = new StatusDataBean("001", STATUS2, "20120101", "20120102", "20120103");
		StatusDataBean bean3 = new StatusDataBean("001", STATUS3, "20130101", "20130102", "20130103");
		StatusDataBean bean4 = new StatusDataBean("002", STATUS1, "20140101", "20140102", "20140103");
		StatusDataBean bean5 = new StatusDataBean("003", STATUS2, "20150101", "20150102", "20150103");
		StatusDataBean bean6 = new StatusDataBean("004", STATUS3, "20160101", "20160102", "20160103");
		beanList.add(bean1);
		beanList.add(bean2);
		beanList.add(bean3);
		beanList.add(bean4);
		beanList.add(bean5);
		beanList.add(bean6);
		return beanList;
	}

	private static List<HumanDataBean> settingHumanData() {
		List<HumanDataBean> beanList = new ArrayList<HumanDataBean>();
		HumanDataBean bean1 = new HumanDataBean("001", "山田");
		HumanDataBean bean2 = new HumanDataBean("002", "山下");
		HumanDataBean bean3 = new HumanDataBean("003", "山元");
		beanList.add(bean1);
		beanList.add(bean2);
		beanList.add(bean3);
		return beanList;
	}

	private static boolean isHeader(FlowHeaderBean bean, String name) {
		String result = null;
		try {
			Field f = bean.getClass().getDeclaredField(name);
			f.setAccessible(true);
			result = (String) f.get(bean);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		boolean flg = false;
		if (FLG_ON.equals(result)) {
			flg = true;
		}
		return flg;
	}

	private static String getDate(Object bean, String name) {
		String result = null;
		try {
			Field f = bean.getClass().getDeclaredField(name);
			f.setAccessible(true);
			result = (String) f.get(bean);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}
}
