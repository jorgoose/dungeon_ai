// Component to create a new game and add it to the database

// Import React
import React, { useState } from "react";

// React component that is a button that when clicked, creates a new game and adds it to the database

export default function AddGame() {
  const [game, setGame] = useState({
    name: "",
    description: "",
    players: 0,
    status: "",
  });

  const handleChange = (e) => {
    setGame({ ...game, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(game);

    // Send data to backend:
    // ...
  };

  return (
    <div className="gameadd m-auto my-4 p-4 w-2/5">
      <h1 className="row-span-full mb-4 text-lg font-bold">
        Create a New Game:
      </h1>
      <form onSubmit={handleSubmit}>
        <label className="justify-content-center" htmlFor="name">
          Game Name:
        </label>
        <input
          type="text"
          name="name"
          className="ml-1 mr-6 pl-2 pt-1 pb-1 gameinput"
          value={game.name}
          onChange={handleChange}
          style={{ backgroundColor: "bg-slate-400", borderRadius: "5px" }}
        />
        <button
          className="bg-slate-800 hover:bg-slate-500 text-white font-bold py-2 px-4 rounded"
          type="submit"
        >
          Submit
        </button>
      </form>
    </div>
  );
}
