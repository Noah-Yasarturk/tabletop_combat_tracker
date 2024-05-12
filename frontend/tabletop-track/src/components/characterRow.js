import './characterRow.scss'
import { CharacterIcon } from './characterIcon'
import { CharacterStat } from './characterStat'
import { CharacterHealth } from './characterHealth'
import { TempStats } from './tempStats'

export function CharacterRow({
    playerType, characterName, characterIconPath, characterType, 
    currentHealth, characterHealth, tempStats, stats}) {

    const characterStats = stats.map(stat => 
        <CharacterStat
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
                <div class="pipeSeparator">
                    |
                </div>
                <CharacterHealth 
                currentHealth={currentHealth} totalHealth={characterHealth}/>
                <div class="pipeSeparator">
                    |
                </div>
                <TempStats tempStats={tempStats}/>
                <div class="pipeSeparator">
                    |
                </div>
                
                {/* <div> 
                    {characterStats}
                </div>  */}
            </div>
        </div>
    )
}