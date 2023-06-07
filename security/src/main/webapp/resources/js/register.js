/**
 *
 *
 */
//삭제버튼 클릭 시 operForm 보내기
// /board/read 전송

const form = document.querySelector("#registerForm");

form.addEventListener("submit", (e) => {
  e.preventDefault();

  if (!form.checkValidity()) {
    form.classList.add("was-validated");
  } else {
    // 첨부파일 정보를 hidden 으로 달아서 폼 전송하기
    // 게시글 내용이 작성이 다 되도 폼은 못가게 막기
    // 첨부파일 정보 수집하기

    const lis = document.querySelectorAll(".uploadResult ul li");
    console.log(lis);
    str = "";
    // lis forEach ==> li 태그 안에 data- 속성값 수집
    lis.forEach((ele, idx) => {
      // // li 하나당
      // <input type='hidden' name='attachList[0].uuid' vaule=''/>
      // <input type='hidden' name='attachList[0].uploadPath' vaule=''/>
      // <input type='hidden' name='attachList[0].fileName' vaule=''/>
      // <input type='hidden' name='attachList[0].fileType' vaule=''/>

      str += "<input type='hidden' name='attachList[" + idx + "].uuid' value='" + ele.dataset.uuid + "' />";
      str += "<input type='hidden' name='attachList[" + idx + "].uploadPath' value='" + ele.dataset.path + "' />";
      str += "<input type='hidden' name='attachList[" + idx + "].fileName' value='" + ele.dataset.filename + "' />";
      str += "<input type='hidden' name='attachList[" + idx + "].fileType' value='" + ele.dataset.type + "' />";
    });
    form.insertAdjacentHTML("beforeend", str);
    console.log(form);

    form.submit();
  }
});
