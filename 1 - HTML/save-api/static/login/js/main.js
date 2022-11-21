const loginPage = {
    loginBtn: document.querySelector('.btnLogin'),
    loginInput: document.querySelector('#userEmail'),
    saveApi: `http://127.0.0.1:5000/api/usuario`
}

const { loginBtn, loginInput, saveApi } = loginPage

loginBtn.addEventListener('click', (event) => {
    event.preventDefault()

    let userInputEmail = loginInput.value

    connectSaveApi(saveApi, userInputEmail)
})

authLogin()

function connectSaveApi(url, userEmail) {
    fetch(url)
    .then(response => response.json())
    .then(data => {

        const index = data.map(object => object.email).indexOf(userEmail)
        const item = data[index]

        if(index === -1) {
            removeLocalStorageItem()
            AlertError.open()
        } else {
            const userEmailApi = item.email
            const userNameApi = item.nome

            setLocalStorageItem(userNameApi, userEmailApi)
    
            authData(userEmailApi, userNameApi)
        }

    })
    .catch(err => console.error(err))
}

function authData(userEmailApi, userNameApi) {
    const getLocalStorageName = localStorage.getItem('name')
    const getLocalStorageEmail = localStorage.getItem('email')

    if(getLocalStorageEmail === userEmailApi && getLocalStorageName === userNameApi) {
        return window.location.href = '/home'
    }
}

function setLocalStorageItem(name, email) {
    localStorage.setItem('name', name)
    localStorage.setItem('email', email)
}

function removeLocalStorageItem(){
    localStorage.removeItem('name')
    localStorage.removeItem('email')
}

function authLogin() {
    const email = localStorage.getItem('email')

    if(email != null) {
        connectSaveApi(saveApi, email)
    }

}

const AlertError = {
    element: document.querySelector('.alert-error'),
    open() {
        AlertError.element.classList.add('open')
    },
    close() {
        AlertError.element.classList.remove('open')
    }
}