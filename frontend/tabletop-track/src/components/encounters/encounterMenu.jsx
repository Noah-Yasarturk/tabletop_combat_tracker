import { MdArrowBack } from 'react-icons/md'
import { Link } from "react-router-dom";
import { GiSwordsEmblem } from "react-icons/gi";
import './encounterMenu.scss';
import { useState } from 'react';

   
export function EncounterMenu() {
    const [newEncounterClicked, setNewEncounterClicked] = useState(false);

    function handleNewEncounterClicked() {
        setNewEncounterClicked(!newEncounterClicked); // toggle it
    }

    function saveNewEncounter() {
        // TODO: Call backend to return encounter ID
        console.log("Hi");
    }
    
    function NewEncounter() {
        if (newEncounterClicked === false) {
            return  (
                <div className="newEncounterButton">
                    <GiSwordsEmblem></GiSwordsEmblem>
                    <span>New Encounter</span>
                </div>
            )
        }
        // pointer-events: none
        document.getElementById("newEncounterSect").style.pointerEvents = "none";
        return (
            <div className="newEncounterButton newEncounterTextBox">
                    What should we call this encounter?
                    <div className="encounterTextEntryWrapper">
                        <input></input>
                        <button>Cancel</button>
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
            
            <div className="encounterSelectionWrapper">
                {/* TODO: render via API call to getEncounters() */}
                <div onClick={handleNewEncounterClicked} id="newEncounterSect">
                    <NewEncounter />
                </div>
            </div>
        </div>
    )
}