// Import React

import React from "react";

// React component that is given a list of games and displays them

export default function GamesList({ games }) {
  return (
    <div className="gamewrapper">
      {games.map((game) => (
        <div className="gamebox m-4 p-4" key={game.id}>
          {/* A row containing information for the game */}
          <p className="py-2">{game.name}</p>
          {/* Button to redirect to individual game page */}
          <button className="bg-slate-800 hover:bg-slate-500 text-white font-bold py-2 px-4 rounded">
            Continue Game
          </button>
        </div>
      ))}
    </div>
  );
}
