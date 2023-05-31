import React from 'react';
import '../style/App.css';
import loremaster from '../img/Loremaster.svg'

const HomeScreen = () => {
    return(
        <div className="Home">
            <header className='App-header'>
                <img className="Loremaster"src={loremaster} />
                <div className="menu" style={{marginTop:20}}>
                    <form className="menu-buttons" style={{ margin: 5, display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center', width: '80%', height: '70%' }}>
                        <a className='button' href="regionselect">Start</a>
                        <a className='button' href="leaders">Leaderboard</a>
                        <a className='button' href="login">Logout</a>
                    </form>
                </div>
            </header>
        </div>
    );
}
export default HomeScreen;