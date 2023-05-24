/**
 *
 *
 */

checkModal(result);

history.replaceState({}, null, null);

function checkModal(result) {
  if (result === "" || history.state) return;

  if (parseInt(result) > 0) {
    document.querySelector(".modal-body").innerHTML =
      "게시글" + result + "번이 등록되었습니다.";
  } else {
    document.querySelector(".modal-body").innerHTML = result;
  }
  $("#registerModal").modal("show");
}

/*
  하단의 페이지 번호 클릭 시 a 태그 기본 기능 중지
  a 태그 href 값 가져온 후 operForm 페이지 요소의 value값으로 변경
  actionForm 전송
*/
const pagination = document.querySelector(".pagination");
const operForm = document.querySelector("#operForm");

pagination.addEventListener("click", (e) => {
  e.preventDefault();
  // href 값 가져오기
  let href = e.target.getAttribute("href");

  //operForm 안의 page value 수정
  operForm.firstElementChild.value = href;
  // console.log(operForm);
  operForm.submit();
});

// 상단의 amount 값 수정 시 operForm 페이지 요소의 amount값으로 세팅
//  actionForm 전송

const amount = document.querySelector("#amount");
amount.addEventListener("change", (e) => {
  const val = e.target.value;

  const amount = document.querySelector("#operForm input:nth-child(2)");
  amount.value = val;

  operForm.submit();
});

// 제목 클릭 시 a 태그 기능 중지
// operForm 의 action은 /board/read 변경
// operForm의 bno태그를 추가해서 operForm 전송

const moves = document.querySelectorAll(".move");

moves.forEach((move) => {
  move.addEventListener("click", (e) => {
    e.preventDefault();

    const href = e.target.getAttribute("href");
    const bno = "<input type='hidden' name='bno' value='" + href + "'>";

    operForm.insertAdjacentHTML("beforeend", bno);
    operForm.action = "/board/read";
    operForm.submit();
  });
});

// 뒤로가기 이벤트 감지? ==> 새로고침 하기
window.onpageshow = function (event) {
  if (event.persisted) {
    // persisted == true : webpage 가 로딩될 때 캐시에서 읽어왔음
    location.reload();
  }
};

// 검색 클릭 시
// type, keyword 입력 여부 확인
// 입력이 안된 경우 : 경고창 보여주기
// 입력이 다 된 경우 : form submit
// 주소 list

const searchForm = document.querySelector("#searchForm");

searchForm.addEventListener("submit", (e) => {
  e.preventDefault;

  const type = document.querySelector("#type");
  const keyword = document.querySelector("#keyword");

  if (type === "") {
    alert("검색 조건을 입력해 주세요");
    type.focus();
    return;
  } else if (keyword === "") {
    alert("검색어를 입력해 주세요");
    keyword.focus();
    return;
  }

  searchForm.submit();
});
