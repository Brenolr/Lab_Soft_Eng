const address = window.location.href.split('/');
const message = address[4].split('=') ? address[4].split('=')[1] : undefined;
if(message){
	const error = document.getElementById('backend_errorMessage');
	error.textContent = message.replace(/%20/gi," ");
	error.style.display = 'block';
}