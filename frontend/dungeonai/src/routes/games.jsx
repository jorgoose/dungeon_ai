// Games
// This component is the main page of the app. It displays a list of games

import React, { useState } from "react";

export default function Games() {
  const [games, setGames] = useState([]);

  // useEffect()

  return (
    <div className="Games">
      <h1>Games</h1>
      <ul>
        <li>...</li>
      </ul>
    </div>
  );
}
