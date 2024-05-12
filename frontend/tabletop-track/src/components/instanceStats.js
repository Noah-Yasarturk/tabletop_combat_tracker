import './instanceStats.scss'

export function InstanceStats({instanceStats}) {

    const instanceStatComps = instanceStats.map(instanceStat => 
            <div className="diamond" key={instanceStat.stat_name}>
                <span>
                    {instanceStat.stat_value}
                </span>
            </div>
    )

    return (
    <div className="tempStatWrapper">
        { instanceStatComps}
    </div>
    )
}