package org.egov.swCalculation.constants;

import org.egov.swCalculation.model.DemandStatus;

public class SWCalculationConstant {

	public static final String TAXPERIOD_MASTER_KEY = "TAXPERIOD";
	
	public static final String TAXHEADMASTER_MASTER_KEY = "WS_TAX";
	
	public static final String FINANCIALYEAR_MASTER_KEY = "2019-20";
	
	public static final String FINANCIAL_YEAR_STARTING_DATE = "startingDate";

	public static final String FINANCIAL_YEAR_ENDING_DATE = "endingDate";
	
	public static final String URL_PARAMS_SEPARATER = "?";
	
	public static final String MDMS_ROUNDOFF_TAXHEAD= "WS_ROUNDOFF";
	
	public static final String TENANT_ID_FIELD_FOR_SEARCH_URL = "tenantId=";
	
	public static final String SEPARATER = "&";
	
	public static final String SERVICE_FIELD_FOR_SEARCH_URL = "service=";
	
	public static final String SERVICE_FIELD_VALUE_WS = "SW";
	
	public static final String MDMS_FINACIALYEAR_PATH = "$.MdmsRes.egf-master.FinancialYear[?(@.code==\"{}\")]";
	
	
	public static final String EG_WS_FINANCIAL_MASTER_NOT_FOUND = "EG_WS_FINANCIAL_MASTER_NOT_FOUND";
	
	public static final String EG_WS_FINANCIAL_MASTER_NOT_FOUND_MSG = "No Financial Year data is available for the given year value of : ";
	
	public static final String FINANCIAL_YEAR_MASTER = "FinancialYear";
	
	public static final String FINANCIAL_YEAR_RANGE_FEILD_NAME = "finYearRange";
	
	public static final String FINANCIAL_MODULE = "egf-master";
	
	public static final String SW_TAX_MODULE = "sw-services-calculation";
	
	public static final String SW_REBATE_MASTER = "Rebate";
	
	public static final String SW_SEWERAGE_CESS_MASTER = "SewerageCess";
	
	public static final String SW_PENANLTY_MASTER = "Penalty";

	public static final String SW_INTEREST_MASTER = "Interest";

	public static final String SW_BILLING_SLAB_MASTER = "SCBillingSlab";
	
	public static final String EMPTY_DEMAND_ERROR_CODE = "EMPTY_DEMANDS";

	public static final String EMPTY_DEMAND_ERROR_MESSAGE = "No demands found for the given bill generate criteria";
	
	public static final String DEMAND_CANCELLED_STATUS = DemandStatus.CANCELLED.toString();
	
	public static final String CONSUMER_CODE_SEARCH_FIELD_NAME = "consumerCode=";
	
	public static final String WS_CONSUMER_CODE_SEPARATOR = ":";
	
	public static final String EG_WS_INVALID_DEMAND_ERROR = "EG_WS_INVALID_DEMAND_ERROR";
	public static final String EG_WS_INVALID_DEMAND_ERROR_MSG = " Bill cannot be generated for previous assessments in a year, please use the latest assesmment to pay";
	

}
