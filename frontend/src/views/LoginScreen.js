import React, { useState } from 'react'; 
import logo from '../img/313924544_1276320506540723_2182907989589946510_n 1.svg';
import loremaster from '../img/Loremaster.svg'
import '../style/App.css';
import { Link } from 'react-router-dom';
import axios from 'axios';


const LoginScreen = (props) => {
  
  const [messages, setMessages] = useState('');
  const [login, setLogin] = useState('');
  const [password, setPassword] = useState('');

  async function handleLogin(e){
    e.preventDefault();
    const options = {
      method: 'POST',
      url: 'http://localhost:8888/users/get',
      headers: {'Content-Type': 'application/json'},
      data: {
        login: login,
        password: password
      }
    };

    axios.request(options)
    .then(function (response){
      console.log(response.data.token);
      sessionStorage.setItem('token', response.data.token);
      window.location.href = '/home';
    })
    .catch(function(error){
      console.log("error:" + error)
    })
  }  

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <img src={loremaster} alt='loremaster'/>
        <div className="LoginContainer" style={{padding: 5}}>
        {messages}
          <form className="login-elements">
            <p className="text">Login</p>
            <input 
                className="login" 
                name="login" 
                type="text" 
                placeholder="jan.kowalski@gmail.com" 
                value={login} 
                onChange={e => setLogin(e.target.value)}
            />
            <p className="text">Password</p>
            <input 
                className="password" 
                name="password" 
                type="password" 
                placeholder="*********" 
                value={password}
                onChange={e => setPassword(e.target.value)}
            />
            <button onClick={handleLogin}>Login</button>
          </form>
        </div>
        <a href='/register'>Register</a>
      </header>
    </div>
  );
}

export default LoginScreen;
