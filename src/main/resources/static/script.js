const API_URL = "/api"; //frontend is now being served by the same Spring Boot application, we can use the relative path.

async function loadTrendingMovies() {

    const response = await fetch(`${API_URL}/movies/trending`); //"Spring Boot, give me the trending movies."

    const data = await response.json();

    displayMovies(data.results, "trendingMovies"); //"Take those movies and put them inside the HTML element called trendingMovies."
}

async function loadRecommendedMovies() {

    const response = await fetch(`${API_URL}/movies/recommendations`);

    const data = await response.json();

    displayMovies(data, "recommendedMovies");
}


function displayMovies(movies, containerId) {

    const container = document.getElementById(containerId);

    container.innerHTML = "";

    movies.forEach(movie => {

        const card = document.createElement("div");

        card.classList.add("movie-card");

        card.innerHTML = `
            <img
                src="https://image.tmdb.org/t/p/w500${movie.poster_path}"
                alt="${movie.title}"
            >

            <div class="movie-info">
                <h3>${movie.title}</h3>
                <p>⭐ ${movie.vote_average.toFixed(1)}</p>
            </div>

            <button class="favorite-button">
                ♡
            </button>
        `;

        container.appendChild(card);
    });
}


loadTrendingMovies();
loadRecommendedMovies();