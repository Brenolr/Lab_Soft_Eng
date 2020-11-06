// import { addError, removeError } from './form-helpers.js';

const validateEmail = (email) => {
  return email.split("@").length > 1;
};

const validateCPF = (cpf) => {
  return !isNaN(cpf);
};

const validateEmailOrCPF = (required) => {
  const fieldName = "emailOrCpf";
  const loginElement = document.getElementById(fieldName);

  if (required && !loginElement.value) {
    addError(fieldName, "Favor inserir um e-mail ou CPF");
    return false;
  }

  if (validateCPF(loginElement.value)) {
    removeError(fieldName);
    return true;
  }
  if (validateEmail(loginElement.value)) {
    removeError(fieldName);
    return true;
  }
  addError(fieldName, "Favor inserir um e-mail ou CPF válido");
  return false;
};

const validatePassword = (required) => {
  const passwordElement = document.getElementById("password");

  if (required && !passwordElement.value) {
    addError("password", "Favor inserir uma senha");
    return false;
  }
  if (passwordElement.value.length >= 6) {
    removeError("password");
    return true;
  }
  addError("password", "A senha deve ter 6 caracteres ou mais");
  return false;
};



const validatePacientRegister = (event) => {};
