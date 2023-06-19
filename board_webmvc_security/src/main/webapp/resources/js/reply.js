  /**
 *  댓글 처리 자바스크립트 모듈
 */

let replyService = (function () {
  //reply : 댓글 작성 자바스크립트 객체
  //callback : function
  function add(reply, callback) {
    console.log("add 함수");

    fetch("/replies/new", {
      // 컨트롤러 갔다가 리턴값을 첫번쨰 then으로 간다
      method: "post",
      headers: {
        "content-type": "application/json",
        "X-CSRF-TOKEN": csrfToken,
      },
      body: JSON.stringify(reply),
    })
      .then((response) => {
        // 결과가 도착하게 되면 자동 호출(비동기 호출)
        if (!response.ok) {
          throw new Error("입력 오류");
        }
        return response.text(); //success
      })
      .then((data) => {
        // 처음 then() 의 return을 하면 호출됨
        // 넘겨받은 함수를 호출하게 됨
        if (callback) {
          callback(data);
        }
      })
      .catch((error) => console.log(error));
  } // add 종료

  function getList(param, callback) {
    let bno = param.bno;
    let page = param.page;
    fetch("/replies/pages/" + bno + "/" + page)
      .then((response) => {
        if (!response.ok) {
          throw new Error("리스트 없음");
        }
        return response.json();
      })
      .then((data) => {
        console.log("리스트와 개수");
        console.log(data);

        // data 가 도착해서 함수가 호출되면 넘겨받은
        // 함수 호출
        if (callback) {
          callback(data.replyCnt, data.list);
        }
      })
      .catch((error) => console.log(error));
  } // getList 종료

  function displayTime(timeVal) {
    const today = new Date(); //오늘 날짜

    // 오늘날짜 - 댓글작성날짜
    let gap = today.getTime() - timeVal;

    // 댓글작성날짜 Date 객체 생성
    let dateObj = new Date(timeVal);

    let str = "";

    // 작성날짜를 보여줄 때 24시간 안에 작성했느냐? 넘었느냐?
    // 24시간 안이라면 시분초, 넘었다면 년월일
    if (gap < 1000 * 60 * 60 * 40) {
      // 하루를 밀리세컨즈로 바꾸는 코드
      let hh = dateObj.getHours();
      let mi = dateObj.getMinutes();
      let ss = dateObj.getSeconds();
      // 시분초 한자리를 두자리로
      return [(hh > 9 ? "" : "0") + hh, ":", (mi > 9 ? "" : "0") + mi, ":", (ss > 9 ? "" : "0") + ss].join("");
    } else {
      const yy = dateObj.getFullYear();
      const mm = dateObj.getMonth() + 1; // 월은 0부터 시작
      const dd = dateObj.getDate();

      // 년월일 한자리를 두자리로
      return [yy, "/", (mm > 9 ? "" : "0") + mm, "/", (dd > 9 ? "" : "0") + dd].join("");
    }
  }

  function get(rno, callback) {
    fetch("/replies/" + rno)
      .then((response) => {
        if (!response.ok) {
          throw new Error("가져올 댓글 없음");
        }
        return response.json();
      })
      .then((data) => {
        if (callback) {
          callback(data);
        }
      })
      .catch((error) => console.log(error));
  }

  // 댓글 수정
  function update(reply, callback) {
    fetch("/replies/" + reply.rno, {
      method: "put",
      headers: {
        "X-CSRF-TOKEN": csrfToken,
        "content-type": "application/json",
      },
      body: JSON.stringify(reply),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("수정 실패");
        }
        return response.text();
      })
      .then((data) => {
        if (callback) {
          callback(data);
        }
      })
      .catch((error) => console.log(error));
  }

  function remove(rno, replyer, callback) {
    const reply = { replyer: replyer };

    fetch("/replies/" + rno, {
      method: "delete",
      headers: {
        "X-CSRF-TOKEN": csrfToken,
        "content-type": "application/json",
      },
      body: JSON.stringify(reply),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("삭제 실패");
        }
        return response.text();
      })
      .then((data) => {
        if (callback) {
          callback(data);
        }
      })
      .catch((error) => console.log(error));
  }

  return {
    add: add,
    getList: getList,
    displayTime: displayTime,
    get: get,
    update: update,
    remove: remove,
  };
})();
