import React, { useState, useEffect } from 'react'; 
import logo from '../img/313924544_1276320506540723_2182907989589946510_n 1.svg';
import loremaster from '../img/Loremaster.svg'
import '../style/App.css';


function LoginScreen(props) {
  
  const [messages, setMessages] = useState('');

  useEffect(() => {
    fetch('http://localhost:8080/api/messages')
      .then(response => response.text())
      .then(data => {
        console.log(data);
        setMessages([data])});
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <img src={loremaster} />
        <dif className="LoginContainer" style={{padding: 5}}>
        {messages}
          <form class="login-elements" action="login" method="GET">
            <p class="text">Login</p>
            <input class="login" name="login" type="text" placeholder="jan.kowalski@gmail.com" />
            <p class="text">Password</p>
            <input class="password" name="password" type="password" placeholder="*********" />
            <button type="submit">Login</button>
          </form>
        </dif>
        <a href='/register'>Register</a>
      </header>
    </div>
  );
}

export default LoginScreen;
