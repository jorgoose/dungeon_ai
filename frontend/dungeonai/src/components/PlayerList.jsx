// Import React

import React from "react";
import ReactDOM from "react-dom";

import Healthbar from "./Healthbar";

// React component that is given a list of games and displays them

export default function PlayerList({ players }) {
  return (
    <div className="players">
      {players.map((player) => (
        <div className="playerwrapper">
          <div className="mt-2 pt-4" key={players.id}>
            {/* Player Image */}
            <img
              className="m-auto h-24"
              src={player.image}
              alt={player.name}
              // On error, display a default image
              onError={(e) => {
                e.target.onerror = null;
                e.target.src =
                  "https://cdn.pixabay.com/photo/2016/08/08/09/17/avatar-1577909_1280.png";
              }}
            />
            {/* Player Name */}
            <p className="text-center py-2">{player.name}</p>

            {/* Healthbar Component With Player Health Info */}
            <Healthbar
              currentHealth={player.currentHealth}
              maxHealth={player.maxHealth}
            />
          </div>
        </div>
      ))}
    </div>
  );
}
