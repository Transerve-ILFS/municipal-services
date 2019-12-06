package org.egov.wsCalculation.config;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Component
public class WSCalculationConfiguration {

	@Value("${egov.ws_calculation.meterReading.default.limit}")
	private Integer meterReadingDefaultLimit;

	@Value("${egov.ws_calculation.meterReading.default.offset}")
	private Integer meterReadingDefaultOffset;


	/*
	 * Calculator Configs
	 */

	// billing service
	@Value("${egov.billingservice.host}")
	private String billingServiceHost;

	@Value("${egov.taxhead.search.endpoint}")
	private String taxheadsSearchEndpoint;

	@Value("${egov.taxperiod.search.endpoint}")
	private String taxPeriodSearchEndpoint;

	@Value("${egov.demand.create.endpoint}")
	private String demandCreateEndPoint;

	@Value("${egov.demand.update.endpoint}")
	private String demandUpdateEndPoint;

	@Value("${egov.demand.search.endpoint}")
	private String demandSearchEndPoint;
	
	@Value("${egov.demand.billexpirytime}")
	private Long demandBillExpiryTime;

	@Value("${egov.bill.gen.endpoint}")
	private String billGenEndPoint;

	// MDMS
	@Value("${egov.mdms.host}")
	private String mdmsHost;

	@Value("${egov.mdms.search.endpoint}")
	private String mdmsEndPoint;
	
    @Value("${egov.bill.gen.endpoint}")
    private String billGenerateEndpoint;

	// water demand configs

	@Value("${ws.module.code}")
	private String wsModuleCode;

	@Value("${ws.module.minpayable.amount}")
	private Integer ptMinAmountPayable;

	@Value("${ws.financialyear.start.month}")
	private String financialYearStartMonth;
	
	
	@Value("${egov.demand.businessservice}")
	private String businessService;
	  
	@Value("${egov.demand.minimum.payable.amount}")
	 private BigDecimal minimumPayableAmount;
	  
	 //water Registry
	 @Value("${egov.ws.host}")
	 private String waterConnectionHost;

	 @Value("${egov.wc.search.endpoint}")
	 private String waterConnectionSearchEndPoint;
	  

}
