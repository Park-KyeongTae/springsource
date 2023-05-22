/**
 *  form submit 되기 전 유효성 검증
 * 
 *  1) 내용은 비어 있지 않아야 함(단 description은 내용이 없어도 됨)
 *  2) 코드는 무조건 4자리 입력되었는지 확인
 *  3) 가격은 숫자로 입력되었는지 확인
 * 
 * 
 * 
 * 1,2,3 만족 시 
 */
document.querySelector(".btn-success").addEventListener("click",()=> location.href=path);





const form = document.querySelector("form") // form 지정
form.addEventListener("submit",(e)=>{ // 이벤트 지정
	
	e.preventDefault(); // 태그 이벤트 막아줘
	
	const code = document.querySelector("#code");
	const title = document.querySelector("#title");
	const writer = document.querySelector("#writer");
	const price = document.querySelector("#price");
	
	if(code.value === "" || code.value.length !== 4 || isNaN(code.value)){ 
		alert("코드를 확인해 주세요");
		code.select(); // 블럭잡아줘
		return;
	} else if(title.value ===""){
		alert("도서명를 확인해 주세요");
		title.select();
		return;
	} else if(writer.value ===""){
		alert("저자를 확인해 주세요");
		writer.select();
		return;
	} else if(price.value ==="" || isNaN(price.value)){
		alert("가격를 확인해 주세요");
		price.select();
		return;
	}
	form.submit(); // 서브밋 해
})