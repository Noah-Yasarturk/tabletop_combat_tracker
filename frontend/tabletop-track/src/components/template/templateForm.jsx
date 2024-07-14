import { useState } from "react"
import { StatValInput } from "./statValInput"
import { BackButton } from "../backButton"

export function CharTemplateForm() {
    const [strengthVal, setStrengthVal] = useState(0)

    return (
        <div class="charTemplateFormWrapper">
            <BackButton></BackButton>
            <StatValInput statName="Strength" currentValue={strengthVal}></StatValInput>
        </div>
    )
}