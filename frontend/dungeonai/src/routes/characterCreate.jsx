// Games
// This component is the main page of the app. It displays a list of games

import React, { useState } from "react";
import Navbar from "../components/Navbar";

export default function CharacterCreate() {
  const [newCharacter, setNewCharacter] = useState([
    {
      name1: "",
      appearance1: "",
      attack1: "",
      defense1: "",
      magic1: "",
      speed1: "",
    },
    {
      name2: "",
      appearance2: "",
      attack2: "",
      defense2: "",
      magic2: "",
      speed2: "",
    },
    {
      name3: "",
      appearance3: "",
      attack3: "",
      defense3: "",
      magic3: "",
      speed3: "",
    },
  ]);

  const handleChange = (e) => {
    setNewCharacter({ ...CharacterCreate, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(game);
  };

  // useEffect()

  return (
    <div>
      <Navbar />
      <div className="h-max bg-slate-400">
        <div className="mainPage">
          <div className="border-2 border-black rounded-md character1">
            <div className="grid characterInformation1 justify-items-center">
              <div className="nameInput">
                <p>Character 1's Name:</p>
                <input type="text" id="name" name="name" size="100" />
              </div>
              <div className="appearanceInput">
                <p>Character Appearance:</p>
                <input
                  type="text"
                  id="appearance"
                  name="appearance"
                  size="100"
                />
              </div>
            </div>
            <div className="mx-80 descriptionInput">
              <div className="border-2 border-black rounded-md borderStats">
                <p>
                  <strong>Stats:</strong>
                </p>

                <div className="grid characterStats grid-cols-2 gap-2 justify-items-center">
                  <p>
                    <strong>Attack:</strong>
                  </p>
                  <input type="number" id="attack" name="attack" value="0" />
                  <p>
                    <strong>Defense:</strong>
                  </p>
                  <input type="number" id="defense" name="defense" value="0" />
                  <p>
                    <strong>Magic:</strong>
                  </p>
                  <input type="number" id="magic" name="magic" value="0" />
                  <p>
                    <strong>Speed:</strong>
                  </p>
                  <input type="number" id="speed" name="speed" value="0" />
                </div>
              </div>
            </div>
          </div>

          <div className="border-2 border-black rounded-md character2">
            <div className="grid characterInformation2 justify-items-center">
              <div className="nameInput">
                <p>Character 2's Name:</p>
                <input type="text" id="name" name="name" size="100" />
              </div>
              <div className="appearanceInput">
                <p>Character Appearance:</p>
                <input
                  type="text"
                  id="appearance"
                  name="appearance"
                  size="100"
                />
              </div>
            </div>
            <div className="mx-80 descriptionInput">
              <div className="border-2 border-black rounded-md borderStats">
                <p>
                  <strong>Stats:</strong>
                </p>

                <div className="grid characterStats grid-cols-2 gap-2 justify-items-center">
                  <p>
                    <strong>Attack:</strong>
                  </p>
                  <input type="number" id="attack" name="attack" value="0" />
                  <p>
                    <strong>Defense:</strong>
                  </p>
                  <input type="number" id="defense" name="defense" value="0" />
                  <p>
                    <strong>Magic:</strong>
                  </p>
                  <input type="number" id="magic" name="magic" value="0" />
                  <p>
                    <strong>Speed:</strong>
                  </p>
                  <input type="number" id="speed" name="speed" value="0" />
                </div>
              </div>
            </div>
          </div>
          <div className="border-2 border-black rounded-md character3">
            <div className="grid characterInformation3 justify-items-center">
              <div className="nameInput">
                <p>Character 3's Name:</p>
                <input type="text" id="name" name="name" size="100" />
              </div>
              <div className="appearanceInput">
                <p>Character Appearance:</p>
                <input
                  type="text"
                  id="appearance"
                  name="appearance"
                  size="100"
                />
              </div>
            </div>
            <div className="mx-80 descriptionInput">
              <div className="border-2 border-black rounded-md borderStats">
                <p>
                  <strong>Stats:</strong>
                </p>

                <div className="grid characterStats grid-cols-2 gap-2 justify-items-center">
                  <p>
                    <strong>Attack:</strong>
                  </p>
                  <input type="number" id="attack" name="attack" value="0" />
                  <p>
                    <strong>Defense:</strong>
                  </p>
                  <input type="number" id="defense" name="defense" value="0" />
                  <p>
                    <strong>Magic:</strong>
                  </p>
                  <input type="number" id="magic" name="magic" value="0" />
                  <p>
                    <strong>Speed:</strong>
                  </p>
                  <input type="number" id="speed" name="speed" value="0" />
                </div>
              </div>
            </div>
          </div>
          <div className="grid buttons justify-items-center">
            <button type="button" className="buttonCharacterScreen">
              Submit
            </button>
            <button type="button" className="buttonCharacterScreen">
              Back
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}
