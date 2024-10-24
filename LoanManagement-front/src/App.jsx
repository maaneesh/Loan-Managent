import { useState } from "react";
import { createBrowserRouter, RouterProvider } from "react-router-dom";

import "./index.css";
import Navbar from "./components/navbar";
import Dashboard from "./components/dashboard";
import User from "./components/user";
import Form from "./components/Form";

function App() {
  const router = createBrowserRouter([
    {
      path: "/",
      element: (
        <>
          <Navbar />
          <Dashboard />
        </>
      ),
    },
    {
      path: "/login",
      element: (
        <>
          <Navbar />
          <User />
        </>
      ),
    },
    {
      path: "/application",
      element: (
        <>
          <Navbar />
          <Form />
        </>
      ),
    },
  ]);
  return (
    <>
      <RouterProvider router={router} />
    </>
  );
}

export default App;
