import { AlertError } from "./alert-error.js";
import { atLeastOneLetterAndSpace } from "./utils.js";

const form = document.querySelector('form')
const inputName = document.querySelector('#registerUserName')

form.onsubmit = function(event){
    
    const userName = inputName.value
    const nameValidate = atLeastOneLetterAndSpace(userName)

    if(!nameValidate) {
        AlertError.open()
        event.preventDefault()
        return;
    }

    AlertError.close()
}