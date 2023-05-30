const profilePage = {
    usrName: document.querySelector('.username'),
    btnAction: document.querySelector('.profileAction'),
    movieContainer: document.querySelector('.movies-container'),
    starRating: document.querySelector('.rating'),
    saveApiUsuario: `http://127.0.0.1:5000/api/usuario`,
    saveApiProfiles: `http://127.0.0.1:5000/api/filmeusuario`,
}

const {usrName, movieContainer, btnAction, starRating, saveApiUsuario, saveApiProfiles} = profilePage

authLogin()

btnAction.addEventListener('click', () => {
    profileAnimations()
})

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
    const name = localStorage.getItem('name')
    connectSaveApi(saveApiUsuario, email)
    setUserName(name)
    connectSaveApiProfile(saveApiProfiles)
}

function setUserName(name) {
    return usrName.innerHTML = name
}

function profileAnimations() {
    btnAction.classList.add('hide')
    movieContainer.classList.remove('hide')
}

function connectSaveApiProfile(url) {
    fetch(url)
    .then(response => response.json())
    .then(data => {
        data.map((item) => {
            const emailAtual = localStorage.getItem('email')
            const email = item.emailUsuario

            const title = item.nomeFilme
            const year = item.anoFilme
            const poster = item.posterFilme
            const rating = Number(item.notaFilme)

            if(emailAtual === email) {
                createMoviesList(title, year, poster, email, rating)
            }
        })
    })
    .catch(err => console.error(err))
}

function createMoviesList(title, year, poster, email, rating) {
    let movie = `<div class="movie-wrapper"><form action="" method="get"><div class="userContent-wrapper"><div class="hidden-content"><input type="hidden" name="emailUsuario" value="${email}"></div><div class="image-wrapper"><img src="${poster}"> <input type="hidden" name="posterFilme" value="${poster}"></div></div><div class="content-wrapper"><div class="input-wrapper"><h1>${title}</h1><input type="hidden" name="nomeFilme" value="${title}"></div><div class="input-wrapper"><h2>${year}</h2><input type="hidden" name="anoFilme" value="${year}"></div><div class="input-wrapper"><p>Nota:</p><input class="rating" max="5" readonly="readonly" disabled="disabled" step="1" style="--fill:gold;--value:${rating};" type="range" value="${rating}"></div></div></form></div>`
    document.querySelector('.movies-container').innerHTML += movie
}