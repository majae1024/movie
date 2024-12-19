/**
 * 
 */

// 로그인 시도시 input 입력 됫는지 확인
function loginCheck(){
  if(document.frm.username.value == ''){
    alert("아이디를 입력하세요.");
    doucument.frm.username.focus();
    return false;
  }
  if(document.frm.password.value == ''){
    alert("비밀번호를 입력하세요.");
    document.frm.password.focus();
    return false;
  }

  return true;
}

// 회원가입 버튼 클릭시 필수부분 채움 확인 및 약관 동의 체크
function registerCheck(){
  if(document.frm.user_id.value == "") {
    alert("아이디를 입력해주세요");
    document.frm.user_id.focus();
    return false;
  }
  
  if(document.frm.reid.value == ""){
    alert("중복확인을 해주세요");
    document.frm.user_id.focus();
    return false;
  }
  
  if(document.frm.user_pw.value == ""){
    alert("비밀번호를 입력하세요");
    document.frm.user_pw.focus();
    return false;
  }
  
  if(document.frm.password_check.value !== document.frm.user_pw.value){
    alert("비밀번호가 일치하지 않습니다.");
    document.frm.password_check.focus();
    return false;
  }
  
   if (!/^\d{6}$/.test(document.frm.birth.value)) {
     alert("올바른 6자리 주민번호를 입력하세요. ex(980101)");
     return false;
  }else if(isNaN(document.frm.birth.value)){
      alert("숫자를 입력하세요")
      document.frm.birth.focus();
      return false;
  }else if(document.frm.birth.value.length !== 6){
     alert("6자리만 입력해주세요 (ex:950505)")
     document.frm.birth.focus();
     return false;
  }
  
  if(!document.frm.iAgree.checked){
    alert("약관에 동의해주세요");
    document.frm.iAgree.focus();
    return false;
  }

  return true;
}


function idCheck(){
  if(document.frm.id.value == ''){
    alert("아이디를 입력해주세요");
    document.frm.id.focus();
    return;
  }

  var url = "/user/idCheck?id=" + document.frm.user_id.value;
  window.open(url, "_blank_1", "width=600px, height=400px, scrollbars=no, toolbar=no, menubar=no");
}

function idok(){
  opener.frm.user_id.value = document.frm.id.value;
  opener.frm.reid.value = document.frm.id.value;
  self.close();
}



