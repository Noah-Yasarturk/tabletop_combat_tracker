import './characterRow.scss'
import { CharacterStat } from './characterStat'

export function CharacterRow({characterName}) {

    
    return (
        <div className="characterRowWrapper">
            Name: {characterName}
            <CharacterStat/>
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