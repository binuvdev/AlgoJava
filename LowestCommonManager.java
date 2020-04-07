package com.java.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LowestCommonManager {

	static Map<Character, OrgChart> orgCharts;
	static String alphabet;

	static {
		orgCharts = new HashMap<Character, OrgChart>();
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (char a : alphabet.toCharArray()) {
			orgCharts.put(a, new OrgChart(a));
		}

		orgCharts.get('A').addDirectReports(new OrgChart[] { orgCharts.get('B'), orgCharts.get('C'), orgCharts.get('D'),
				orgCharts.get('E'), orgCharts.get('F') });
		orgCharts.get('B')
				.addDirectReports(new OrgChart[] { orgCharts.get('G'), orgCharts.get('H'), orgCharts.get('I') });
		orgCharts.get('C').addDirectReports(new OrgChart[] { orgCharts.get('J') });
		orgCharts.get('D').addDirectReports(new OrgChart[] { orgCharts.get('K'), orgCharts.get('L') });
		orgCharts.get('F').addDirectReports(new OrgChart[] { orgCharts.get('M'), orgCharts.get('N') });
		orgCharts.get('H').addDirectReports(
				new OrgChart[] { orgCharts.get('O'), orgCharts.get('P'), orgCharts.get('Q'), orgCharts.get('R') });
		orgCharts.get('K').addDirectReports(new OrgChart[] { orgCharts.get('S') });
		orgCharts.get('P').addDirectReports(new OrgChart[] { orgCharts.get('T'), orgCharts.get('U') });
		orgCharts.get('R').addDirectReports(new OrgChart[] { orgCharts.get('V') });
		orgCharts.get('V')
				.addDirectReports(new OrgChart[] { orgCharts.get('W'), orgCharts.get('X'), orgCharts.get('Y') });
		orgCharts.get('X').addDirectReports(new OrgChart[] { orgCharts.get('Z') });
	}

	public static void main(String[] args) {
		OrgChart commonManager = getLowestCommonManager(orgCharts.get('A'), orgCharts.get('A'), orgCharts.get('B'));
		System.out.println(commonManager.name);
	}

	static class OrgChart {
		public char name;
		public List<OrgChart> directReports;

		OrgChart(char name) {
			this.name = name;
			this.directReports = new ArrayList<OrgChart>();
		}

		// This method is for testing only.
		public void addDirectReports(OrgChart[] directReports) {
			for (OrgChart directReport : directReports) {
				this.directReports.add(directReport);
			}
		}
	}

	public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
		OrgInfo aOrgInfo = findLowestCommonManager(topManager, reportOne, reportTwo);

		return aOrgInfo.manager;
	}

	public static OrgInfo findLowestCommonManager(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
		int numberOfImpReports = 0;
		for (OrgChart aManager : manager.directReports) {
			OrgInfo dirRepInfo = findLowestCommonManager(aManager, reportOne, reportTwo);
			if (dirRepInfo.manager != null)
				return dirRepInfo;
			numberOfImpReports += dirRepInfo.numberOfDirects;
		}
		if (manager == reportOne || manager == reportTwo)
			numberOfImpReports += 1;

		if (numberOfImpReports == 2) {
			return (new OrgInfo(manager, numberOfImpReports));
		}

		return (new OrgInfo(null, numberOfImpReports));
	}

	public static class OrgInfo {
		OrgChart manager = null;
		int numberOfDirects = 0;

		OrgInfo(OrgChart manager, int numberOfReports) {
			this.manager = manager;
			this.numberOfDirects = numberOfReports;
		}

	}

}
