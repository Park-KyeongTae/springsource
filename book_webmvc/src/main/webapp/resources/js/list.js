/**
 * 
 */
const form = document.querySelector("form");

form.addEventListener("submit",(e)=>{
	e.preventDefault();
	
	//검색기준 요소 가져오기
	const sel= document.querySelector("[name='criteria']");
	//검색요소 가져오기
	const keyword = document.querySelector("[name='keyword']");
	
	//select 요쇼의 선택된 value 가져오기
	console.log(sel.value);
    //const selectedVal = sel.options[sel.selectedIndex].value;
    //console.log(selectedVal);
    
    if(sel.value === "검색기준선택"){
		alert("검색기준을 확인해 주세요")
		sel.focus();
		return;
	}else if(keyword.value === ""){
		alert("검색어를 확인해 주세요")
		keyword.select();
		return
	}
	
	form.submit();
})