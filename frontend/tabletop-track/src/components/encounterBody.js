import { CharacterRow } from "./characterRow"
import dummyData from "./dummyStats1.json"


export function EncounterBody(){
    const characterData = dummyData;
    console.log(dummyData)
    const characterRows = characterData.characters.map(characterObj =>
        <CharacterRow/>
    )

    return (
        <div className='encounterBody'>
            {characterRows}
        </div>
    )
}