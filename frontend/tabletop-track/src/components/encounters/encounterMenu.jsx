import { MdArrowBack } from 'react-icons/md';
import { IoMdTrash } from "react-icons/io";
import { GiCancel } from "react-icons/gi";
import { GiConfirmed } from "react-icons/gi";
import { Link } from "react-router-dom";
import { GiSwordsEmblem } from "react-icons/gi";
import './encounterMenu.scss';
import { useState, useEffect } from 'react';
import { BackButton } from '../backButton';

const restHeaders = {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
}
const createEncounterUrl = 'http://localhost:8080/encounter';
const readEncountersUrl = 'http://localhost:8080/encounters';
const deleteEncounterBaseUrl = 'http://localhost:8080/encounter/'; // plus id

function NewEncounterButton() {
    return (
        <div className="newEncounterButton">
            <GiSwordsEmblem id="swordBoardLeft"></GiSwordsEmblem>
            <span>New Encounter</span>
            <GiSwordsEmblem id="swordBoardRight"></GiSwordsEmblem>
        </div>
    )
}

export function EncounterMenu() {

    const [namingNewEncounter, setNamingNewEncounter] = useState(false);
    const [oldEncounters, setOldEncounters] = useState([]);

    const getEncounters = async () => {
        let encounterComps = [];
        fetch(readEncountersUrl, {
            method: 'GET', headers: restHeaders
        }).then((response) => {
            if (!response.ok) {
                throw new Error("Failed to get old Encounters")
            }
            return response.json()
        }).then((data) => {
            if (Object.hasOwn(data, '_embedded')) {
                let encounterData = data._embedded.encounterList;
                encounterData.forEach(encounter => {
                    encounterComps.push(
                        <OldEncounterButton encounterName={encounter.name}
                            encounterId={encounter.id} key={encounterData.indexOf(encounter)} />
                    )
                })
            } else {
                console.log("No Encounters currently");
            }
            setOldEncounters(encounterComps)            
        })
            .catch((error) => {
                console.error("Failed to get Encounters: ", error);
            })
    }

    const deleteEncounter = (encounterId) => {
        fetch(`${deleteEncounterBaseUrl}${encounterId}`, { method: "DELETE" })
            .then(response => {
                if (response.status === 204) {
                    getEncounters()
                }
            })
    }

    useEffect(() => {
        getEncounters()
    }, []);


    function OldEncounterButton({ encounterName, encounterId }) {
        return (
            <div className="oldEncounterButton">
                <IoMdTrash style={{ display: "none" }} /> {/* Invisible for alignment */}
                <span>{encounterName}</span>
                <div className="deleteEncounterWrapper">
                    <IoMdTrash id={encounterName + "-DeleteButton"} onClick={() => deleteEncounter(encounterId)} />
                </div>
            </div>
        )
    }

    // CREATE encounter
    function handleNewEncounterClicked(e) {
        setNamingNewEncounter(!namingNewEncounter); // toggle it
    }
    function NewEncounterTextEntry() {
        const [newEncounterName, setNewEncounterName] = useState('');
        function saveNewEncounter() {
            console.log("Creating new encounter named ", newEncounterName);
            return fetch(createEncounterUrl, {
                method: 'POST',
                headers: restHeaders,
                body: JSON.stringify({
                    name: newEncounterName
                })
            }).then((response) => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error('Failed to create Encounter')
            })
                .then((responseJson) => {
                    // TODO: use response to redirect window
                    console.log("Created encounter, ", responseJson);
                })
                .catch((error) => {
                    console.error("Failed to create Encounter: ", error);
                })
        }
        return (
            <div className="newEncounterButton newEncounterTextBox">
                <div className="encounterTextEntryQuestion">What should we call this encounter?</div>
                <div className="encounterTextEntryWrapper">
                    <input id="newEncounterEntry"
                        value={newEncounterName}
                        onChange={e => setNewEncounterName(e.target.value)} />
                    <GiConfirmed id='submitNewEncounterButton' onClick={(event) => saveNewEncounter(event)} />
                    <GiCancel id='cancelNewEncounterButton' onClick={(event) => handleNewEncounterClicked(event)} />
                </div>
            </div>
        )
    }

    // Default rendering
    if (!namingNewEncounter) {
        return (
            <div className="encounterMenuWrapper">
                <div className="staticHeader">
                    <BackButton/>
                    <span className="headerText">Encounters</span>
                </div>
                 {/* Saved Encounters */}

                <div className="oldEncountersWrapper">
                    {oldEncounters}
                </div>

                 {/* Create new Encounter */}
                <div className="newEncounterButtonWrapper" onClick={(event) => handleNewEncounterClicked(event)} >
                    <NewEncounterButton />
                </div>
            </div>
        )
    }
    // If New Encounter clicked
    return (
        <div className="encounterMenuWrapper">
            <div className="staticHeader">
                <span className="backToMainMenuSection">
                    <Link to={`/`}>
                        <MdArrowBack></MdArrowBack>
                    </Link>
                </span>
                <span className="headerText">Encounters</span>
            </div>

            <div className="newEncounterTextEntryCompWrapper">
                <NewEncounterTextEntry />
            </div>
        </div>
    )
}
