// Navbar component with Logo at center of navbar

import React from "react";

export default function Navbar() {
  return (
    <nav className="flex items-center justify-center bg-slate-700 py-4">
      {/* Header with modern tech logo font */}
      <h1 className="text-3xl text-white font-bold logotext">dungeon_ai</h1>
    </nav>
  );
}
