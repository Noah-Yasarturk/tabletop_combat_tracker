import './tempStats.scss'

export function TempStats({tempStats}) {

    const tempStatComps = tempStats.map(tempStat => 
            <div class="diamond">
                <span>
                    {tempStat.stat_value}
                </span>
            </div>
    )

    return (
    <div class="tempStatWrapper">
        { tempStatComps}
    </div>
    )
}