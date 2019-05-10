import React, { Component } from 'react';
import ListJournalsComponent from "./ListJournalsComponent";

class JournalApp extends Component {
    render() {
        return (<>
            <h1>Journal Application</h1>
            <ListJournalsComponent/>
            </>
        )
    }
}

export default JournalApp;
