const homePage = {
    btnLogout: document.querySelector('.btnLogout'),
    homeUserName: document.querySelector('.usrName'),
    saveApi: `http://127.0.0.1:5000/api/usuario`,
}

const {btnLogout, homeUserName, saveApi} = homePage

authLogin()

homeUserName.innerHTML = `${localStorage.getItem('name')}`

btnLogout.addEventListener('click', (e) => {
    e.preventDefault()
    removeLocalStorageData()
    return window.location.href = '/'
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
        console.log("Usuario Autenticado");
    }
}

function removeLocalStorageData () {
    localStorage.removeItem('name')
    localStorage.removeItem('email')
}

function authLogin() {
    const email = localStorage.getItem('email')
    connectSaveApi(saveApi, email)
}