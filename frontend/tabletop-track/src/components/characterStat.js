import './characterStat.scss'

export function CharacterStat({statName, statValue}) {

    return (
        <div className="characterStat">
            <div className="statValue">
                {statName}
            </div>
            <div className="statName">
                {statValue}
            </div>
        </div>
    )
}