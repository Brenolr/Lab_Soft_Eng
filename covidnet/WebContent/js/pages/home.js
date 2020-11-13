const address = window.location.href.split('/');
const userName = address[4].split('=')[0].split('?')[1];
if(userName){
	localStorage.setItem('CovidnetUser', address[4].split('=')[1]);	
}

const checkPrivateLink = (destinationAddress) => {
	if(!localStorage.getItem('CovidnetUser')){
		const loginAddress = 'http://'+address[2]+'/'+address[3]+'/login';
		document.location = loginAddress;
	} else {
		document.location = destinationAddress;
	}
};
