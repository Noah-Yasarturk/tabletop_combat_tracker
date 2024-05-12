
import './characterHealth.scss'

export function CharacterHealth({currentHealth, totalHealth}) {
    return (
        
        <div className="healthWrapper">
            <div className="bottomHexagon">&#x2B22;</div> 
            <div className="topHealthValues" >
                {currentHealth}/{totalHealth}
            </div>
        </div>
    )
}