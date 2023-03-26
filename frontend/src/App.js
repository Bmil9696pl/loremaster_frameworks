import logo from './img/313924544_1276320506540723_2182907989589946510_n 1.svg';
import loremaster from './img/Loremaster.svg'
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <img src={loremaster} />
        <dif className="LoginContainer">
          <form class="login-elements" action="login" method="POST">
            <p>Login</p>
            <input class="login" name="login" type="text" placeholder="jan.kowalski@gmail.com"></input>
          </form>
        </dif>
      </header>
    </div>
  );
}

export default App;
