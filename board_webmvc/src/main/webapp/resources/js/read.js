/**
 *
 *
 */
//수정버튼 클릭 시 operForm 보내기
// /board/read 전송

const form = document.querySelector("#operForm");

document.querySelector(".btn-info").addEventListener("click", () => {
  form.action = "/board/modify";
  form.submit();
});

// 목록 버튼 클릭 시 operForm 보내기
// /board/list 전송
document.querySelector(".btn-secondary").addEventListener("click", () => {
  // bno 제거
  form.firstElementChild.remove();
  form.action = "/board/list";
  form.submit();
});
