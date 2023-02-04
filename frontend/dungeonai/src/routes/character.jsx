// Character
// This compontent displays a character's information

import React, { useState } from "react";
import Navbar from "../components/Navbar";
import Bilbo from "../temp/bilbo.jpeg";

export default function Character() {
  const [character, setCharacter] = useState({});

  // useEffect()

  return (
    <div>
      <Navbar />
      <div className="h-screen bg-slate-400">
        <p>Welcome to the Character Screen!</p>

        <div className="grid characterPhoto justify-items-center">
          <img
            src={Bilbo}
            alt="Character Image"
            className="rounded-3xl characterImage"
            style={{ height: "360px" }}
          />
        </div>

        <div className="grid characterInformation justify-items-center">
          <div className="border-2 border-black rounded-md borderClass">
            <div className="border-2 border-black rounded-md borderClass">
              <p>
                Character Name: <strong>Bilbo Baggins</strong>
              </p>
            </div>

            <div className="border-2 border-black rounded-md borderClass">
              <p>Health: 69/69 WE NEED A HEALTH BAR </p>
            </div>

            <div className="border-2 border-black rounded-md borderClass">
              <p>Level: 69</p>
            </div>

            <div className="border-2 border-black rounded-md borderClass">
              <p>
                Character Description: Splits your mom's legs like Moses split
                the sea.
              </p>
            </div>

            <div className="border-2 border-black rounded-md borderStats">
              <p>
                <strong>Stats:</strong>
              </p>

              <div className="grid characterStats grid-cols-2 gap-4">
                <p>
                  <strong>Attack:</strong>
                  <em>69</em>
                </p>
                <p>
                  <strong>Defense:</strong>
                  <em>69</em>
                </p>
                <p>
                  <strong>Magic:</strong>
                  <em>69</em>
                </p>
                <p>
                  <strong>Speed:</strong>
                  <em>69</em>
                </p>
              </div>
            </div>
          </div>
          <a href="http://localhost:5173">
            <button type="button" className="buttonCharacterScreen">
              Back
            </button>
          </a>
        </div>
      </div>
    </div>
  );
}
