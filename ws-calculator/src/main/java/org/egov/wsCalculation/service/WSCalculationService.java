package org.egov.wsCalculation.service;

import org.egov.wsCalculation.model.CalculationReq;
import org.egov.wsCalculation.model.CalculationRes;

import java.util.List;
import java.util.Map;

import org.egov.common.contract.request.RequestInfo;
import org.egov.wsCalculation.model.Calculation;
import org.egov.wsCalculation.model.CalculationCriteria;

public interface WSCalculationService {

	public CalculationRes getCalculation(CalculationReq calculationReq);
	
	public void jobscheduler();
}
