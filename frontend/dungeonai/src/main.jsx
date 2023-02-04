import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import "./index.css";
import Root from "./routes/root";
import Games from "./routes/games";
import Character from "./routes/character";
import CharacterCreate from "./routes/characterCreate";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
  },
  {
    path: "/games",
    element: <Games />,
  },
  {
    path: "/character",
    element: <Character />,
  },
  {
    path: "/characterCreate",
    element: <CharacterCreate />,
  }
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
