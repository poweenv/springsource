//
//
//
//

document.querySelector("#uploadBtn").addEventListener("click", () => {
  //formData 객체 생성
  const formData = new FormData();

  //file 요소 가져오기
  let inputFiles = document.querySelector("#uploadFile").files;
  console.log(inputFiles);

  //가져온 file 요소를 formData 추가
  for (let i = 0; i < inputFiles.length; i++) {
    formData.append("uploadFile", inputFiles[i]);
  }

  // 비동기 - formData 전송
  fetch("/uploadAjax", {
    method: "post",
    body: formData,
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("file upload fail");
      }
      return response.json();
    })
    .then((data) => {
      console.log(data);
      // 도착한 데이터(파일 업로드 정보) 에서 파일 이름을 li 태그로 만들어서 보여주기
      showUploadeFile(data);
    })
    .catch((error) => console.log(error));
});

function showUploadeFile(uploadResultArr) {
  let str = "";

  uploadResultArr.forEach((item) => {
    if (item.fileType) {
      // 썸네일 이미지 경로 생성
      let fileCallPath = encodeURIComponent(
        item.uploadPath + "\\s_" + item.uuid + "_" + item.fileName
      );

      // str += "<li><img src='/display?fileName=" + fileCallPath + "'></li>0";
      // 썸네일 이미지 클릭 => 원본 이미지 보여주기
      let oriFileCallPath = encodeURIComponent(
        item.uploadPath + "\\" + item.uuid + "_" + item.fileName
      );
      str += "<li>";
      str += "<a href='/display?fileName=" + oriFileCallPath + "' data-lightbox='image'>";
      str +=
        "<div class='text-center'><img src='/display?fileName=" + fileCallPath + "'></a></div>";
      str += "<small>" + item.fileName + "</small>";
      str += "<span data-file='" + fileCallPath + "' data-type='image'> X </span>";
      str += "</li>";
    } else {
      // txt 파일 경로 생성
      let fileCallPath = encodeURIComponent(
        item.uploadPath + "\\" + item.uuid + "_" + item.fileName
      );
      // filetype 이 true라면 image 파일이라면 썸네일 이미지 보여주기
      str += "<li>";
      str += "<a href='/download?fileName=" + fileCallPath + "'>";
      str += "<div class='text-center'><img src='/resources/img/txt-file.png'></div>";
      str += "<small>" + item.fileName + "</small></a>";
      str += "<span data-file='" + fileCallPath + "' data-type='file'> X </span>";
      str += "</li>";
      // str += "<li>" + item.fileName + "</li>";
    }
  });
  document.querySelector(".uploadResult ul").insertAdjacentHTML("beforeend", str);
}
// x 클릭 시  alert() 띄우기
document.querySelector(".uploadResult").addEventListener("click", (e) => {
  // 자식한테 이벤트가 일어나면 부모에게 전파 => 이벤트 전파
  // 실제 이벤트가 발생한 대상 : 자식 => e.target
  // 이벤트를 감지한 부모 ==>  e.currentTarget
  // alert("click");
  //1) 첨부 목록 제거
  // 2) 서버 폴더에 저장된 파일 제거
  //  이미지 : 원본, 썸네일 이미지 제거
  //   text: 파일 제거

  // data- 에 있는 값 가져오기
  // data-file, data-type

  // data- 에 있는 값 가져올 때 dataset
  const targetFile = e.target.dataset.file;
  const type = e.target.dataset.type;
  console.log(targetFile, type);

  // x가 눌러진 li 가져오기
  const li = e.target.closest("li");

  //script 에서 <form> 태그 작성
  const formData = new FormData();
  formData.append("fileName", targetFile);
  formData.append("type", type);
  //  const data = new URLSearchParams(formData);

  fetch("/deleteFile", {
    method: "post",
    body: formData,
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("파일 제거 실패");
      }
      return response.text();
    })
    .then((data) => {
      console.log(data);
      li.remove();
    })
    .catch((error) => console.log(error));
});
