import './mainMenu.scss'
import {  Link } from "react-router-dom";
import { GiSwordsEmblem } from "react-icons/gi";
import { GiCharacter } from "react-icons/gi";


export function MainMenu() {
    return (
    <div className="appMainMenu">
        <div className="staticHeader">
            <span className="headerText">Initiative Tracker</span>
        </div>
        <div className="menuButtonsWrapper">
            <Link className="menuLink" to={`encounters`}>
                <GiSwordsEmblem></GiSwordsEmblem>
                Encounters
            </Link> 

            <Link className="menuLink">
                <GiCharacter></GiCharacter>
                Characters
            </Link> 

            <Link className="menuLink" to={`templates`}>
                <GiCharacter className="characterTemplateIcon"></GiCharacter>
                Character Templates
            </Link>
        </div>
    </div>
    )
}

