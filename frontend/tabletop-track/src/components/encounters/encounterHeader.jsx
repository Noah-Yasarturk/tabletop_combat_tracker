import './encounterHeader.scss'
import { BackButton } from '../backButton'

export function EncounterHeader({encounterName}) {
    return (
        <div className="staticHeader">
            <BackButton/>
            <span className="headerText">{encounterName}</span>
        </div>
    )
}