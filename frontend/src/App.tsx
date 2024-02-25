import React, {useEffect, useState} from 'react';
import logo from './logo.svg';
import './App.css';
import TopMenuComponent from "./component/TopMenuComponent";

function App() {

  const [message, setMessage] = useState();
  useEffect(() => {
    fetch("/")
        .then((response) => {
          return response.json();
        })
        .then(function (data) {
          setMessage(data);
        });

  }, []);


  return (
    <div className="App">
        <div>
            <TopMenuComponent>
            </TopMenuComponent>
        </div>
    </div>
  );
}

export default App;
