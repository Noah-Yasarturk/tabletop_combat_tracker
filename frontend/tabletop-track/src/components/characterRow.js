import './characterRow.scss'
import { CharacterIcon } from './characterIcon'
import { CharacterStat } from './characterStat'

export function CharacterRow({
    characterName, characterIconPath, characterType, characterHealth, stats}) {

    const characterStats = stats.map(stat => 
        <CharacterStat
            statName={stat.stat_name}
            statValue={stat.stat_value}
        />
    )
    
    return (
        <div className="characterRowWrapper">
            <div className="characterRowTop">
                <CharacterIcon imagePath={characterIconPath}/>
                {/* Name: {characterName}
                Type: {characterType}
                Health: {characterHealth}*/}
                
                {/* <div className="rowStatWrapper"> 
                    {characterStats}
                </div>  */}
            </div>
            <div className='parchmentBottom'>
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