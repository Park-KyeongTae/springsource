package com.spring.memo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 // @Setter @Getter @ToString @AllArgsConstructor @NoArfsContructor

@NoArgsConstructor
@AllArgsConstructor
@Data // get,set,기본생성자,toString
public class ItemDTO {

	private int no;
	private String name;
	private int price;
	
}
