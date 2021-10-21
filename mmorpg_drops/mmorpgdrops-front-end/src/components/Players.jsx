import React, { useState, useEffect } from 'react';
import PlayerTable from '../tables/PlayerTable';
import AddPlayerForm from '../forms/AddPlayerForm';
import EditTeamForm from '../forms/EditTeamForm';
import { Container, Row, Col} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';


export function Players (props){
  const SERVICE_URL = 'http://localhost:8080'

  const getPlayerData = () => {
    return fetch(SERVICE_URL + '/allPlayers')      // get users list
      .then(response => response.json())           // parse JSON
      .then(players => setPlayers(players))        // pick first user
  }

  const playerData = [



  ]

  const [players, setPlayers] = useState(playerData)

  const addPlayer = (players) => {
    fetch(SERVICE_URL + '/addPlayer/'+players.playerName, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(players),
    })
      .then(response => response.json())
      .then(data => {
        getPlayerData();
      })
      .catch((error) => {
        console.log('Add Player - Error:')
        console.log(error)
      });
  }

  const removePlayer = (player) => {

    fetch(SERVICE_URL + '/removePlayer/' + player, {
      method: 'POST',
    })
      .then(data => {
        getPlayerData();
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  }
  
  const initialFormState = {
    playerName: '',
    teamName: ''
  }

  const [currentPlayer, setCurrentPlayer] = useState(initialFormState)
  const [editing, setEditing] = useState(false)

  const editRow = (player) => {
    setEditing(true)
    setCurrentPlayer({
      playerName: player.playerName,
      teamName: player.teamName
    })
  }

  const joinTeam = (playerName, player) => {


    fetch(SERVICE_URL + '/joinTeam/' + playerName,{
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(player.teamName),
    })
      .then(response => response.json())
      .then(data => {
        console.log('Success:', data);
        setEditing(false)
        getPlayerData();
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  }


  const leaveTeam = (playerName) => {

    fetch(SERVICE_URL + '/leaveTeam/' + playerName,{
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      //body: JSON.stringify(),
    })
      .then(response => response.json())
      .then(data => {
        console.log('Success:', data);
        setEditing(false)
        getPlayerData();
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  }


  useEffect(() => {
    getPlayerData()
  }, [props])


  if(players){
      return (
    <Container>
      <hr />
      <Row>
        <Col sm={9}>
          <h2>Players</h2>
          <PlayerTable
            players={players}
            removePlayer={removePlayer}
            editRow={editRow}
          />
        </Col>
        <Col sm={3}>
        {editing ? (
            <div>
              <h2>Edit Team</h2>
              <EditTeamForm
                setEditing={setEditing}
                currentPlayer={currentPlayer}
                joinTeam={joinTeam}
                leaveTeam={leaveTeam}
              />
            </div>
          ) : (
          <div>
            <h2>Add Player</h2>
            <AddPlayerForm addPlayer={addPlayer} />
          </div>
          )}
        </Col>
      </Row>
    </Container>
  )
}
}

