class Footer extends HTMLElement {
  constructor() {
    super();
    this.innerHTML = `<footer>
      <div class="main-content">
        <div class="left box">
          <h2>Sobre</h2>
          <div class="content">
            <p>Texto sobre este website</p>
          </div>
        </div>
        <div class="center box">
          <h2>Grupo</h2>
          <div class="content">
            <div>
              <span class="fas fa-user"></span>
              <span class="text">Breno Loscher Rocha</span>
            </div>
            <div class="middle">
              <span class="fas fa-user"> </span
              ><span class="text">Iago Soriano Roque Monteiro</span>
            </div>
            <div>
              <span class="fas fa-user"></span>
              <span class="text">Jean Lee Bernardes</span>
            </div>
          </div>
        </div>
        <div class="right box">
          <h2>Escola Polit&eacute;cnica da USP</h2>
          <div class="content">
            <div>
              <span class="fas fa-map-marker-alt"></span>
              <span class="text">Endereço</span>
            </div>
            <div class="middle">
              <span class="fas fa-phone-alt"></span>
              <span class="text">Telefone</span>
            </div>
            <div>
              <span class="fas fa-envelope"></span>
              <span class="text">email</span>
            </div>
          </div>
        </div>
      </div >
      <div class="bottom">
        <center>
          <span class="credit">PCS XXXX - 3&deg; Quadrimestre de 2020</span>
        </center>
      </div>
    </footer >`;
  }
}

window.customElements.define("site-footer", Footer);
