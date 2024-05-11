import './characterRow.scss'
import { CharacterIcon } from './characterIcon'
import { CharacterStat } from './characterStat'

export function CharacterRow({
    playerType, characterName, characterIconPath, characterType, stats}) {

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
            <div className="characterRowTop">
                <CharacterIcon imagePath={characterIconPath}/>
                <div className="nameTypeWrapper">
                    <p className="characterName">{characterName}</p>
                    <p className="characterType">{characterType}</p>
                </div>
                
                {/* Health: {characterHealth} */}
                
                {/* <div> 
                    {characterStats}
                </div>  */}
            </div>
            <div className={ 'bottom ' + playerTypeColors[playerType] }>
                <svg>
                <filter id="wavy2">
                    <feTurbulence x="0" y="0" baseFrequency="0.1" numOctaves="5" seed="1"></feTurbulence>
                    <feDisplacementMap in="SourceGraphic" scale="17" />
                </filter>
                </svg>
            </div>
        </div>
    )
}