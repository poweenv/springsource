/**
 *
 *
 */
//삭제버튼 클릭 시 operForm 보내기
// /board/read 전송

const form = document.querySelector("#registerForm");

form.addEventListener("submit", (e) => {
  if (!form.checkValidity()) {
    e.preventDefault();
    e.stopPropagation();
  }
  form.classList.add("was-validated");
});
