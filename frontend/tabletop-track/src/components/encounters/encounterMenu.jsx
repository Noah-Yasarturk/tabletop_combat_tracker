import { MdArrowBack } from 'react-icons/md';
import { GiCancel } from "react-icons/gi";
import { GiConfirmed } from "react-icons/gi";
import { Link } from "react-router-dom";
import { GiSwordsEmblem } from "react-icons/gi";
import './encounterMenu.scss';
import { useState } from 'react';

   
export function EncounterMenu() {

    const [namingNewEncounter, setNamingNewEncounter] = useState(false);
   

    function handleNewEncounterClicked(e) {
        console.log(e);
        console.log("Setting newEncounterClicked to ", !namingNewEncounter);
        setNamingNewEncounter(!namingNewEncounter); // toggle it
    }


    function NewEncounterTextEntry() {
        const [newEncounterName, setNewEncounterName] = useState('');
        function saveNewEncounter() {
            console.log("Creating new encounter named ", newEncounterName);
            // TODO: Call backend to create encounter & return encounter ID to redirect window
            return fetch('http://localhost:8080/encounter', {
                method: 'POST',
                headers: {
                  'Accept': 'application/json',
                  'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                  name: newEncounterName
                })
              })
        }
        return (
            <div className="newEncounterButton newEncounterTextBox">
                    <div className="encounterTextEntryQuestion">What should we call this encounter?</div>
                    <div className="encounterTextEntryWrapper">
                        <input id="newEncounterEntry" 
                            value={newEncounterName}
                            onChange={e => setNewEncounterName(e.target.value)}/>
                        <GiConfirmed id='submitNewEncounterButton' onClick={(event) => saveNewEncounter(event) } />
                        <GiCancel id='cancelNewEncounterButton' onClick={(event) => handleNewEncounterClicked(event) }/>
                    </div>
            </div>
        ) 
    }
    
    function NewEncounterButton() {
        return  (
            <div className="newEncounterButton">
                <GiSwordsEmblem></GiSwordsEmblem>
                <span>New Encounter</span>
            </div>
        )
    }

    if (!namingNewEncounter) {
        return (
            <div className="encounterMenuWrapper">
                <div className="staticHeader">
                    <span className="backToMainMenuSection">
                        <Link to={`/`}>
                            <MdArrowBack></MdArrowBack>
                        </Link>
                    </span>
                    <span className="headerText">Encounters</span>
                </div>
                
                <div className="newEncounterButtonWrapper" onClick={(event) => handleNewEncounterClicked(event) } >
                    <NewEncounterButton />
                </div>
            </div>
        )
    }
    return (
        <div className="encounterMenuWrapper">
            <div className="staticHeader">
                <span className="backToMainMenuSection">
                    <Link to={`/`}>
                        <MdArrowBack></MdArrowBack>
                    </Link>
                </span>
                <span className="headerText">Encounters</span>
            </div>
            
            <div className="newEncounterTextEntryCompWrapper">
                <NewEncounterTextEntry />
            </div>
        </div>
    )
}
