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
public class PropertyCriteria {

	@NotNull
	private String tenantId;

	private Set<String> propertyIds;
	
	private Set<String> uuids;

	private Set<String> oldpropertyids;
	
	private Status status;

	private String mobileNumber;

	private String name;
	
	private Set<String> ownerIds;
	
	private Long offset;

	private Long limit;
	
}
