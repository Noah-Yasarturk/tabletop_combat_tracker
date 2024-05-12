import './tempStats.scss'

export function TempStats({tempStats}) {

    const tempStatComps = tempStats.map(tempStat => 
            <div className="diamond" key={tempStat.stat_name}>
                <span>
                    {tempStat.stat_value}
                </span>
            </div>
    )

    return (
    <div className="tempStatWrapper">
        { tempStatComps}
    </div>
    )
}