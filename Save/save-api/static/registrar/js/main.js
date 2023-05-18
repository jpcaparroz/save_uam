const registerPage = {
    form: document.querySelector('form'),
    inputName: document.querySelector('#registerUserName'),
    inputEmail: document.querySelector('#registerUserEmail'),
    saveApi: `http://127.0.0.1:5000/api/usuario`
}

const {form, inputName, inputEmail, saveApi} = registerPage

form.addEventListener('submit', (e) => {
    e.preventDefault()

    const usrEmail = inputEmail.value
    const usrName = inputName.value
    
    connectSaveApi(saveApi, usrEmail, usrName)
})

const AlertError = {
    element: document.querySelector('.alert-error'),
    open() {
        AlertError.element.classList.add('open')
    },
    close() {
        AlertError.element.classList.remove('open')
    }
}

const AlertSucess = {
    element: document.querySelector('.alert-sucess'),
    open() {
        AlertSucess.element.classList.add('open')
    },
    close() {
        AlertSucess.element.classList.remove('open')
    }
}


function atLeastOneLetterAndSpace(name) {
    return (
      /^[A-Za-z\s]*$/.test(name) &&
      /[A-Za-z]/.test(name)
    );
}

function connectSaveApi(url, email, name) {
    fetch(url)
    .then(response => response.json())
    .then(data => {
        const validateInfo = data.map(object => object.email).includes(email)

        if(validateInfo) {
            AlertError.open()
        } else {
            AlertError.close()
            validateName(name)
        }

    })
    .catch(err => console.error(err))
}

function validateName(name) {
    const validateUsrName = atLeastOneLetterAndSpace(name)
    
    if (!validateUsrName) {
        AlertError.open()
    } else {
        AlertError.close()
        AlertSucess.open()
        setInterval(() => {
            form.submit()
            setInterval(() => {
                window.location.href = '/'
            }, 10)
        }, 2000)
    }
}