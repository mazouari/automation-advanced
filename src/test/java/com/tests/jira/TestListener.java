package com.tests.jira;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

		// first letst get the annotation value from the filed test case. 
		ScriptMetaData meta = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(ScriptMetaData.class);
		
		// get the annotation parameter value as a boolean
		boolean isProductionReady = meta.productionReady();
		// Check if the annotation attribute value is productionReady=true
		if (isProductionReady) {
			System.out.println("IS PRODUCTION READY : "+isProductionReady);
			JiraServiceProvider jiraSP = new JiraServiceProvider(Constants.JIRA_URL, Constants.JIRA_USERNAME, Constants.JIRA_PASSWORD, Constants.JIRA_PROJECT);
			System.out.println("IS PRODUCTION READY :2 ");
			// Add the failed method name as the issue summary
			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName() + " was failed due to an exception";
			
			// get the error message from the exception to description
			String issueDescription = "Exception details : "+  result.getThrowable().getMessage() + "\n";
			// Append the full stack trace to the description.
			issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
			
			jiraSP.createJiraIssue("Bug", issueSummary, issueDescription, Constants.JIRA_USERNAME);
			System.out.println("IS PRODUCTION READY :3 ");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}
}