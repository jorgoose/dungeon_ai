// Games
// This component is the main page of the app. It displays a list of games

import React, { useState } from "react";
import Navbar from "../components/Navbar";

export default function Games() {
  const [games, setGames] = useState([]);

  // useEffect()

  return (
    <div>
      <Navbar />
        <div className="h-screen bg-slate-400">
        </div>
    </div>
  );
}
