package com.au.local.amazon;

import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import com.amazonaws.services.simplesystemsmanagement.model.GetParametersRequest;
import com.amazonaws.services.simplesystemsmanagement.model.GetParametersResult;

public class GetSSMParameter {
	
	public static void main(String args[]) {
		AWSSimpleSystemsManagement client=AWSSimpleSystemsManagementClientBuilder.defaultClient();
		GetParametersRequest request= new GetParametersRequest();
		request.withNames("name").setWithDecryption(true);;
		GetParametersResult result=client.getParameters(request);
		System.out.println("Name:"+result.getParameters().get(0).getName());
		System.out.println("Value:"+result.getParameters().get(0).getValue());
		
		}

}
