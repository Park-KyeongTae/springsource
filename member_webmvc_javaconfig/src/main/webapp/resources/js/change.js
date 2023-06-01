/**
 *  기존비밀번호.새비밀번호,새비빌번호확인 내용 비어 있지 않도록 확인
 *  새비밀번호와 새비밀번호확인 동일한가?
 */
const form = document.querySelector("form")
form.addEventListener("submit", (e) => {
	e.preventDefault();
	const currentPwd = document.querySelector("#floatingPassword1");
	const newPwd = document.querySelector("#floatingPassword2");
	const confirmPwd = document.querySelector("#floatingPassword3");
	if (currentPwd.value === "") {
		alert("비밀번호 확인");
		currentPwd.select();
		return;
	} else if (newPwd.value === "") {
		alert("새 비밀번호 확인");
		newPwd.select();
		return;
	} else if (confirmPwd.value === "") {
		alert("새 비밀번호 확인");
		confirmPwd.select();
		return;
	}

	if(newPwd.value !== confirmPwd.value){
	alert("새 비밀번호가 서로 맞지 않습니다. ");
		confirmPwd.select();
		return;
	}

	form.submit();
})