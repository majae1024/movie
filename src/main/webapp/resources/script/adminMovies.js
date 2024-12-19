const API_KEY = "9110d9849920494c2b025282f04f3acc";
const BASE_URL = "https://api.themoviedb.org/3";

// 1. 영화 목록 가져오기
async function fetchMovies() {
    try {
        const response = await axios.get(`${BASE_URL}/movie/now_playing`, {
            params: {
                api_key: API_KEY,
                language: "ko-KR",
                region: "KR"
            }
        });

        const nowPlayingMovies = response.data.results;

        // 영화 세부 정보 가져오기
        const movieDetails = await Promise.all(
            nowPlayingMovies.map(async (movie) => {
                try {
                    const detailsResponse = await axios.get(`${BASE_URL}/movie/${movie.id}`, {
                        params: {
                            api_key: API_KEY,
                            language: 'ko-KR',
                            append_to_response: 'release_dates'
                        }
                    });

                    // release_dates 배열에서 한국(KR) 데이터를 찾음
                    const releaseDates = detailsResponse.data.release_dates.results;
                    const krReleaseInfo = releaseDates.find((release) => release.iso_3166_1 === 'KR');
                    const certification = krReleaseInfo ? krReleaseInfo.release_dates[0]?.certification : '정보 없음';

                    return {
                        id: detailsResponse.data.id, // 영화 고유 ID
                        title: detailsResponse.data.title, // 영화 제목
                        certification, // 한국 기준 연령 제한 등급
                    };
                } catch (error) {
                    console.error(`영화 세부 정보를 가져오는 중 오류 발생 (ID: ${movie.id}):`, error);
                    return null; // 실패한 경우 null 반환
                }
            })
        );
		
        // 유효한 영화만 필터링
        const validMovies = movieDetails.filter(movie => movie !== null);
		console.log(validMovies);
        // 영화 목록 표시
        displayMovies(validMovies);
    } catch (error) {
        console.error("영화 목록을 가져오는 중 오류 발생:", error);
    }
}

// 2. 영화 목록 표시
function displayMovies(movies) {
    const movieList = document.getElementById("movie-list");
    movieList.innerHTML = movies.map(movie => `
        <tr>
            <th>${movie.title}</th>
            <td style="text-align: center;">${movie.id}</td>
            <td style="text-align: center;">${movie.certification}</td>
            <td style="text-align: center;"><button onclick="fetchMovieDetails(${movie.id})">선택하기</button></td>
        </tr>
    `).join("");
}