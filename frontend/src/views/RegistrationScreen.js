import React, { useState, useEffect } from 'react'; 
import logo from '../img/313924544_1276320506540723_2182907989589946510_n 1.svg';
import loremaster from '../img/Loremaster.svg'
import '../style/App.css';
import axios from 'axios';

const RegistrationScreen = () => {
  
    const [newUser, setNewUser] = useState({
        username: '',
        login: '',
        password: ''
    })

    const handleInput = (event) =>{
        setNewUser({...newUser, [event.target.name]: event.target.value})
    }

    function handleSubmit(event){
      event.preventDefault();

      const options ={
        method: 'POST',
        url: 'http://localhost:8888/users/add',
        headers: {'Content-Type': 'application/json'},
        data:{
          username: newUser.username,
          login: newUser.login,
          password: newUser.password
        }
      } 

      console.log(newUser);
      axios.request(options)
      .then(response => console.log(response))
      .catch(err => console.log(err));
    }

    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <img src={loremaster} alt='loremaster'/>
          <div className="LoginContainer">
            <form className="login-elements" onSubmit={handleSubmit}>
              <p className="text">Username</p>
              <input className="username" name="username" type="text" placeholder="janek" onChange={handleInput}/>
              <p className="text">Login</p>
              <input className="login" name="login" type="text" placeholder="jan.kowalski@gmail.com" onChange={handleInput}/>
              <p className="text">Password</p>
              <input className="password" name="password" type="password" placeholder="*********" onChange={handleInput}/>
              <button className='button' type="submit">Register</button>
            </form>
          </div>
        </header>
      </div>
    );
}

export default RegistrationScreen;
