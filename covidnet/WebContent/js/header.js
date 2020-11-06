class Header extends HTMLElement {
  constructor() {
    super();
    let logoutButton = '';
    if(localStorage.getItem('user')) {
    	logoutButton = '<a href="login" onClick={localStorage.removeItem(\'user\')}>Sair</a>';
    }
    this.innerHTML = `<header>
    <div id="header">
        <a href="home-page">COVIDNET</a>
        `+logoutButton+`
      </div>
    	</header >`;
  }
}

window.customElements.define("site-header", Header);
