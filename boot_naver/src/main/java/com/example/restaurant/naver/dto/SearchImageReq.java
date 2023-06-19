package com.example.restaurant.naver.dto;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 지역검색 정보요청 파라메터 DTO
// query=갈비집&display=5&start=1&sort=random
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchImageReq {

	private String query ="";
	private String display ="1";
	private String start ="1";
	private String sort ="sim";
	private String filter ="all";
	
	// 매게변수를 query=갈비집&display=5&start=1&sort=random 만들어주는 코드
	public MultiValueMap<String, String> toMultiValueMap(){
		
		LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		
		map.add("query", query);
		map.add("display", display);
		map.add("start", start);
		map.add("sort", sort);
		map.add("filter", filter);
		return map;
	}
	
}
