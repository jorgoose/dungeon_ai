import { useState } from "react";
import reactLogo from "./assets/react.svg";
import "./App.css";

import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

function App() {
  const [count, setCount] = useState(0);

  return (
    // React router to different routes
    <div className="App">
      <p>Hello World!</p>
    </div>

    // Router within
  );
}

export default App;
