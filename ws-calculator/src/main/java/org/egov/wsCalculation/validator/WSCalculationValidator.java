package org.egov.wsCalculation.validator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.egov.tracer.model.CustomException;
import org.egov.wsCalculation.model.MeterConnectionRequest;
import org.egov.wsCalculation.model.MeterReading;
import org.egov.wsCalculation.model.MeterReadingSearchCriteria;
import org.egov.wsCalculation.model.WaterConnection;
import org.egov.wsCalculation.repository.WSCalculationDao;
import org.egov.wsCalculation.util.CalculatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.jayway.jsonpath.Criteria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WSCalculationValidator {

	@Autowired
	WSCalculationDao wSCalculationDao;
	
	@Autowired
	CalculatorUtil calculationUtil;

	/**
	 * 
	 * @param meterReadingConnectionRequest
	 *            meterReadingConnectionRequest is request for create or update
	 *            meter reading connection
	 * @param isUpdate
	 *            True for create
	 */

	public void validateMeterReading(MeterConnectionRequest meterConnectionRequest, boolean isUpdate) {
		MeterReading meterReading = meterConnectionRequest.getMeterReading();
		Map<String, String> errorMap = new HashMap<>();
		
//		WaterConnection connection = calculationUtil.getWaterConnection(meterConnectionRequest.getRequestInfo(),
//				meterReading.getConnectionNo(), meterConnectionRequest.getRequestInfo().getUserInfo().getTenantId());
//		if(connection == null) {
//			errorMap.put("INVALID METER READING CONNECTION",
//					"Invalid water connection number");
//		}
		MeterReadingSearchCriteria criteria= new MeterReadingSearchCriteria();
		Set<String> connectionNos= new HashSet<>();
		connectionNos.add(meterReading.getConnectionNo());
		criteria.setConnectionNos(connectionNos);
		List<MeterReading> previousMeterReading = wSCalculationDao.searchCurrentMeterReadings(criteria);
		if (previousMeterReading != null && !previousMeterReading.isEmpty()) {
			Integer currentMeterReading = wSCalculationDao.searchCurrentMeterReadings(criteria).get(0)
					.getCurrentReading();
			if (meterReading.getCurrentReading() <= currentMeterReading) {
				errorMap.put("INVALID METER READING CONNECTION",
						"Current meter reading has to be greater than the past current readings in the meter reading table !");
			}
		}
		
		if (meterReading.getCurrentReading() <= meterReading.getLastReading()) {
			errorMap.put("INVALID METER READING CONNECTION",
					"Current Meter Reading cannot be less than last meter reading");
		}
		
		if (meterReading.getMeterStatus() == null) {
			errorMap.put("INVALID METER READING CONNECTION",
					"Meter status can not be null");
		}
		
		if (isUpdate && (meterReading.getCurrentReading() == null)) {
			errorMap.put("INVALID METER READING CONNECTION",
					"Current Meter Reading cannot be update without current meter reading");
		}

		if (isUpdate && meterReading.getId() != null && !meterReading.getId().isEmpty()) {
			int n = wSCalculationDao.isMeterReadingConnectionExist(Arrays.asList(meterReading.getId()));
			if (n > 0) {
				errorMap.put("INVALID METER READING CONNECTION", "Meter reading Id already present");
			}
		}
		if (meterReading.getBillingPeriod() == null || meterReading.getBillingPeriod().isEmpty()) {
			errorMap.put("INVALID METER READING CONNECTION", "Meter Reading cannot be updated without billing period");
		}
		
		if (!errorMap.isEmpty()) {
			throw new CustomException(errorMap);
		}
	}

	/**
	 * validates for the required information needed to do the
	 * calculation/estimation
	 * 
	 * @param detail
	 *            property detail
	 */
	public void validateWaterConnectionForCalculation(WaterConnection waterConnection) {

		Map<String, String> error = new HashMap<>();

		// boolean isVacantLand =
		// PT_TYPE_VACANT_LAND.equalsIgnoreCase(detail.getPropertyType());
		//
		// if(null == detail.getLandArea() && null == detail.getBuildUpArea())
		// error.put(PT_ESTIMATE_AREA_NULL, PT_ESTIMATE_AREA_NULL_MSG);
		//
		// if (isVacantLand && null == detail.getLandArea())
		// error.put(PT_ESTIMATE_VACANT_LAND_NULL,
		// PT_ESTIMATE_VACANT_LAND_NULL_MSG);
		//
		// if (!isVacantLand && CollectionUtils.isEmpty(detail.getUnits()))
		// error.put(PT_ESTIMATE_NON_VACANT_LAND_UNITS,
		// PT_ESTIMATE_NON_VACANT_LAND_UNITS_MSG);

		if (!CollectionUtils.isEmpty(error))
			throw new CustomException(error);
	}

	public void validateMeterReadingSearchCriteria(MeterReadingSearchCriteria criteria) {
		Map<String, String> errorMap = new HashMap<>();
		if (criteria.getConnectionNos() == null || criteria.getConnectionNos().isEmpty()) {
			errorMap.put("INVALID SEARCH CRITERIA ", " Search can not be done without connection no");
		}
		if (!errorMap.isEmpty()) {
			throw new CustomException(errorMap);
		}
	}

}
