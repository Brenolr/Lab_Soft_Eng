const ERROR_INPUT_CLASS = "error_input";
const ERROR_LABEL_CLASS = "error_color";

const getErrorMessageId = (field) => {
  return field + "_errorMessage";
};

const removeError = (field) => {
  // Remove error class to input field
  const fieldElement = document.getElementById(field);
  fieldElement.classList.remove(ERROR_INPUT_CLASS);

  // Empty error message and make it invisible
  const errorMessage = document.getElementById(getErrorMessageId(field));
  errorMessage.textContent = "";
  errorMessage.style.display = "none";

  // Remove error class from field label
  const labelElement = document.querySelector('[for='+field+']');
  labelElement.classList.remove(ERROR_LABEL_CLASS);
};
const addError = (field, message) => {
  // Add error class to input field
  const fieldElement = document.getElementById(field);
  fieldElement.classList.add(ERROR_INPUT_CLASS);

  // Set error message and make it visible
  const errorMessage = document.getElementById(getErrorMessageId(field));
  errorMessage.textContent = message;
  errorMessage.style.display = "block";

  // Add error class to field label
  const labelElement = document.querySelector('[for='+field+']');
  labelElement.classList.add(ERROR_LABEL_CLASS);
};

const addChangeListeners = (obj) => {
  const entries = Object.entries(obj);
  entries.forEach(([field, listener]) => {
    document.getElementById(field).addEventListener("change", listener);
  });
};