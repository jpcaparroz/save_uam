function doGet(url) {
    fetch(url)
    .then(response => response.json())
    .then(data => {
        const list = data.Search;

        list.map((item) => {
            console.log(item)

            const name = item.Title;
            const poster = item.Poster;
            const releaseDate = item.Year;
            const movie = `<div class="movie-wrapper"><img src="${poster}" alt=""><div class="info-wrapper"><h1 id="movieName">${name}</h1><h2 id="movieReleaseDate">${releaseDate}</h2></div></div>`
            document.querySelector('.movies-container').innerHTML += movie

            console.log(name, poster)
        })
    })
    .catch(error => {
        console.error(error)
    })
}

doGet("https://www.omdbapi.com/?apikey=8cdb9794&s=batman")