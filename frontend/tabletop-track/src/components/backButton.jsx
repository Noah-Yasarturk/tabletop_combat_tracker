import { Link } from "react-router-dom";
import { MdArrowBack } from 'react-icons/md';

export function BackButton () {
    return (
        <span className="backToMainMenuSection">
            <Link to={`/`}>
                <MdArrowBack></MdArrowBack>
            </Link>
        </span>
    )
}