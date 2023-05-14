import React from 'react';
import '../style/App.css';
import loremaster from '../img/Loremaster.svg'

const HomeScreen = () => {
    return(
        <div className="App">
        <header className='App-header'>
            <img src={loremaster} />
            <div className="menu">
                <form className="menu-buttons" style={{ margin: 5, display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center', width: '80%', height: '70%' }}>
                    <a className='button' href="regionselect">Start</a>
                    <a className='button' href="leaderboard">Stats</a>
                    <a className='button' href="leaderboard">Leaderboard</a>
                    <a className='button' href="login">Logout</a>
                </form>
            </div>
        </header>
        </div>
    );
}
export default HomeScreen;