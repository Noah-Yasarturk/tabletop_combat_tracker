import { BackButton } from "../backButton";
import { GiCharacter } from "react-icons/gi";
import './charTemplate.scss'
import { useState, useEffect } from 'react';


function NewTemplateButton() {
    return (
        <div className="newTemplateButton">
            <GiCharacter className="characterTemplateIcon" id="charOutlineLeft"></GiCharacter>
            <span>New Template</span>
            <GiCharacter className="characterTemplateIcon" id="charOutlineRight"></GiCharacter>

        </div>
    )
}

export function CharTemplateMenu() {
    const [creatingNewTemplate, setCreatingNewTemplate] = useState(false);

    function handleNewTemplateClicked(e) {
        setCreatingNewTemplate(!creatingNewTemplate); // toggle it
    }

    if (!creatingNewTemplate) {
        return (
            <div className="charTemplateMenuWrapper">
                <div className="staticHeader">
                    <BackButton/>
                    <span className="charTemplateMenuHeader">Character Templates</span>
                </div>
    
    
                 {/* Saved templates */}
    
    
                 {/* Create new template */}
                 <div className="newTemplateButtonWrapper" onClick={(event) => handleNewTemplateClicked(event)} >
                    <NewTemplateButton />
                </div>
                 
                
            </div>
    
        )
    }
    
}