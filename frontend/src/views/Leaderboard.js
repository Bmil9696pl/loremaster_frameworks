import React, {useState, useEffect} from 'react';
import '../style/App.css';
import axios from 'axios';

const Leaderboard = () => {
    const [leaders, setLeaders] = useState([]);
    const userScores = [];

    async function getLeaders() {
        const options = {
            method: 'GET',
            url: 'http://localhost:8888/users/getleaders',
            headers: {'Content-Type': 'application/json'},  
        };
        axios.request(options)
        .then(function (response) {
            console.log(response)
            setLeaders(response.data)
        })
        .catch(function (error){
            console.log(error);
        })
    };

    useEffect(() =>{
        getLeaders();
        console.log("leaders:")
        console.log(leaders)
    }, [])

    
    return (
      <div className="App-header">
        <p className="stext">Leaders:</p>
        <div className="leaderboard-container">
          <section className="leaders">
            <form style={{ paddingTop: '10px', paddingBottom: '10px' }}>
              {leaders.map((userScore) => (
                <div className="leaderboard-user">
                  <p style={{color: 'black'}}>{userScore.username}</p>
                  <p style={{color: 'black'}}>{userScore.score}</p>
                </div>
              ))}
            </form>
          </section>
        </div>
      </div>
    );
    
}

export default Leaderboard;
