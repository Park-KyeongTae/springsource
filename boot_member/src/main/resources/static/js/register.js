/**
 *  폼 모든 요소가 비어있는지 확인
 */

/*const form = document.querySelector("form").addEventListener("submit",(e)=>{
	e.preventDefault();
	const userid = document.querySelector("#userid");
	const password = document.querySelector("#password");
	const name = document.querySelector("#name");
	const gender = document.querySelector(".gender");
	const email = document.querySelector("#email");
    
	if(userid.value === "" ){
		alert("아이디 입력해주세요");
		return; 
	}else if(password.value === "" ){
		alert("패스워드 입력해주세요");
		return;
	}else if(name.value === "" ){
		alert("이름 입력해주세요");
		return; 
	}else if(gender.value === "" ){
		alert("성별 입력해주세요");
		return; 	
	}else if(email.value === "" ){
		alert("이메일 입력해주세요");
		return;  
   }	 	 
	   form.submit();
})*/

const form = document.querySelector("form");

form.addEventListener("submit", (e) => {
	if (!form.checkValidity()) {
		e.preventDefault();
		e.stopPropagation();
	}

	form.classList.add("was-validated")
})


document.querySelector(".btn-danger").addEventListener('click', () => {
	// 사용자가 입력한 userid 가져오기
	const userid = document.querySelector('#userid').value;
	fetch("/member/dupId", {
		method: "post", body: new URLSearchParams({ userid:userid })
	})
	
		.then((response) => response.text())
		.then((result) => {console.log(result);
		if(result.trim()==="true"){
			alert("아이디를 사용할 수 있습니다.")
		}else{
			alert("아이디를 사용할 수 없습니다.")
		}
		});

})