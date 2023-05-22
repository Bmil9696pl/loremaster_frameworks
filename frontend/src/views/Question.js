import React, { useState, useEffect } from 'react'; 
import '../style/App.css';
import axios from 'axios';

const Question = () => {
  
  const [question, setQuestion] = useState('');
  const [answer1, setAnswer1] = useState('');
  const [answer2, setAnswer2] = useState('');
  const [answer3, setAnswer3] = useState('');
  const [answer4, setAnswer4] = useState('');
  const token = sessionStorage.getItem('token');
  const region = sessionStorage.getItem('region');
  const pastQuestionId = "0";

  useEffect(() =>{
    const options = {
      method: 'POST',
      url: "http://localhost:8888/question/get",
      headers: {
        "Authorization": 'Bearer ' + token,
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
      data: {
        regionId: region,
        pastQuestionId: pastQuestionId
    }
    };

    axios.request(options
    ).then(function (response){
      console.log(response)
    });

  })

  return (
    <div className="Question">
        <header className="App-header">
            {/*<p>Score: {score}</p>*/}
      {/*<p>Health: {health}</p>*/}
      <div className="question-container">
        {/*<p>Question {id}</p>*/}
        {/*<p>{question}</p>*/}
        <p>QQQQQQQQ</p>
      </div>
      <form className="answers-container" >
        <button className="answer" type="submit">
          {/*<p>{answer1[0]}</p>*/}
          <p>AAAAAA</p>
        </button>
        <button className="answer" type="submit">
          {/*<p>{answer2[0]}</p>*/}
          <p>AAAAAA</p>

        </button>
        <button className="answer" type="submit">
          {/*<p>{answer3[0]}</p>*/}
          <p>AAAAAA</p>

        </button>
        <button className="answer" type="submit">
          {/*<p>{answer4[0]}</p>*/}
          <p>AAAAAA</p>

        </button>
      </form>
        </header>
    </div>
  );
}

export default Question;
