package com.testrail.base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import com.testrail.APIClient;
import com.testrail.APIException;

public class RailManager {
	
	public static String TEST_RUN_ID = "2";
	
	public static final int TEST_CASE_PASSED_STATUS = 1;
	public static final int TEST_CASE_FAILED_STATUS = 5;
	
	public static void addResultForTestCase(APIClient client, String testCaseId, int status, String error)
			throws IOException, APIException {

		String testRunId = TEST_RUN_ID;

		@SuppressWarnings("rawtypes")
		Map<String, Comparable> data = new HashMap<String, Comparable>();
		data.put("status_id", status);
		data.put("comment", "Test Executed - Status updated automatically from Selenium test automation.");
		client.sendPost("add_result_for_case/" + testRunId + "/" + testCaseId + "", data);

	}
	
	public static void getRESULT(APIClient client, String testCaseId) throws MalformedURLException, IOException, APIException {
		
		Object object = client.sendGet("get_results_for_case/" + TEST_RUN_ID + "/" + testCaseId);
		System.out.println(object.toString());
	}
	
	public static void bySUITE(APIClient client, String projectID, String suiteID) throws MalformedURLException, IOException, APIException {
		Object object = client.sendGet("get_case/" + projectID + "&suite_id" + suiteID);
		System.out.println(object.toString());
	}
	
	public static void byID(APIClient client, String testCaseID) throws MalformedURLException, IOException, APIException {
		Object object = client.sendGet("get_case/" + testCaseID);
		System.out.println(object.toString());
	}
	
	public static void byUSER(APIClient client, String projectID, String suiteID, String userID) throws MalformedURLException, IOException, APIException {
		Object object = client.sendGet("get_case/" + projectID + "&suite_id=" + suiteID + "&created_by=" + userID);
		System.out.println(object.toString());
	}
	
	

}
