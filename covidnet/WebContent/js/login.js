const validateLogin = (event) => {
  event.preventDefault();

  addChangeListeners({
    emailOrCpf: validateEmailOrCPF,
    password: validatePassword,
  });

  const validEmail = validateEmailOrCPF(true);
  const validPassword = validatePassword(true);

  const login = document.getElementById('emailOrCpf').value;
  if(validEmail && validPassword) {
	 localStorage.setItem('user', login);
  }
  return false;
};
