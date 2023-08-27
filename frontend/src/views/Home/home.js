import React  from 'react'

import { Helmet } from 'react-helmet'

import './home.css'
import { Button } from 'antd';


const Home = (props) => {

  const [p1p1, setP1p1] = React.useState(0);
  const [p1p2, setP1p2] = React.useState(0);
  const [p1p3, setP1p3] = React.useState(0);
  const [p1p4, setP1p4] = React.useState(0);
  const [p1p5, setP1p5] = React.useState(0);
  const [p1p6, setP1p6] = React.useState(0);
  const [p1BigPit, setP1BigPit] = React.useState(0);
  const [p2p1, setP2p1] = React.useState(0);
  const [p2p2, setP2p2] = React.useState(0);
  const [p2p3, setP2p3] = React.useState(0);
  const [p2p4, setP2p4] = React.useState(0);
  const [p2p5, setP2p5] = React.useState(0);
  const [p2p6, setP2p6] = React.useState(0);
  const [p2BigPit, setP2BigPit] = React.useState(0);
  const [isPlayer1, setIsPlayer1] = React.useState(true);
  const [isFinished, setIsFinished] = React.useState(true);
  const [p1Name, setP1Name] = React.useState("");
  const [p2Name, setP2Name] = React.useState("");

  function play (playerTurn,pitIndex){
    fetch("/updatePosition", {
      method: "PUT",
      body: JSON.stringify({
          name: playerTurn,
          pitIndex: pitIndex,
      }),
      headers: {
          "Content-type": "application/json; charset=UTF-8"
      }}).then(async response => {
      try {
       const data = await response.json()
       setP1p1(data.pits[0].size);
       setP1p2(data.pits[1].size);
       setP1p3(data.pits[2].size);
       setP1p4(data.pits[3].size);
       setP1p5(data.pits[4].size);
       setP1p6(data.pits[5].size);
       setP1BigPit(data.pits[6].size)
       setP2p1(data.pits[7].size);
       setP2p2(data.pits[8].size);
       setP2p3(data.pits[9].size);
       setP2p4(data.pits[10].size);
       setP2p5(data.pits[11].size);
       setP2p6(data.pits[12].size)
       setP2BigPit(data.pits[13].size)
       if(!data.isPlayAgain){
        setIsPlayer1(!isPlayer1);
        const message = ""
        document.getElementById("message").textContent=message;
       }
       if(data.isPlayAgain){
        const message = "Player will have another move"
        document.getElementById("message").textContent=message;
       }
       if(data.isFinished){
        document.getElementById("message").textContent=data.result;
        setIsFinished(true);
       }
        return false;
     } catch(error) {
       console.log('Error happened here!')
     }
    })
  };

  //funtion that triggered by createGame button
  function createGame() {
    fetch("/createGame", {
      method: "POST",
      body: JSON.stringify({
        p1Name: "p1",
        p2Name: "p2"
      }),
      headers: {
          "Content-type": "application/json; charset=UTF-8"
      }}).then(async response => {
      try {
        const data = await response.json();
        setP1p1(data.pits[0].size);
        setP1p2(data.pits[1].size);
        setP1p3(data.pits[2].size);
        setP1p4(data.pits[3].size);
        setP1p5(data.pits[4].size);
        setP1p6(data.pits[5].size);
        setP1BigPit(data.pits[6].size)
        setP2p1(data.pits[7].size);
        setP2p2(data.pits[8].size);
        setP2p3(data.pits[9].size);
        setP2p4(data.pits[10].size);
        setP2p5(data.pits[11].size);
        setP2p6(data.pits[12].size)
        setP2BigPit(data.pits[13].size)
        setP1Name(data.player1.name)
        setP2Name(data.player2.name)
     
     } catch(error) {
       console.log('Error happened here!')
     }
    })
    setIsPlayer1(true);
    setIsFinished(false)
    const message = " Game Created ";
    document.getElementById("message").textContent=message;
  }
  //creating game board
  return (
    <div className="home-container">
      <Helmet>
        <title>Mancala</title>
        <meta property="og:title" content="Mancala" />
      </Helmet>
      <div className="home-containermenu">
        <Button className="button" onClick={createGame}><p>Create Game</p></Button>
        <span id="message" className="alert-message"></span>
      </div>
      <div className='pit-container'>
        <div className="home-container-firstrow">
          <div className="home-container-big-1">
            <span className='bigPit'>{p2Name} Big Pit</span>
            <div className="player2"><p className='count-big'>{p2BigPit}</p></div>
          </div>
          <div className="home-container-small">
            <span className='number'>6</span>
            <Button className="player2"  disabled={(isFinished || isPlayer1) ? true : false} onClick={() => play(p2Name,12)} ><p className='count'>{p2p6}</p></Button>
          </div>
          <div className="home-container-small">
            <span className='number'>5</span>
            <Button className="player2" disabled={(isFinished || isPlayer1) ? true : false} onClick={() => play(p2Name,11)}><p className='count'>{p2p5}</p></Button>
          </div>
          <div className="home-container-small">
            <span className='number'>4</span>
            <Button className="player2" disabled={(isFinished || isPlayer1) ? true : false} onClick={() => play(p2Name,10)}><p className='count'>{p2p4}</p></Button>
          </div>
          <div className="home-container-small">
            <span className='number'>3</span>
            <Button className="player2" disabled={(isFinished || isPlayer1) ? true : false} onClick={() => play(p2Name,9)}><p className='count'>{p2p3}</p></Button>
          </div>
          <div className="home-container-small">
            <span className='number'>2</span>
            <Button className="player2" disabled={(isFinished || isPlayer1) ? true : false} onClick={() => play(p2Name,8)}><p className='count'>{p2p2}</p></Button>
          </div>
          <div className="home-container-small">
            <span className='number'>1</span>
            <Button className="player2" disabled={(isFinished || isPlayer1) ? true : false}  onClick={() => play(p2Name,7)}><p className='count'>{p2p1}</p></Button>
          </div>
        </div>
        <div className="home-container-secondrow">
          <div className="home-container-small">
            <span className='number'>1</span>
            <Button className="player1" disabled={(isFinished || !isPlayer1) ? true : false}  onClick={() => play(p1Name,0)}><p className='count'>{p1p1}</p></Button>
          </div>
          <div className="home-container-small">
            <span className='number'>2</span>
            <Button className="player1" disabled={(isFinished || !isPlayer1) ? true : false}  onClick={() => play(p1Name,1)}><p className='count'>{p1p2}</p></Button>
          </div>
          <div className="home-container-small">
            <span className='number'>3</span>
            <Button className="player1" disabled={(isFinished || !isPlayer1) ? true : false} onClick={() => play(p1Name,2)}><p className='count'>{p1p3}</p></Button>
          </div>
          <div className="home-container-small">
            <span className='number'>4</span>
            <Button className="player1" disabled={(isFinished || !isPlayer1) ? true : false} onClick={() => play(p1Name,3)}><p className='count'>{p1p4}</p></Button>
          </div>
          <div className="home-container-small">
            <span className='number'>5</span>
            <Button className="player1" disabled={(isFinished || !isPlayer1) ? true : false} onClick={() => play(p1Name,4)}><p className='count'>{p1p5}</p></Button>
          </div>
          <div className="home-container-small">
            <span className='number'>6</span>
            <Button className="player1" disabled={(isFinished || !isPlayer1) ? true : false} onClick={() => play(p1Name,5)}><p className='count'>{p1p6}</p></Button>
          </div>
          <div className="home-container-big-2">
            <span className='bigPit'>{p1Name} Big Pit</span>
            <div className="player1"><p className='count-big'>{p1BigPit}</p></div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Home
