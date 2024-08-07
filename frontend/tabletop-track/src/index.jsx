import React from 'react';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter,  RouterProvider } from "react-router-dom";
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { EncounterMenu } from './components/encounters/encounterMenu';
import { EncounterBody } from './components/encounters/encounterBody';

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />
  },
  {
    path: "/encounters",
    element: <EncounterMenu/>
  },
  {
    path: "/encounter/dummy",
    element: <EncounterBody/>
  }
])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <RouterProvider router={router}/>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
