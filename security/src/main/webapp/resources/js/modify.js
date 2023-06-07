///  첨부파일 목록 가져오기

fetch("/board/getAttachList?bno=" + bno)
  .then((response) => {
    if (!response.ok) {
      throw new Error("첨부물 없음");
    }
    return response.json();
  })
  .then((data) => {
    console.log(data);
    showUploadeFile(data);
  })
  .catch((error) => console.log(error));

//수정 버튼 클릭 시 폼 submit가 일어나면 첨부파일 목록 수집하기
const modifyForm = document.querySelector("#modifyForm");

modifyForm.addEventListener("submit", (e) => {
  e.preventDefault();
  const lis = document.querySelectorAll(".uploadResult ul li");

  str = "";
  // lis forEach ==> li 태그 안에 data- 속성값 수집
  lis.forEach((ele, idx) => {
    str += "<input type='hidden' name='attachList[" + idx + "].uuid' value='" + ele.dataset.uuid + "' />";
    str += "<input type='hidden' name='attachList[" + idx + "].uploadPath' value='" + ele.dataset.path + "' />";
    str += "<input type='hidden' name='attachList[" + idx + "].fileName' value='" + ele.dataset.filename + "' />";
    str += "<input type='hidden' name='attachList[" + idx + "].fileType' value='" + ele.dataset.type + "' />";
  });
  modifyForm.insertAdjacentHTML("beforeend", str);
  // console.log("수정폼");
  //console.log(modifyForm);

  modifyForm.submit();
});

//삭제버튼 클릭 시 operForm 보내기
// /board/read 전송

const form = document.querySelector("#operForm");

document.querySelector(".btn-danger").addEventListener("click", () => {
  form.action = "/board/remove";
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
