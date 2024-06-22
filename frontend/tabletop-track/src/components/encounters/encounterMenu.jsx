import { MdArrowBack } from 'react-icons/md'
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

    function saveNewEncounter() {
        // TODO: Call backend to return encounter ID
        console.log("Hi");
    }

    function NewEncounterTextEntry() {
        return (
            <div className="newEncounterButton newEncounterTextBox">
                    <div className="encounterTextEntryQuestion">What should we call this encounter?</div>
                    <div className="encounterTextEntryWrapper">
                        <input id="newEncounterEntry"></input>
                        <button onClick={(event) => handleNewEncounterClicked(event) } >Cancel</button>
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
            
            <div >
                <NewEncounterTextEntry />
            </div>
        </div>
    )
}