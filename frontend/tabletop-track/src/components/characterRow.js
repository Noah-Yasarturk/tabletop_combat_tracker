import './characterRow.scss'
import { CharacterIcon } from './characterIcon'
import { CharacterStat } from './characterStat'
import { CharacterHealth } from './characterHealth'
import { TempStats } from './tempStats'
import pencilIcon from '../assets/pencil_icon.png'
import tripleDotIcon from '../assets/three-dots.svg'

export function CharacterRow({
    playerType, characterName, characterIconPath, characterType, 
    currentHealth, characterHealth, tempStats, stats}) {

    const characterStats = stats.map(stat => 
        <CharacterStat key={characterName + stat.stat_name}
            statName={stat.stat_name}
            statValue={stat.stat_value}
        />
    )

    const playerTypeColors = Object.freeze({
        "ENEMY_NPC": "enemyNpcShader",
        "PLAYER_CHARACTER": "playerCharacterShader",
        "FRIENDLY_NPC": "friendlyNpcShader"
    })

    return (
        <div className={ "characterRowWrapper"}>
            <div className={"characterRowTop "+ playerTypeColors[playerType]}>
                <CharacterIcon imagePath={characterIconPath}/>
                <div className="nameTypeWrapper">
                    <p className="characterName">{characterName}</p>
                    <p className="characterType">{characterType}</p>
                </div>
                <div className="pipeSeparator">
                    |
                </div>
                <CharacterHealth 
                currentHealth={currentHealth} totalHealth={characterHealth}/>
                <div className="pipeSeparator">
                    |
                </div>
                <TempStats tempStats={tempStats}/>
                <div className="pipeSeparator">
                    |
                </div>
                
                <div className="characterStatsWrapper"> 
                    {characterStats}
                </div> 

                <div className="tailEndWrapper">
                    <div className="actionSectionWrapper">
                        <img src={pencilIcon} className="editIcon"></img>
                        <img src={tripleDotIcon} className="moreIcon"></img>
                        <div className="exitEncounterButton">x</div>
                    </div>
                </div>
                
            </div>
        </div>
    )
}