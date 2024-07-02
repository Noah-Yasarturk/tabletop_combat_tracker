import './characterStat.scss'

export function CharacterStat({statName, statValue, statModifier}) {

    return (
        <div className="characterStat">
            <div className="statValue">
                {statValue} {statModifier}
            </div>
            <div className="statName">
                {statName}
            </div>
        </div>
    )
}