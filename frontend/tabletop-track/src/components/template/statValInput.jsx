export function StatValInput({statName, currentValue}) {
    return (
        <div class="statValInputWrapper">
            <input class="statValInputElem" value={currentValue}/>
        </div>
    )   
}