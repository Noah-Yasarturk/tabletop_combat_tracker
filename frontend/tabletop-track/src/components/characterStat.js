import './characterStat.scss'

export function CharacterStat({statName, statValue}) {

    return (
        <div className="characterStat">
            <div className="statValue">
                {statValue}
            </div>
            <div className="statName">
                {statName}
            </div>
        </div>
    )
}