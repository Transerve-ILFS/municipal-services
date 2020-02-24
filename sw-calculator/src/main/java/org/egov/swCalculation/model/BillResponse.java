package org.egov.swCalculation.model;

import java.util.List;

import org.egov.common.contract.response.ResponseInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BillResponse
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillResponse {

	@JsonProperty("ResposneInfo")
	private ResponseInfo resposneInfo;

	@JsonProperty("Bill")
	private List<Bill> bill;

}
