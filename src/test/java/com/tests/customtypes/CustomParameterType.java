package com.tests.customtypes;

import com.tests.constants.Language;

import io.cucumber.java.ParameterType;

public class CustomParameterType {

	@ParameterType(".*")
	public Language language(String languageName) {
		return Language.valueOf(languageName);
	}
}
