const recommendPage = {
    saveApi: `http://127.0.0.1:5000/api/usuario`,
    imdbApi: 'http://127.0.0.1:5000/api/top250',
}

const {saveApi, imdbApi} = recommendPage

authLogin()

function connectSaveApi(url, userEmail) {
    fetch(url)
    .then(response => response.json())
    .then(data => {

        const index = data.map(object => object.email).indexOf(userEmail)
        const item = data[index]

        if(index === -1) {
            console.table("Usuario não encontrado... Redirecionando ao login => :)")
            return window.location.href = '/'
        } else {
            const userEmailApi = item.email
            const userNameApi = item.nome
    
            authData(userEmailApi, userNameApi)
        }

    })
    .catch(err => console.error(err))
}

function authData(userEmailApi, userNameApi) {
    const getLocalStorageName = localStorage.getItem('name')
    const getLocalStorageEmail = localStorage.getItem('email')

    if(!getLocalStorageEmail || !getLocalStorageName) {
        console.log("Dados incompletos...")
        return window.location.href = '/'
    } else if(getLocalStorageEmail != userEmailApi || getLocalStorageName != userNameApi) {
        removeLocalStorageData()
        console.log("Dados não conferem com ao da API...");
        return window.location.href = '/'
    } else {
        console.log('Usuario autenticado');
    }
}

function removeLocalStorageData () {
    localStorage.removeItem('name')
    localStorage.removeItem('email')
}

function authLogin() {
    const email = localStorage.getItem('email')
    connectSaveApi(saveApi, email)
    connectImdbApi(imdbApi)
}

function connectImdbApi(url) {
    fetch(url)
    .then(response => response.json())
    .then(data => {

        data.map((item) => {
            const title = item.title
            const year = item.year
            const poster = item.image
            const email = localStorage.getItem('email')

            makeHtml(title, year, poster, email)
        })
    })
    .catch(err => console.error(err))
}

function makeHtml(title, year, poster, email) {
    const movie = `<div class="movie-wrapper"><form action="" method="post"><div class="userContent-wrapper"><div class="hidden-content"><input type="hidden" name="email" value="${email}"></div><div class="image-wrapper"><img src="${poster}"> <input type="hidden" name="poster" value="${poster}"></div></div><div class="content-wrapper"><div class="input-wrapper"><h1>${title}</h1><input type="hidden" name="title" value="${title}"></div><div class="input-wrapper"><h2>${year}</h2><input type="hidden" name="year" value="${year}"></div><div class="input-wrapper"><p>Nota:</p><input class="rating" max="5" step="1" type="range" value="0" name="" oninput='this.style.setProperty("--value",this.value)'></div><button type="submit"><svg width="45" height="53" viewBox="0 0 59 53" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M29.3333 52.0002C30.75 52.0002 57.6666 37.8341 57.6666 18.0013C57.6666 8.08495 50.5833 1.12481 42.0833 1.00182C37.8333 0.940329 33.5833 2.41684 29.3333 8.08351C25.0833 2.41684 20.7598 1.00182 16.5833 1.00182C8.08333 1.00182 1 8.08496 1 18.0013C1 37.8341 27.9167 52.0002 29.3333 52.0002Z" fill="#E63946" stroke="#E63946" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/></svg></button></div></form></div>`
    document.querySelector('.movies-container').innerHTML += movie
}