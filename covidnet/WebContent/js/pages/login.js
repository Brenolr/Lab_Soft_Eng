const address = window.location.href.split('/');
const message = address[4].split('=') ? address[4].split('=')[1] : undefined;
if(message){

	console.log(message);
	const error = document.getElementById('backend_errorMessage');
	error.textContent = message.replace(/%20/gi," ");
	error.style.display = 'block';
	
}

const validateLogin = (event) => {
  
  addChangeListeners({
    emailOrCpf: validateEmailOrCPF,
    password: validatePassword,
  });

  const validEmail = validateEmailOrCPF(true);
  const validPassword = validatePassword(true);

  const login = document.getElementById('emailOrCpf').value;
  if(validEmail && validPassword) {
	 
	 return true;
  }
  return false;
};
