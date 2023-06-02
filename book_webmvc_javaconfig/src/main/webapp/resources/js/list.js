/**
 * 
 */	 
	 const form = document.querySelector("form");
	 
	 form.addEventListener("submit",(e)=>{
		 e.preventDefault();
		 //검색기준 요소 가져오기
		 const sel = document.querySelector("[name='criteria']");
		 //검색어 요소 가져오기
		 const keyword = document.querySelector("[name='keyword']");
		 
		 //const selectedVal = sel.options[sel.selectedIndex].value;
		 
		 if(sel.value ==="검색기준선택"){
			 alert("검색기준을 확인해 주세요")
			 sel.focus();
			 return;
		 }else if(keyword.value===""){
			 alert("검색어를 확인해 주세요");
			 keyword.select();
			 return;
		 }
		 form.submit();
	 })
	 