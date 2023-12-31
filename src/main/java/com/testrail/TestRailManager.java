package com.testrail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestRailManager {

	public static String TEST_RUN_ID = "5";
	public static String TESTRAIL_USERNAME = "zied.hannachi@naxos.fr";
	public static String TESTRAIL_PASSWORD = "Naxos2023!";
	public static String RAILS_ENGINE_URL = "https://ziedhannachi.testrail.io/";
	public static final int TEST_CASE_PASSED_STATUS = 1;
	public static final int TEST_CASE_FAILED_STATUS = 5;

	@SuppressWarnings("unchecked")
	public static void addResultForTestCase(String testCaseId, int status, String error)
			throws IOException, APIException {

		String testRunId = TEST_RUN_ID;

		APIClient client = new APIClient(RAILS_ENGINE_URL);
		client.setUser(TESTRAIL_USERNAME);
		client.setPassword(TESTRAIL_PASSWORD);
		@SuppressWarnings("rawtypes")
		Map data = new HashMap();
		data.put("status_id", status);
		data.put("comment", "Test Executed - Status updated automatically from Selenium test automation.");
		client.sendPost("add_result_for_case/" + testRunId + "/" + testCaseId + "", data);

	}

}
