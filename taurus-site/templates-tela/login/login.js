function checkPass(x) {
    var eyeSlash = document.getElementById('checkPass');
    var eye = document.getElementById('checkPass2')
    var inpt = document.getElementById('senha_login');

    if(x == 1){
        eyeSlash.style.display = 'none';
        eye.style.display = 'block';
        inpt.type = 'text';
    }else{
        eye.style.display = 'none';
        eyeSlash.style.display = 'block';
        inpt.type = 'password';
    }
}

function test(a) {
    var login = document.getElementById('login-box');
    var signUp = document.getElementById('signUp-box');
    if (a == 1) {
        if(login.classList == ''){
            login.classList.add('form_hide');
        }else{
            login.classList.replace(`${login.classList}`,'form_hide');
        }
        setTimeout(() => {
            login.style.display = 'none';
            if(signUp.classList == ''){
                signUp.classList.add('form_ap');
            }else{
                signUp.classList.replace(`${signUp.classList}`, 'form_ap');
            }
            signUp.style.display = 'block';
        }, 500);
    }else{
        signUp.classList.replace('form_ap', 'form_hide');
        setTimeout(() => {
            signUp.style.display = 'none';
            login.classList.replace('form_hide', 'form_ap');
            login.style.display = 'block';
        }, 500);
    }
}