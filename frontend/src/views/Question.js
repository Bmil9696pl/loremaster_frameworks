import React, { useState, useEffect } from 'react'; 
import '../style/App.css';
import axios from 'axios';

const Question = () => {
  const [score, setScore] = useState(0);
  const [health, setHealth] = useState(3);
  const [question, setQuestion] = useState('Q');
  const [answer1, setAnswer1] = useState('A1');
  const [answer2, setAnswer2] = useState('A2');
  const [answer3, setAnswer3] = useState('A3');
  const [answer4, setAnswer4] = useState('A4');
  const [correctAnswer, setCorrectAnswer] = useState('');
  const token = sessionStorage.getItem('token');
  const region = sessionStorage.getItem('region');
  const [pastQuestionId, setPastQuestionId] = useState("0");

  async function handleSaveScore(){
    const options = {
      method: 'POST',
      url: "http://localhost:8888/users/setscore",
      headers: {
        "Authorization": 'Bearer ' + token,
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
      data: {
        regionId: region.toString,
        score: score.toString
    }
    };
    axios.request(options)
    .then(response => console.log(response)
    ).catch(error => console.log(error));
  }

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
      setPastQuestionId(pastQuestionId+";"+response.data.questionId);
      setQuestion(response.data.question);
      var questions = [response.data.right_answer, response.data.wrong_answer1, response.data.wrong_answer2, response.data.wrong_answer3]
      setCorrectAnswer(response.data.right_answer);
      setAnswer1(questions.splice(Math.floor(Math.random()*questions.length), 1));
      setAnswer2(questions.splice(Math.floor(Math.random()*questions.length), 1));
      setAnswer3(questions.splice(Math.floor(Math.random()*questions.length), 1));
      setAnswer4(questions.splice(Math.floor(Math.random()*questions.length), 1));
    }).catch(()=>{
      handleSaveScore();
      window.location.href = '/home';
    });

  }, [score, health])

  async function handleAnswers(e){
    e.preventDefault();
    console.log("handler");
    var selectedAnswer= e.target.innerText;
    console.log(selectedAnswer);
    if(selectedAnswer === correctAnswer){
      setScore(score + 1);
    } else {
      setHealth(health - 1);
      if(health===0){
        handleSaveScore();
        window.location.href = '/home';
      }
    }
  }

  return (
    <div className="Question">
        <header className="App-header">
            {<p>Score: {score}</p>}
            {<p>Health: {health}</p>}
      <div className="question-container">
        <p>{question}</p>
      </div>
      <form className="answers-container" >
        <button className="answer" type="submit" onClick={handleAnswers}>
          {answer1}
        </button>
        <button className="answer" type="submit" onClick={handleAnswers}>
          {answer2}
        </button>
        <button className="answer" type="submit" onClick={handleAnswers}>
          {answer3}
        </button>
        <button className="answer" type="submit" onClick={handleAnswers}>
          {answer4}
        </button>
      </form>
        </header>
    </div>
  );
}

export default Question;
