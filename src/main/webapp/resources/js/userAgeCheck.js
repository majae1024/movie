/**
 * 
 */
 
 $(document).ready(function () {
  const ageLimit = document.getElementById("movieRate").value.trim();//값 공백제거 타 메서드 비교위해서
  const ageLimitNum = calMovieAge(ageLimit);
  const userBirth = document.getElementById("userAge").value;
  const button = document.getElementsByClassName("reservation");
  const userAge = calUserAge(userBirth);

  console.log("ageLimit:", ageLimit);
  console.log("ageLimitNum:", ageLimitNum);
  console.log("userBirth:", userBirth);
  console.log("userAge:", userAge);

  if (ageLimitNum > userAge) {
    alert(`${ageLimitNum}세 미만이므로 관람하실 수 없습니다.`);
    history.go(-1);
  }

  function calUserAge(Num) {
    const currentDate = new Date();
    const currentYear = currentDate.getFullYear();
    const currentMonth = currentDate.getMonth() + 1; // 월은 0부터 시작
    const currentDay = currentDate.getDate();

    const birthYear = parseInt(Num.slice(0, 2));
    const birthMonth = parseInt(Num.slice(2, 4));
    const birthDay = parseInt(Num.slice(4, 6));

    const FullBirthYear = birthYear <= currentYear % 100 ? birthYear + 2000 : birthYear + 1900;

    let age = currentYear - FullBirthYear;

    if (currentMonth < birthMonth || (currentMonth === birthMonth && currentDay < birthDay)) {
      age--;
    }
    return age;
  }

  function calMovieAge(ageLimit) {
    console.log("ageLimit 함수에서 받은 인자값", ageLimit);
    if (ageLimit === "전체이용가") {
      return 0;
    } else if (ageLimit === "12세이용가") {
      return 12;
    } else if (ageLimit === "15세이용가") {
      return 15;
    } else if (ageLimit === "19세이용가") {
      return 18;
    } else {
      return null; // 유효하지 않은 값 처리
    }
  }
});
 