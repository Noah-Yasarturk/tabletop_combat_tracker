import { CharacterRow } from "./characterRow"
import dummyData from "./dummyStats1.json"


export function EncounterBody(){
    const characterData = dummyData; // TODO: replace with backend REST call
    console.log(dummyData)
    const characterRows = characterData.characters.map(characterObj =>
        <CharacterRow 
            characterName={characterObj.name}
        />
    )

    return (
        <div className='encounterBody'>
            {characterRows}
        </div>
    )
}