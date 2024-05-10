import './characterRow.scss'
import { CharacterStat } from './characterStat'

export function CharacterRow({characterName, characterType, characterHealth, stats}) {

    const characterStats = stats.map(stat => {
        console.log(stat);
        <CharacterStat
            statName={stat.stat_name}
            statValue={stat.val}
        />
    })
    
    return (
        <div className="characterRowWrapper">
            Name: {characterName}
            Type: {characterType}
            Health: {characterHealth}
            {characterStats}
            <div className='parchment'>
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