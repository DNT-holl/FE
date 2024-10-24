const btn_aut = document.getElementById('btn_aut');
const modal = document.getElementById('modal');
const login = document.getElementById('login');
const register = document.getElementById('register');
const autform_login = document.getElementById('autform_login');
const autform_register = document.getElementById('autform_register');
const bt_login_back = document.getElementById('bt_login_back');
const bt_register_back = document.getElementById('bt_register_back');

btn_aut.addEventListener('click', () => {
  modal.style.display = 'block';
});

login.addEventListener('click', () => {
  autform_register.style.display = 'block';
  autform_login.style.display='none';
});

register.addEventListener('click', () => {
  autform_login.style.display = 'block';
  autform_register.style.display = 'none';
})

bt_login_back.addEventListener('click', () => {
  modal.style.display = 'none';
})

bt_register_back.addEventListener('click', () => {
  modal.style.display = 'none';
})
