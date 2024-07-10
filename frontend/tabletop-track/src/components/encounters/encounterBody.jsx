import { CharacterRow } from "../characters/characterRow"
import { EncounterHeader } from "./encounterHeader";
import dummyData from "../../dummyStats1.json"


export function EncounterBody(){
    const characterData = dummyData; // TODO: replace with backend REST call
    const characterRows = characterData.characters.map(characterObj =>
        <CharacterRow 
            key={characterObj.name} // React requires use of a unique ID in lists
            playerType={characterObj.player_type}
            characterName={characterObj.name}
            characterIconPath={characterObj.icon}
            characterType={characterObj.character_type}
            currentHealth={characterObj.current_health}
            characterHealth={characterObj.total_health}
            instanceStats={characterObj.instance_stat}
            stats={characterObj.stats}
        />
    )

    return (
        <>
            <EncounterHeader encounterName={"Dummy Encounter"}/>
            <div className='encounterBody'>
                {characterRows}
            </div>
        </>
    )
}