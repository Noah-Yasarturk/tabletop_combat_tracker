import { MdArrowBack } from 'react-icons/md'
import { Link } from "react-router-dom";
import { GiSwordsEmblem } from "react-icons/gi";
import './encounterMenu.scss';
import { useState } from 'react';

   
export function EncounterMenu() {
    const [newEncounterClicked, setNewEncounterClicked] = useState(false);

    function handleNewEncounterClicked() {
        console.log("New encounter clicked! ", newEncounterClicked);
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
        return (
            <div className="newEncounterTextBox">
                    What should we call this encounter?
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
                <NewEncounter onClick={handleNewEncounterClicked}/>
            </div>
        </div>
    )
}