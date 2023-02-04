// Import React

import React from "react";

// React component that is given a list of games and displays them

export default function EventsList({ events }) {
  return (
    <div className="eventswrapper">
      {events.map((event) => (
        <div className="eventbox m-4 p-4" key={event.id}>
          {/* A row containing information for the game */}
          <p className="py-2">{event.text}</p>
        </div>
      ))}
    </div>
  );
}
