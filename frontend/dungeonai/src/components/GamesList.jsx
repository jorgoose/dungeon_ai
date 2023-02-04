// Import React

import React from "react";

// React component that is given a list of games and displays them

// Function for when the button is clicked, the user will be redirected to the game page with the id of the game
const handleClick = (id) => {
  window.location.href = `/games/${id}`;
};

export default function GamesList({ games }) {
  return (
    <div className="gamewrapper">
      {games.map((game) => (
        <div className="gamebox m-4 p-4" key={game.id}>
          {/* A row containing information for the game */}
          <p className="py-2">{game.name}</p>
          {/* Button to redirect to individual game page */}
          <button
            className="bg-slate-800 hover:bg-slate-500 text-white font-bold py-2 px-4 rounded"
            onClick={() => handleClick(game.id)}
          >
            Continue Game
          </button>
        </div>
      ))}
    </div>
  );
}
