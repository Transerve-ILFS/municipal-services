package org.egov.swCalculation.model;

import java.util.Set;

import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssessmentSearchCriteria {
	
	@NotNull
	private String tenantId;

	private Set<String> ids;

	private Set<String> assessmentNumbers;

	private String financialYear;
		
	private Set<String> propertyIds;
	
	private Status status;
	
	private Long offset;

	private Long limit;

}
