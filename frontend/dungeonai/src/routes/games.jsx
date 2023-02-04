// Games
// This component is the main page of the app. It displays a list of games

import React, { useEffect, useState } from "react";
import Navbar from "../components/Navbar";
import GamesList from "../components/GamesList";
import AddGame from "../components/AddGame";

//

export default function Games() {
  const [games, setGames] = useState([]);

  // Initialize games array with dummy data

  const gamesData = [
    {
      id: 1,
      name: "Game 1",
      description: "This is game 1",
      players: 2,
      status: "active",
    },
    {
      id: 2,
      name: "Game 2",
      description: "This is game 2",
      players: 2,
      status: "active",
    },
  ];

  // useEffect()

  // At load of component, intialize games array with dummy data

  // useEffect(() => {
  //   setGames([
  //     {
  //       id: 1,
  //       name: "Game 1",
  //       description: "This is game 1",
  //       players: 2,
  //       status: "active",
  //     },
  //     {
  //       id: 2,
  //       name: "Game 2",
  //       description: "This is game 2",
  //       players: 2,
  //       status: "active",
  //     },
  //   ]);
  // }, []);

  return (
    <div>
      <Navbar />
      <div className="h-screen bg-slate-400">
        {/* Render list of games */}
        <GamesList games={gamesData} />
        <AddGame />
      </div>
    </div>
  );
}
