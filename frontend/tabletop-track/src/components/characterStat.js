import './characterStat.scss'

export function CharacterStat({statName, statValue}) {

    return (
        <div className="characterStat">
            Stat
            <div className="statValue">
                {statName}
            </div>
            <div className="statName">
                {statValue}
            </div>
        </div>
    )
}