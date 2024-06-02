import { MdArrowBack } from 'react-icons/md'
import { Link } from "react-router-dom";
import './encounterMenu.scss';

export function EncounterMenu() {
    return (
        <div class="encounterMenuWrapper">
            <div className="staticHeader">
                <span class="backToMainMenuSection">
                    <Link to={`/`}>
                        <MdArrowBack></MdArrowBack>
                    </Link>
                </span>
                <span className="headerText">Encounters</span>
            </div>
            
            <div class="encounterSelectionWrapper">
                {/* TODO: render via API call to getEncounters() */}
                <button class="newEncounterButton">New Encounter</button>
            </div>
        </div>
    )
}