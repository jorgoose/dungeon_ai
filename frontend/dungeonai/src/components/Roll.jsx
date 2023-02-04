// React component to simulate a dice roll with a button

// Import React

import React from "react";

import { useState } from "react";
import { useEffect } from "react";

// Rolls a dice with a number from 1 to 20, displays the number rolled, and sends the number rolled to the server

export default function Die({ id }) {
  // State variable to hold the number rolled
  const [roll, setRoll] = useState(0);

  // Function to roll the die
  const rollDie = () => {
    // Get a random number between 1 and 20
    const roll = Math.floor(Math.random() * 20) + 1;

    // Assign the random number to the state variable
    setRoll(roll);

    // Update the value of the element with id "rollval" to the value of the roll
    document.getElementById("rollval").innerHTML = "Roll: " + roll;

    // Make post request to server at "`localhost:8080/events/${id}/${roll}`"
    fetch(`http://localhost:8080/events/${id}/${roll}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    }).finally(() => {
      // Print a message to the console about dice roll
      console.log("Dice rolled");
    });
  };

  return (
    <div className="diebox m-4 p-4">
      {/* Button to roll the die */}
      <button
        className="bg-slate-800 hover:bg-slate-500 text-white font-bold py-2 px-4 rounded"
        onClick={rollDie}
      >
        Roll Die
      </button>
      {/* A row containing information for the game */}
      <p id="rollval" className="py-2">
        Roll:{" "}
      </p>
    </div>
  );
}
