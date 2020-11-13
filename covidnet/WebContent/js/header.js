class Header extends HTMLElement {
  constructor() {
    super();
    let rightButton = '';
    if(localStorage.getItem('CovidnetUser')) {
    	rightButton = '<a href="login" onClick={localStorage.removeItem(\'CovidnetUser\')}>Sair</a>';
    } else {
    	rightButton = '<a href="login">Entrar</a>';
    }
    this.innerHTML = `<header>
    <div id="header">
        <a href="home-page">COVIDNET</a>
        `+rightButton+`
      </div>
    	</header >`;
  }
}

window.customElements.define("site-header", Header);
