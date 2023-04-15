import React from 'react';
import '../style/App.css';

function Question() {
  
  return (
    <div className="App">
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
