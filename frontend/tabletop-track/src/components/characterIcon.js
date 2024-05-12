import './characterStat.scss'
import './characterIcon.scss'

const images = require.context('../assets/icons', true);

export function CharacterIcon({imagePath}) {
    let imgSrc = images(`./${imagePath}`)

    let styler = {
        backgroundImage: `url(${imgSrc})`
    }

    return (
        <div style={styler} className="characterIcon">
        </div>
    )
}