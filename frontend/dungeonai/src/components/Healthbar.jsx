// A react component to represent a player's health bar. The component will be given the current health and max health of the player and will display a health bar with the current health as a percentage of the max health.

// Import React
import React from "react";

// React component that is given a list of games and displays them

export default function Healthbar({ currentHealth, maxHealth }) {
  return (
    <progress
      className="healthbar"
      value={currentHealth}
      max={maxHealth}
    ></progress>
  );
}
