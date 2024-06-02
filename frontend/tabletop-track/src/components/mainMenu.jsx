import './mainMenu.scss'
import { Outlet, Link } from "react-router-dom";

export function MainMenu() {
    return (
    <div class="appMainMenu">
        <h1>Initiative Tracker</h1>
        <div class="menuButtonsWrapper">
            <Link class="menuLink" to={`encounters`}>Encounters</Link> 

            <Link class="menuLink">Characters</Link> 

            <Link class="menuLink">Character Templates</Link>
        </div>
    </div>
    )
}